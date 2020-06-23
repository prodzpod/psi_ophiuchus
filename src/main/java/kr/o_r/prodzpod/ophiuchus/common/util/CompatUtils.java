package kr.o_r.prodzpod.ophiuchus.common.util;

import net.minecraftforge.fml.ModList;

import java.util.Arrays;

public class CompatUtils {
    // STORES FREQUENTLY USED COMPATIBILITIES IN BOOLEANS SO WE DONT HAVE TO CALL MODLIST EVERY TIME

    // of course you havePsi.
    public static boolean hasRPsi = false; // :(
    public static boolean hasPsipherals = false;
    public static boolean hasPsio = false; // no 1.15 port yet

    public static boolean hasBotania = false;
    public static boolean hasQuark = false;
    public static int hasBotaniaOrQuark = 0;

    public static boolean hasJEI = false;
    public static boolean hasCurios = false;

    public static void init() {

        hasRPsi       = hasModWithCheck(NotThisMod.RPSI);
        hasPsipherals = hasModWithCheck(NotThisMod.PSIPHERALS);
        hasPsio       = hasModWithCheck(NotThisMod.PSIO);

        hasBotania    = hasModWithCheck(NotThisMod.BOTANIA);
        hasQuark      = hasModWithCheck(NotThisMod.QUARK);

        hasJEI        = hasModWithCheck(NotThisMod.JEI);
        hasCurios     = hasModWithCheck(NotThisMod.CURIOS);

        if (hasBotania) hasBotaniaOrQuark = 1;
        else if (hasQuark) hasBotaniaOrQuark = 2;
    }

    public static boolean hasMod(String ...mods) {
        return Arrays.stream(mods).anyMatch(ModList.get()::isLoaded);
    }

    public static boolean hasModWithCheck(String ...mods) {
        LogUtils.log("Checking if mod(s) " + Arrays.toString(mods) + " exists...");
        boolean res = hasMod(mods);
        if (res) LogUtils.log("Found " + Arrays.toString(mods) + ".");
        return res;
    }

    public static String getAsset(String mod) {
        return mod + ":";
    }

    public static String getTexture(String mod) {
        return mod + ":textures/";
    }
}
