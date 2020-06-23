package kr.o_r.prodzpod.ophiuchus.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class BlockPsimetalPlate extends Block {

    public static final IntegerProperty NUMBER = IntegerProperty.create("offset", 0, 8);
    private final int maxNumber;
    public final int color;

    public BlockPsimetalPlate(Properties properties) {
        this(properties, 1, -1);
    }

    public BlockPsimetalPlate(Properties properties, byte maxNumber) {
        this(properties, maxNumber, -1);
    }

    public BlockPsimetalPlate(Properties properties, int color) {
        this(properties, 1, color);
    }

    public BlockPsimetalPlate(Properties properties, int maxNumber, int color) {
        super(properties);
        setDefaultState(getStateContainer().getBaseState().with(NUMBER, 0));
        this.maxNumber = MathHelper.clamp(maxNumber, 1, 9);
        this.color = color;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        BlockPos pos = ctx.getPos();
        return getDefaultState()
                .with(NUMBER, (maxNumber - (pos.getX() + pos.getY() + pos.getZ()) % maxNumber) % maxNumber);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NUMBER);
    }
}
