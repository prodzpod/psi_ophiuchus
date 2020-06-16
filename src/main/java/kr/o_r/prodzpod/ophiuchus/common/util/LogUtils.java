package kr.o_r.prodzpod.ophiuchus.common.util;

import kr.o_r.prodzpod.ophiuchus.common.Ophiuchus;
import org.apache.logging.log4j.Level;

public class LogUtils {
    public static void log(Object text) {
        log(text.toString());
    }
    public static void log(String text) {
        log(Level.INFO, text);
    }
    public static void log(Level level, String text) {
        if (level == Level.DEBUG && !ThisMod.DEBUG) return;
        Ophiuchus.LOGGER.log(level, "[" + Thread.currentThread().getStackTrace()[2].getClassName() + "] " + text);
    }
}
