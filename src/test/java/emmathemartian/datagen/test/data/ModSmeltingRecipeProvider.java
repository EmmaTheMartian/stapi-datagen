package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.SmeltingRecipeProvider;
import emmathemartian.datagen.test.TestMod;
import emmathemartian.datagen.util.Ingredient;
import net.minecraft.item.ItemStack;

public class ModSmeltingRecipeProvider extends SmeltingRecipeProvider {
    public ModSmeltingRecipeProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        smelting(Ingredient.of(TestMod.itemDirtyRuby), new ItemStack(TestMod.itemRuby))
                .save("dirty_ruby_to_ruby", this, context);
    }
}
