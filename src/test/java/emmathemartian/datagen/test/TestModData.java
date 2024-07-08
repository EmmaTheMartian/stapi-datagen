package emmathemartian.datagen.test;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.entrypoint.DataEntrypoint;
import emmathemartian.datagen.provider.CraftingRecipeProvider;
import emmathemartian.datagen.test.data.*;
import emmathemartian.datagen.util.DataIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TestModData implements DataEntrypoint {
    @Override
    public void run() {
        DataGenContext context = new DataGenContext(TestMod.NAMESPACE);

        // Assets
        context.run(ModItemModelProvider::new);
        context.run(ModBlockModelProvider::new);
        context.run(ModBlockStateProvider::new);
        context.run(ModLangProvider::new);

        // Data
        context.run(ModCraftingRecipeProvider::new);
        context.run(ModSmeltingRecipeProvider::new);
        context.run(ModBlockTagProvider::new);
        context.run(ModItemTagProvider::new);

        // For smaller providers you can just use an anonymous object :p
        context.run(new CraftingRecipeProvider(context) {
            @Override
            public void run(DataGenContext context) {
                shapeless()
                        .ingredient(DataIngredient.of(Block.DIRT.asItem()))
                        .ingredient(DataIngredient.of(Item.WATER_BUCKET))
                        .result(new ItemStack(Block.CLAY.asItem()))
                        .save("dirt_to_clay", this, context);
            }
        });
    }
}
