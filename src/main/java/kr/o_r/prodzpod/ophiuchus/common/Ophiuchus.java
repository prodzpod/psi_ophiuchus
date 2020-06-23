package kr.o_r.prodzpod.ophiuchus.common;

import kr.o_r.prodzpod.ophiuchus.client.ClientProxy;
import kr.o_r.prodzpod.ophiuchus.common.util.CompatUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.LogUtils;
import kr.o_r.prodzpod.ophiuchus.common.util.ThisMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ThisMod.ID)
public class Ophiuchus
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(ThisMod.ID);
    public static Ophiuchus instance;
    public static ClientProxy proxy;
    public static boolean magical;

    public Ophiuchus() {
        instance = this;
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, null);
        proxy.registerHandlers();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        magical = ModList.get().isLoaded("magipsi");
        LogUtils.log(Level.INFO, "The Thirteenth Zodiac Awakens !!!!!");
        CompatUtils.init();
    }

    public static ResourceLocation OphiuchusLoc(String path) {
        return new ResourceLocation(ThisMod.ID, path);
    }
}
