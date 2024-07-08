package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.TagBuilder;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.registry.ItemRegistry;

public abstract class ItemTagProvider extends TagProvider<Item> {
    public ItemTagProvider(DataGenContext context) {
        super("items", "Item Tags", context);
    }

    @Override
    protected TagBuilder<Item> tag() {
        return new TagBuilder<>(ItemRegistry.INSTANCE);
    }
}
