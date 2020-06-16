package kr.o_r.prodzpod.ophiuchus.common.item.templates;

import kr.o_r.prodzpod.ophiuchus.common.misc.OphiuchusCreativeTab;
import kr.o_r.prodzpod.ophiuchus.common.util.LogUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.NameItems;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
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
public class ModItems {
    private static int registered = 0;

    // @ObjectHolder(NameItems.ITEM_ID) public static Item itemId;
    @ObjectHolder(NameItems.DEBUG_ITEM) public static Item debugItem;

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().group(OphiuchusCreativeTab.INSTANCE);
    }

    private static Item.Properties unstackable() {
        return defaultBuilder().maxStackSize(1);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        LogUtils.log(Level.INFO, "Registering Items");
        registered = 0;

        IForgeRegistry<Item> _r = event.getRegistry();

        // register(_r, new ItemClass(defaultBuilder()), NameBlocks.ITEM_ID);
        register(_r, new Item(defaultBuilder()), NameItems.DEBUG_ITEM);

        LogUtils.log(Level.INFO, "Done Registering Items. " + registered + " blocks registered.");
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, ResourceLocation name) {
        reg.register(thing.setRegistryName(name));
        LogUtils.log(Level.INFO, "Registered Item " + name.toString() + ".");
        registered++;
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, String name) {
        register(reg, thing, new ResourceLocation(ThisMod.ID, name));
    }
}
