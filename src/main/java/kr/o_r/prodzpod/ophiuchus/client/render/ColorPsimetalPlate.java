package kr.o_r.prodzpod.ophiuchus.client.render;

import kr.o_r.prodzpod.ophiuchus.common.block.BlockPsimetalPlate;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;

import javax.annotation.Nullable;

public class ColorPsimetalPlate implements IBlockColor {
    @Override
    public int getColor(BlockState state, @Nullable ILightReader light, @Nullable BlockPos pos, int tint) {
        if (tint == 1) return ((BlockPsimetalPlate) state.getBlock()).color;
        else return -1;
    }
}
