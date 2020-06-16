package kr.o_r.prodzpod.ophiuchus.common.block.templates;

import kr.o_r.prodzpod.ophiuchus.common.block.BlockPsimetalPlate;
import kr.o_r.prodzpod.ophiuchus.common.item.templates.ModItems;
import kr.o_r.prodzpod.ophiuchus.common.util.LogUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.NameBlocks;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
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

    // @ObjectHolder(NameBlocks.ITEM_ID) public static Block itemId;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK_RAINBOW) public static Block psimetalPlateBlackRainbow;
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE_RAINBOW) public static Block psimetalPlateWhiteRainbow;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        LogUtils.log(Level.INFO, "Registering Blocks");
        registered = 0;

        IForgeRegistry<Block> _r = event.getRegistry();
        Block.Properties properties;

        // register(_r, new BlockClass(properties), NameBlocks.ITEM_ID);
        properties = Block.Properties.create(Material.IRON).hardnessAndResistance(5, 10).sound(SoundType.METAL).lightValue(15);
        register(_r, new BlockPsimetalPlate(properties), NameBlocks.PSIMETAL_PLATE_BLACK_RAINBOW);
        register(_r, new BlockPsimetalPlate(properties), NameBlocks.PSIMETAL_PLATE_WHITE_RAINBOW);

        LogUtils.log(Level.INFO, "Done Registering Blocks. " + registered + " blocks registered.");
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        LogUtils.log(Level.INFO, "Registering ItemBlocks");
        registered = 0;

        IForgeRegistry<Item> _r = evt.getRegistry();
        Item.Properties props = ModItems.defaultBuilder();

    //  register(_r, new BlockItem(itemId, props), itemId.getRegistryName());
        register(_r, new BlockItem(psimetalPlateBlackRainbow, props), psimetalPlateBlackRainbow.getRegistryName());
        register(_r, new BlockItem(psimetalPlateWhiteRainbow, props), psimetalPlateWhiteRainbow.getRegistryName());

        LogUtils.log(Level.INFO, "Done Registering ItemBlocks. " + registered + " itemblocks registered.");
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
