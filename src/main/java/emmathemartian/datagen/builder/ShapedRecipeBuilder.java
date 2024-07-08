package emmathemartian.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import emmathemartian.datagen.util.DataIngredient;
import emmathemartian.datagen.util.ItemStackHelpers;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.*;

public class ShapedRecipeBuilder implements IDataBuilder {
    public static final Identifier TYPE_ID = Identifier.of("minecraft:crafting_shaped");

    protected List<String> pattern = new ArrayList<>();
    protected Map<Character, DataIngredient> key = new HashMap<>();
    protected ItemStack result;

    public ShapedRecipeBuilder pattern(String... patterns) {
        this.pattern.addAll(Arrays.stream(patterns).toList());
        return this;
    }

    public ShapedRecipeBuilder define(char key, DataIngredient ingredient) {
        this.key.put(key, ingredient);
        return this;
    }

    public ShapedRecipeBuilder result(ItemStack stack) {
        this.result = stack.copy();
        return this;
    }

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();

        object.addProperty("type", TYPE_ID.toString());

        JsonArray patternArray = new JsonArray();
        this.pattern.forEach(patternArray::add);
        object.add("pattern", patternArray);

        JsonObject keyObject = new JsonObject();
        this.key.forEach((ch, ing) -> keyObject.add(ch.toString(), ing.toJson()));
        object.add("key", keyObject);

        object.add("result", ItemStackHelpers.stackToJson(this.result));

        return object;
    }
}
