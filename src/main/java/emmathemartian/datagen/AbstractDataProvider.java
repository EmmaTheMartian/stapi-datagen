package emmathemartian.datagen;

import java.nio.file.Path;

public abstract class AbstractDataProvider {
    public final Path path;
    public final String name;

    public AbstractDataProvider(String path, String name, DataTarget target, DataGenContext context) {
        this.path = target.getPath(context).resolve(path);
        this.name = name;
    }

    public abstract void run(DataGenContext context);
}
