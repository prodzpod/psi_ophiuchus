package kr.o_r.prodzpod.ophiuchus.client.render;

import kr.o_r.prodzpod.ophiuchus.common.block.BlockPsimetalPlate;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class ColorPsimetalPlateItem implements IItemColor {

    @Override
    public int getColor(ItemStack item, int tint) {
        if (tint == 1) return ((BlockPsimetalPlate) ((BlockItem) item.getItem()).getBlock()).color;
        else return -1;
    }
}
