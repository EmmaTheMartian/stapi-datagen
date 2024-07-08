package emmathemartian.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import net.modificationstation.stationapi.api.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagBuilder<T> implements IDataBuilder {
    protected final Registry<T> registry;
    protected final List<T> entries = new ArrayList<>();

    public TagBuilder(Registry<T> registry) {
        this.registry = registry;
    }

    public TagBuilder<T> add(T entry) {
        this.entries.add(entry);
        return this;
    }

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();

        JsonArray entriesArray = new JsonArray();
        entries.forEach(it -> entriesArray.add(Objects.requireNonNull(registry.getId(it)).toString()));
        object.add("values", entriesArray);

        return object;
    }
}
