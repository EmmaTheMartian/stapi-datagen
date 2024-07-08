package emmathemartian.datagen.builder;

import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModelBuilder implements IDataBuilder {
    protected Identifier parent;
    protected Map<String, Identifier> textures = new HashMap<>();

    public ModelBuilder parent(Identifier value) {
        this.parent = value;
        return this;
    }

    public ModelBuilder texture(String name, Identifier texture) {
        this.textures.put(name, texture);
        return this;
    }

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();

        object.addProperty("parent", this.parent.toString());

        if (!this.textures.isEmpty()) {
            JsonObject texturesObject = new JsonObject();
            this.textures.forEach((key, texture) -> texturesObject.addProperty(key, texture.toString()));
            object.add("textures", texturesObject);
        }

        return object;
    }
}
