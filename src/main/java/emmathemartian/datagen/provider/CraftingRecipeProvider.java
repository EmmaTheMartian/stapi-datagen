package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.ShapedRecipeBuilder;
import emmathemartian.datagen.builder.ShapelessRecipeBuilder;

public abstract class CraftingRecipeProvider extends AbstractRecipeProvider {
    public CraftingRecipeProvider(DataGenContext context) {
        super("crafting", context);
    }

    protected ShapedRecipeBuilder shaped() {
        return new ShapedRecipeBuilder();
    }

    protected ShapelessRecipeBuilder shapeless() {
        return new ShapelessRecipeBuilder();
    }
}
