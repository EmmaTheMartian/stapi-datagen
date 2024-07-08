package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.CraftingRecipeProvider;
import emmathemartian.datagen.test.TestMod;
import emmathemartian.datagen.util.DataIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModCraftingRecipeProvider extends CraftingRecipeProvider {
    public ModCraftingRecipeProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        shapeless()
                .ingredient(DataIngredient.of(TestMod.itemRuby))
                .ingredient(DataIngredient.of(Block.DIRT.asItem()))
                .ingredient(DataIngredient.of(Block.DIRT.asItem()))
                .result(new ItemStack(TestMod.itemDirtyRuby))
                .save("dirty_ruby", this, context);

        shapeless()
                .ingredient(DataIngredient.of(TestMod.itemRuby))
                .ingredient(DataIngredient.of(Block.SAND.asItem()))
                .ingredient(DataIngredient.of(Block.SAND.asItem()))
                .result(new ItemStack(TestMod.itemSandyRuby))
                .save("sandy_ruby", this, context);

        shapeless()
                .ingredient(DataIngredient.of(TestMod.itemRuby))
                .ingredient(DataIngredient.of(Block.GRAVEL.asItem()))
                .ingredient(DataIngredient.of(Block.GRAVEL.asItem()))
                .result(new ItemStack(TestMod.itemGravellyRuby))
                .save("gravelly_ruby", this, context);

        shaped()
                .pattern("  R")
                .pattern(" R ")
                .pattern("R  ")
                .define('R', DataIngredient.of(TestMod.itemRuby))
                .result(new ItemStack(TestMod.itemRubyRod))
                .save("ruby_rod", this, context);
    }
}
