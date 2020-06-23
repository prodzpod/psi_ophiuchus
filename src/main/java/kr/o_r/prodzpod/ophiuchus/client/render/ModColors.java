package kr.o_r.prodzpod.ophiuchus.client.render;

import kr.o_r.prodzpod.ophiuchus.common.block.templates.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;

public class ModColors {
    public static void init() {
        BlockColors _r = Minecraft.getInstance().getBlockColors();
        ItemColors _rI = Minecraft.getInstance().getItemColors();
        _r.register(new ColorPsimetalPlate(),
                ModBlocks.psimetalPlateWhiteWhite,
                ModBlocks.psimetalPlateWhiteGray,
                ModBlocks.psimetalPlateWhiteLightGray,
                ModBlocks.psimetalPlateWhiteBlack,
                ModBlocks.psimetalPlateWhiteRed,
                ModBlocks.psimetalPlateWhiteOrange,
                ModBlocks.psimetalPlateWhiteYellow,
                ModBlocks.psimetalPlateWhiteLime,
                ModBlocks.psimetalPlateWhiteGreen,
                ModBlocks.psimetalPlateWhiteCyan,
                ModBlocks.psimetalPlateWhiteLightBlue,
                ModBlocks.psimetalPlateWhiteBlue,
                ModBlocks.psimetalPlateWhitePurple,
                ModBlocks.psimetalPlateWhiteMagenta,
                ModBlocks.psimetalPlateWhitePink,
                ModBlocks.psimetalPlateWhiteBrown,
                ModBlocks.psimetalPlateBlackWhite,
                ModBlocks.psimetalPlateBlackGray,
                ModBlocks.psimetalPlateBlackLightGray,
                ModBlocks.psimetalPlateBlackBlack,
                ModBlocks.psimetalPlateBlackRed,
                ModBlocks.psimetalPlateBlackOrange,
                ModBlocks.psimetalPlateBlackYellow,
                ModBlocks.psimetalPlateBlackLime,
                ModBlocks.psimetalPlateBlackGreen,
                ModBlocks.psimetalPlateBlackCyan,
                ModBlocks.psimetalPlateBlackLightBlue,
                ModBlocks.psimetalPlateBlackBlue,
                ModBlocks.psimetalPlateBlackPurple,
                ModBlocks.psimetalPlateBlackMagenta,
                ModBlocks.psimetalPlateBlackPink,
                ModBlocks.psimetalPlateBlackBrown
        );

        _rI.register(new ColorPsimetalPlateItem(),
                ModBlocks.psimetalPlateWhiteWhite,
                ModBlocks.psimetalPlateWhiteGray,
                ModBlocks.psimetalPlateWhiteLightGray,
                ModBlocks.psimetalPlateWhiteBlack,
                ModBlocks.psimetalPlateWhiteRed,
                ModBlocks.psimetalPlateWhiteOrange,
                ModBlocks.psimetalPlateWhiteYellow,
                ModBlocks.psimetalPlateWhiteLime,
                ModBlocks.psimetalPlateWhiteGreen,
                ModBlocks.psimetalPlateWhiteCyan,
                ModBlocks.psimetalPlateWhiteLightBlue,
                ModBlocks.psimetalPlateWhiteBlue,
                ModBlocks.psimetalPlateWhitePurple,
                ModBlocks.psimetalPlateWhiteMagenta,
                ModBlocks.psimetalPlateWhitePink,
                ModBlocks.psimetalPlateWhiteBrown,
                ModBlocks.psimetalPlateBlackWhite,
                ModBlocks.psimetalPlateBlackGray,
                ModBlocks.psimetalPlateBlackLightGray,
                ModBlocks.psimetalPlateBlackBlack,
                ModBlocks.psimetalPlateBlackRed,
                ModBlocks.psimetalPlateBlackOrange,
                ModBlocks.psimetalPlateBlackYellow,
                ModBlocks.psimetalPlateBlackLime,
                ModBlocks.psimetalPlateBlackGreen,
                ModBlocks.psimetalPlateBlackCyan,
                ModBlocks.psimetalPlateBlackLightBlue,
                ModBlocks.psimetalPlateBlackBlue,
                ModBlocks.psimetalPlateBlackPurple,
                ModBlocks.psimetalPlateBlackMagenta,
                ModBlocks.psimetalPlateBlackPink,
                ModBlocks.psimetalPlateBlackBrown
        );
    }
}
