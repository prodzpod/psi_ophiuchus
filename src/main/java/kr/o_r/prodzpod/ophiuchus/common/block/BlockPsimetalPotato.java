package kr.o_r.prodzpod.ophiuchus.common.block;

import kr.o_r.prodzpod.ophiuchus.common.tile.TilePsimetalPotato;
import kr.o_r.prodzpod.ophiuchus.common.tile.templates.TileSimpleInventory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;

public class BlockPsimetalPotato extends Block implements IWaterLoggable {
    private static final VoxelShape SHAPE = makeCuboidShape(6, 0, 6, 10, 6, 10);
    private static final int JUMP_EVENT = 0;

    public BlockPsimetalPotato(Properties builder) {
        super(builder);
        setDefaultState(stateContainer.getBaseState()
                .with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .with(BlockStateProperties.WATERLOGGED, false));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        Direction facing = ctx.getPlacementHorizontalFacing().getOpposite();
        boolean waterlogged = ctx.getWorld().getFluidState(ctx.getPos()).getFluid() == Fluids.WATER;

        return getDefaultState()
                .with(BlockStateProperties.HORIZONTAL_FACING, facing)
                .with(BlockStateProperties.WATERLOGGED      , waterlogged);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(BlockStateProperties.WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return stateIn;
    }

    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(BlockStateProperties.WATERLOGGED) ?
                Fluids.WATER.getStillFluidState(false) :
                super.getFluidState(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return !state.get(BlockStateProperties.WATERLOGGED);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new TilePsimetalPotato();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TilePsimetalPotato) {
            ((TilePsimetalPotato) tile).interact(player, hand, player.getHeldItem(hand), hit.getFace());
            if (!world.isRemote) {
                AxisAlignedBB box = SHAPE.getBoundingBox();
                ((ServerWorld) world).spawnParticle(ParticleTypes.HEART, pos.getX() + box.minX + Math.random() * (box.maxX - box.minX), pos.getY() + box.maxY, pos.getZ() + box.minZ + Math.random() * (box.maxZ - box.minZ), 1, 0, 0, 0, 0);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onReplaced(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileSimpleInventory inv = (TileSimpleInventory) world.getTileEntity(pos);
            if (inv != null) {
                for (int j1 = 0; j1 < inv.getSizeInventory(); ++j1) {
                    ItemStack itemstack = inv.getItemHandler().getStackInSlot(j1);
                    if (!itemstack.isEmpty()) {
                        net.minecraft.inventory.InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemstack);
                    }
                }
                world.updateComparatorOutputLevel(pos, state.getBlock());
            }
            super.onReplaced(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public boolean eventReceived(BlockState state, World world, BlockPos pos, int id, int param) {
        TileEntity potato = world.getTileEntity(pos);
        if (id == JUMP_EVENT && potato instanceof TilePsimetalPotato) {
            ((TilePsimetalPotato) potato).jumpTicks = param;
            return true;
        } else {
            return super.eventReceived(state, world, pos, id, param);
        }
    }
}
