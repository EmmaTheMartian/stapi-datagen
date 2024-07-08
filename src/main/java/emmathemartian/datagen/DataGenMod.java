package emmathemartian.datagen;

import emmathemartian.datagen.entrypoint.DataEntrypoint;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.AfterBlockAndItemRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class DataGenMod {
    @Entrypoint.Logger
    public static final Logger LOGGER = Null.get();

    @EventListener
    private static void onPostRegistries(AfterBlockAndItemRegisterEvent event) {
        String property = System.getProperty("datagen.run");
        if (property == null)
            return;

        final String[] toRun = property.split(",");
        LOGGER.info("Data generator will be executed for mods: [{}]", String.join(", ", toRun));
        LOGGER.info("Note: The game will be stopped after data generation finishes.");

        if (toRun.length > 0) {
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
