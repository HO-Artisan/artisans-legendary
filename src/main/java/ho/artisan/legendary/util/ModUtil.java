package ho.artisan.legendary.util;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLLoader;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ModUtil {
    public static void runDist(Dist dist, Runnable run) {
        if (FMLLoader.getDist() == dist) {
            run.run();
        }
    }

    public static void runDist(Dist dist, Thread run) {
        if (FMLLoader.getDist() == dist) {
            run.start();
        }
    }

    public static Future<?> runDistExecutor(Dist dist, Runnable run) {
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            return executor.submit(run);
        }
    }
}
