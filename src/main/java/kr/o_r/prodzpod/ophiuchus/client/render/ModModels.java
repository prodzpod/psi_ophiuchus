package kr.o_r.prodzpod.ophiuchus.client.render;

import kr.o_r.prodzpod.ophiuchus.common.tile.TilePsimetalPotato;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ThisMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModModels {
    static boolean registeredModels = false;

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent evt) {
        registeredModels = true;
        ClientRegistry.bindTileEntityRenderer(TilePsimetalPotato.TYPE, RenderTilePsimetalPotato::new);
    }
}
