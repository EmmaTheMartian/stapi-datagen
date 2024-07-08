package emmathemartian.datagen;

import com.google.gson.JsonObject;

public interface IDataBuilder {
    JsonObject build();

    default void save(String path, AbstractDataProvider provider, DataGenContext context) {
        context.save(provider.path.resolve(path + ".json"), build());
    }
}
