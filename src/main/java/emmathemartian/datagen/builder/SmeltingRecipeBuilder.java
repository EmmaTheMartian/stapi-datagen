package emmathemartian.datagen.builder;

import com.google.gson.JsonObject;
import emmathemartian.datagen.IDataBuilder;
import emmathemartian.datagen.util.Ingredient;
import emmathemartian.datagen.util.ItemStackHelpers;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.util.Identifier;

public class SmeltingRecipeBuilder implements IDataBuilder {
    public static final Identifier TYPE_ID = Identifier.of("minecraft:smelting");

    protected Ingredient ingredient;
    protected ItemStack result;

    public SmeltingRecipeBuilder ingredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public SmeltingRecipeBuilder result(ItemStack stack) {
        this.result = stack.copy();
        return this;
    }

    @Override
    public JsonObject build() {
        JsonObject object = new JsonObject();
        object.addProperty("type", TYPE_ID.toString());
        object.add("ingredient", this.ingredient.toJson());
        object.add("result", ItemStackHelpers.stackToJson(this.result));
        return object;
    }
}
