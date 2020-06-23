package kr.o_r.prodzpod.ophiuchus.client;

import kr.o_r.prodzpod.ophiuchus.client.render.ModColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@OnlyIn(Dist.CLIENT)
public class ClientProxy {

    public void registerHandlers() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        DeferredWorkQueue.runLater(ModColors::init);
    }
}
