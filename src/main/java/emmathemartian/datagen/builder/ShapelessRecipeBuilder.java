package emmathemartian.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import emmathemartian.datagen.util.Ingredient;
import emmathemartian.datagen.util.ItemStackHelpers;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.*;

public class ShapelessRecipeBuilder implements IDataBuilder {
    public static final Identifier TYPE_ID = Identifier.of("minecraft:crafting_shapeless");

    protected List<Ingredient> ingredients = new ArrayList<>();
    protected ItemStack result;

    public ShapelessRecipeBuilder ingredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ShapelessRecipeBuilder result(ItemStack stack) {
        this.result = stack.copy();
        return this;
    }

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();

        object.addProperty("type", TYPE_ID.toString());

        JsonArray ingredientsArray = new JsonArray();
        this.ingredients.forEach(it -> ingredientsArray.add(it.toJson()));
        object.add("ingredients", ingredientsArray);

        object.add("result", ItemStackHelpers.stackToJson(this.result));

        return object;
    }
}
