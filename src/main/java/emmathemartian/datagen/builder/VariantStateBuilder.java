package emmathemartian.datagen.builder;

import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import net.modificationstation.stationapi.api.state.property.Property;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class VariantStateBuilder implements IDataBuilder {
    public Map<String, Variant> variants = new HashMap<>();

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();

        JsonObject variantsObject = new JsonObject();
        this.variants.forEach((key, variant) -> variantsObject.add(key, variant.build()));
        object.add("variants", variantsObject);

        return object;
    }

    public <T extends Comparable<T>> VariantStateBuilder variant(Property<T> property, T value, Variant variant) {
        return variant(property.getName() + "=" + value, variant);
    }

    public <T extends Comparable<T>> VariantStateBuilder variant(String property, Variant variant) {
        this.variants.put(property, variant);
        return this;
    }

    public <T extends Comparable<T>> VariantStateBuilder variant(Property<T> property, T value, Identifier variantId) {
        return variant(property.getName() + "=" + value, variantId);
    }

    public <T extends Comparable<T>> VariantStateBuilder variant(String property, Identifier variantId) {
        this.variants.put(property, Variant.of(variantId));
        return this;
    }

    public record Variant(Identifier model, int x, int y, boolean uvlock, int weight) {
        public JsonObject build() {
            JsonObject object = new JsonObject();

            object.addProperty("model", this.model.toString());

            if (x != 0)
                object.addProperty("x", this.x);

            if (y != 0)
                object.addProperty("y", this.y);

            if (uvlock)
                object.addProperty("uvlock", true);

            if (weight != 0)
                object.addProperty("weight", this.weight);

            return object;
        }

        public static Variant of(Identifier model) {
            return new Variant(model, 0, 0, false, 1);
        }
    }
}
