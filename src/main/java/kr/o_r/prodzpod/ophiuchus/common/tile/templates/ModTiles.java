package kr.o_r.prodzpod.ophiuchus.common.tile.templates;

import kr.o_r.prodzpod.ophiuchus.common.block.templates.ModBlocks;
import kr.o_r.prodzpod.ophiuchus.common.tile.TilePsimetalPotato;
import kr.o_r.prodzpod.ophiuchus.common.util.CompatUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.LogUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.NameBlocks;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraft.tileentity.TileEntityType;
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
public class ModTiles {
    private static int registered = 0;

    @SubscribeEvent
    public static void initTileEntities(RegistryEvent.Register<TileEntityType<?>> event) {
        LogUtils.log(Level.INFO, "Registering TileEntities");
        registered = 0;
        IForgeRegistry<TileEntityType<?>> _r = event.getRegistry();

        if (CompatUtils.hasBotaniaOrQuark > 0) {
            register(_r, TileEntityType.Builder.create(TilePsimetalPotato::new, ModBlocks.psimetalPotato).build(null), NameBlocks.PSIMETAL_POTATO);
        }

        LogUtils.log(Level.INFO, "Done Registering TileEntities. " + registered + " tileEntities registered.");
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, ResourceLocation name) {
        reg.register(thing.setRegistryName(name));
        LogUtils.log(Level.INFO, "Registered TileEntity " + name.toString() + ".");
        registered++;
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> thing, String name) {
        register(reg, thing, new ResourceLocation(ThisMod.ID, name));
    }
}
