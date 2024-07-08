package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.SmeltingRecipeBuilder;
import emmathemartian.datagen.util.DataIngredient;
import net.minecraft.item.ItemStack;

public abstract class SmeltingRecipeProvider extends AbstractRecipeProvider {
    public SmeltingRecipeProvider(DataGenContext context) {
        super("smelting", context);
    }

    protected SmeltingRecipeBuilder smelting() {
        return new SmeltingRecipeBuilder();
    }

    protected SmeltingRecipeBuilder smelting(DataIngredient input, ItemStack output) {
        return new SmeltingRecipeBuilder()
                .ingredient(input)
                .result(output);
    }
}
