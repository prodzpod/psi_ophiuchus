package kr.o_r.prodzpod.ophiuchus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockPsimetalPlate extends Block {

    public static final IntegerProperty NUMBER = IntegerProperty.create("offset", 0, 8);

    public BlockPsimetalPlate(Properties properties) {
        super(properties);
        setDefaultState(getStateContainer().getBaseState().with(NUMBER, 0));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        int number = (9 - (pos.getX() + pos.getY() + pos.getZ()) % 9) % 9;
        worldIn.setBlockState(pos, state.with(NUMBER, number));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NUMBER);
    }
}
