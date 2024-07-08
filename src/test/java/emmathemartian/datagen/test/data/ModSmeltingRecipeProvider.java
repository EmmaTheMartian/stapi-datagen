package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.SmeltingRecipeProvider;
import emmathemartian.datagen.test.TestMod;
import emmathemartian.datagen.util.DataIngredient;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

public class ModSmeltingRecipeProvider extends SmeltingRecipeProvider {
    public ModSmeltingRecipeProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        smelting(DataIngredient.of(TagKey.of(ItemRegistry.KEY, TestMod.NAMESPACE.id("dirty_ruby_gems"))), new ItemStack(TestMod.itemRuby))
                .save("dirty_ruby_to_ruby", this, context);
    }
}
