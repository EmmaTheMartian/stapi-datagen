package emmathemartian.datagen;

import emmathemartian.datagen.entrypoint.DataEntrypoint;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.modificationstation.stationapi.api.event.registry.DimensionRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Objects;

public class DataGenMod {
    @Entrypoint.Logger
    public static final Logger LOGGER = Null.get();

    public static Path targetPath;

    private static Path getTargetPath() {
        String strPath = Objects.requireNonNull(System.getProperty("datagen.path"), "System property datagen.path was null. Make sure it is defined in your buildscript.");
        return Path.of(strPath);
    }

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.LOWEST)
    private static void onPostRegistries(DimensionRegistryEvent event) {
        String property = System.getProperty("datagen.run");
        if (property == null)
            return;

        final String[] toRun = property.split(",");
        LOGGER.info("Data generator will be executed for mods: [{}]", String.join(", ", toRun));
        LOGGER.info("Data generation target path is `{}`", getTargetPath());
        LOGGER.info("Note: The game will be stopped after data generation finishes.");

        if (toRun.length > 0) {
            targetPath = getTargetPath();

            if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
                throw new DataGenException("Data generators should not be executed in production environments. Exiting.");
            }

            FabricLoader.getInstance()
                    .getEntrypointContainers("data", DataEntrypoint.class)
                    .forEach(entrypoint -> entrypoint.getEntrypoint().run());

            LOGGER.info("Data generation finished, closing game.");
            System.exit(0);
        }
    }
}
