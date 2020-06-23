package kr.o_r.prodzpod.ophiuchus.common.block.templates;

import kr.o_r.prodzpod.ophiuchus.common.block.BlockPsimetalPlate;
import kr.o_r.prodzpod.ophiuchus.common.block.BlockPsimetalPotato;
import kr.o_r.prodzpod.ophiuchus.common.item.templates.ModItems;
import kr.o_r.prodzpod.ophiuchus.common.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = ThisMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(ThisMod.ID)
public class ModBlocks {
    private static int registered = 0;
    private static IForgeRegistry<Item> itemBlockRegistry;
    private static Item.Properties itemBlockProperties;

    // @ObjectHolder(NameBlocks.ITEM_ID) public static Block itemId;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.WHITE     ) public static Block psimetalPlateBlackWhite    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.WHITE     ) public static Block psimetalPlateWhiteWhite    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIGHT_GRAY) public static Block psimetalPlateBlackLightGray;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIGHT_GRAY) public static Block psimetalPlateWhiteLightGray;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.GRAY      ) public static Block psimetalPlateBlackGray     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.GRAY      ) public static Block psimetalPlateWhiteGray     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BLACK     ) public static Block psimetalPlateBlackBlack    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BLACK     ) public static Block psimetalPlateWhiteBlack    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.RED       ) public static Block psimetalPlateBlackRed      ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.RED       ) public static Block psimetalPlateWhiteRed      ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.ORANGE    ) public static Block psimetalPlateBlackOrange   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.ORANGE    ) public static Block psimetalPlateWhiteOrange   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.YELLOW    ) public static Block psimetalPlateBlackYellow   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.YELLOW    ) public static Block psimetalPlateWhiteYellow   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIME      ) public static Block psimetalPlateBlackLime     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIME      ) public static Block psimetalPlateWhiteLime     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.GREEN     ) public static Block psimetalPlateBlackGreen    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.GREEN     ) public static Block psimetalPlateWhiteGreen    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.CYAN      ) public static Block psimetalPlateBlackCyan     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.CYAN      ) public static Block psimetalPlateWhiteCyan     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIGHT_BLUE) public static Block psimetalPlateBlackLightBlue;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIGHT_BLUE) public static Block psimetalPlateWhiteLightBlue;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BLUE      ) public static Block psimetalPlateBlackBlue     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BLUE      ) public static Block psimetalPlateWhiteBlue     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PURPLE    ) public static Block psimetalPlateBlackPurple   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PURPLE    ) public static Block psimetalPlateWhitePurple   ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.MAGENTA   ) public static Block psimetalPlateBlackMagenta  ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.MAGENTA   ) public static Block psimetalPlateWhiteMagenta  ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PINK      ) public static Block psimetalPlateBlackPink     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PINK      ) public static Block psimetalPlateWhitePink     ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BROWN     ) public static Block psimetalPlateBlackBrown    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BROWN     ) public static Block psimetalPlateWhiteBrown    ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.RAINBOW   ) public static Block psimetalPlateBlackRainbow  ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.RAINBOW   ) public static Block psimetalPlateWhiteRainbow  ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PSI       ) public static Block psimetalPlateBlackPsi      ;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PSI       ) public static Block psimetalPlateWhitePsi      ;

    @ObjectHolder(NameBlocks.PSIMETAL_POTATO                             ) public static Block psimetalPotato;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        LogUtils.log(Level.INFO, "Registering Blocks");
        registered = 0;

        IForgeRegistry<Block> _r = event.getRegistry();
        Block.Properties properties;

        // register(_r, new BlockClass(properties), NameBlocks.ITEM_ID);
        properties = Block.Properties.create(Material.IRON).hardnessAndResistance(5, 10).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2);
        if (CompatUtils.hasBotaniaOrQuark > 0)
            register(_r, new BlockPsimetalPotato(properties), NameBlocks.PSIMETAL_POTATO             );
        properties = properties.lightValue(15);
        if (!CompatUtils.hasRPsi) {
            register(_r, new BlockPsimetalPlate(properties, DyeColor.WHITE.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.WHITE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.WHITE.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.WHITE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIGHT_GRAY.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIGHT_GRAY);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIGHT_GRAY.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIGHT_GRAY);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.GRAY.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.GRAY);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.GRAY.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.GRAY);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BLACK.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BLACK);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BLACK.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BLACK);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.RED.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.RED);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.RED.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.RED);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.ORANGE.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.ORANGE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.ORANGE.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.ORANGE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.YELLOW.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.YELLOW);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.YELLOW.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.YELLOW);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIME.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIME);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIME.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIME);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.GREEN.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.GREEN);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.GREEN.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.GREEN);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.CYAN.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.CYAN);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.CYAN.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.CYAN);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIGHT_BLUE.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.LIGHT_BLUE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.LIGHT_BLUE.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.LIGHT_BLUE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BLUE.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BLUE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BLUE.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BLUE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.PURPLE.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PURPLE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.PURPLE.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PURPLE);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.MAGENTA.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.MAGENTA);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.MAGENTA.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.MAGENTA);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.PINK.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PINK);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.PINK.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PINK);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BROWN.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.BROWN);
            register(_r, new BlockPsimetalPlate(properties, DyeColor.BROWN.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.BROWN);
        }
            register(_r, new BlockPsimetalPlate (properties, (byte)9)                            , NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.RAINBOW   );
            register(_r, new BlockPsimetalPlate (properties, (byte)9)                            , NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.RAINBOW   );
            register(_r, new BlockPsimetalPlate (properties, (byte)2)                            , NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.PSI       );
            register(_r, new BlockPsimetalPlate (properties, (byte)2)                            , NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.PSI       );

        LogUtils.log(Level.INFO, "Done Registering Blocks. " + registered + " blocks registered.");
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        LogUtils.log(Level.INFO, "Registering ItemBlocks");
        registered = 0;

        itemBlockRegistry = evt.getRegistry();
        itemBlockProperties = ModItems.defaultBuilder();

        if (!CompatUtils.hasRPsi) {
            registerItemBlock(psimetalPlateBlackWhite);
            registerItemBlock(psimetalPlateWhiteWhite);
            registerItemBlock(psimetalPlateBlackLightGray);
            registerItemBlock(psimetalPlateWhiteLightGray);
            registerItemBlock(psimetalPlateBlackGray);
            registerItemBlock(psimetalPlateWhiteGray);
            registerItemBlock(psimetalPlateBlackBlack);
            registerItemBlock(psimetalPlateWhiteBlack);
            registerItemBlock(psimetalPlateBlackRed);
            registerItemBlock(psimetalPlateWhiteRed);
            registerItemBlock(psimetalPlateBlackOrange);
            registerItemBlock(psimetalPlateWhiteOrange);
            registerItemBlock(psimetalPlateBlackYellow);
            registerItemBlock(psimetalPlateWhiteYellow);
            registerItemBlock(psimetalPlateBlackLime);
            registerItemBlock(psimetalPlateWhiteLime);
            registerItemBlock(psimetalPlateBlackGreen);
            registerItemBlock(psimetalPlateWhiteGreen);
            registerItemBlock(psimetalPlateBlackCyan);
            registerItemBlock(psimetalPlateWhiteCyan);
            registerItemBlock(psimetalPlateBlackLightBlue);
            registerItemBlock(psimetalPlateWhiteLightBlue);
            registerItemBlock(psimetalPlateBlackBlue);
            registerItemBlock(psimetalPlateWhiteBlue);
            registerItemBlock(psimetalPlateBlackPurple);
            registerItemBlock(psimetalPlateWhitePurple);
            registerItemBlock(psimetalPlateBlackMagenta);
            registerItemBlock(psimetalPlateWhiteMagenta);
            registerItemBlock(psimetalPlateBlackPink);
            registerItemBlock(psimetalPlateWhitePink);
            registerItemBlock(psimetalPlateBlackBrown);
            registerItemBlock(psimetalPlateWhiteBrown);
        }
            registerItemBlock(psimetalPlateBlackRainbow  );
            registerItemBlock(psimetalPlateWhiteRainbow  );
            registerItemBlock(psimetalPlateBlackPsi      );
            registerItemBlock(psimetalPlateWhitePsi      );
        if (CompatUtils.hasBotaniaOrQuark > 0) {
            registerItemBlock(psimetalPotato);
        }

        LogUtils.log(Level.INFO, "Done Registering ItemBlocks. " + registered + " itemblocks registered.");
    }

    private static void registerItemBlock(Block block) {
        register(itemBlockRegistry, new BlockItem(block, itemBlockProperties), block.getRegistryName());
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, ResourceLocation name) {
        reg.register(thing.setRegistryName(name));
        LogUtils.log(Level.INFO, "Registered Block " + name.toString() + ".");
        registered++;
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, String name) {
        register(reg, thing, new ResourceLocation(ThisMod.ID, name));
    }
}
