package emmathemartian.datagen;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.modificationstation.stationapi.api.util.Namespace;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public class DataGenContext {
    public final Namespace namespace;
    public final Path root;

    public DataGenContext(Namespace namespace, String rootPath) {
        this.namespace = namespace;
        this.root = Path.of(rootPath);
    }

    public void run(Function<DataGenContext, AbstractDataProvider> provider) {
        run(provider.apply(this));
    }

    public void run(AbstractDataProvider provider) {
        DataGenMod.LOGGER.info("Running data provider: [{}] {}", namespace.getName(), provider.name);
        provider.run(this);
    }

    public void save(Path path, String data) {
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, List.of(data), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new DataGenException("Failed to save file: `" + path + "`. IOException message is: " + e.getMessage());
        }
    }

    public void save(Path path, JsonObject object) {
        save(path, new Gson().toJson(object));
    }
}
