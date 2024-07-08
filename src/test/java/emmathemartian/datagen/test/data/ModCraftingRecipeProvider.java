package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.CraftingRecipeProvider;
import emmathemartian.datagen.test.TestMod;
import emmathemartian.datagen.util.Ingredient;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCraftingRecipeProvider extends CraftingRecipeProvider {
    public ModCraftingRecipeProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        shapeless()
                .ingredient(Ingredient.of(Item.DIAMOND))
                .ingredient(Ingredient.of(Block.DIRT.asItem()))
                .ingredient(Ingredient.of(Block.DIRT.asItem()))
                .result(new ItemStack(TestMod.itemDirtyRuby))
                .save("dirty_ruby", this, context);

        shaped()
                .pattern("  R")
                .pattern(" R ")
                .pattern("R  ")
                .define('R', Ingredient.of(TestMod.itemRuby))
                .result(new ItemStack(TestMod.itemRubyRod))
                .save("ruby_rod", this, context);
    }
}
