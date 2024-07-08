package emmathemartian.datagen;

import java.nio.file.Path;

public record DataTarget(String target) {
    public static final DataTarget ASSETS = new DataTarget("assets");
    public static final DataTarget DATA = new DataTarget("data");

    public Path getPath(DataGenContext context) {
        return context.getTargetPath(target);
    }
}
