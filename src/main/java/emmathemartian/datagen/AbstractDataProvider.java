package emmathemartian.datagen;

import java.nio.file.Path;

public abstract class AbstractDataProvider {
    public final Path path;
    public final String name;

    public AbstractDataProvider(String path, String name, DataGenContext context) {
        this.path = context.root.resolve(path);
        this.name = name;
    }

    public abstract void run(DataGenContext context);
}
