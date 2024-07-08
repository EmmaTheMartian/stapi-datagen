package emmathemartian.datagen.test;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.entrypoint.DataEntrypoint;
import emmathemartian.datagen.provider.CraftingRecipeProvider;
import emmathemartian.datagen.test.data.*;
import emmathemartian.datagen.util.Ingredient;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TestModData implements DataEntrypoint {
    @Override
    public void run() {
        DataGenContext context = new DataGenContext(TestMod.NAMESPACE, "../src/generated/resources/assets/datagen_test/stationapi/");
        context.run(ModItemModelProvider::new);
        context.run(ModBlockModelProvider::new);
        context.run(ModBlockStateProvider::new);
        context.run(ModCraftingRecipeProvider::new);
        context.run(ModSmeltingRecipeProvider::new);
        context.run(ModLangProvider::new);

        context.run(new CraftingRecipeProvider(context) {
            @Override
            public void run(DataGenContext context) {
                shapeless()
                        .ingredient(Ingredient.of(Block.DIRT.asItem()))
                        .ingredient(Ingredient.of(Item.WATER_BUCKET))
                        .result(new ItemStack(Block.CLAY.asItem()))
                        .save("dirt_to_clay", this, context);
            }
        });
    }
}
