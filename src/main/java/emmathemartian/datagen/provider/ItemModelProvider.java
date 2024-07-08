package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.ModelBuilder;
import emmathemartian.datagen.util.Models;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.ItemRegistry;

import java.util.Objects;

public abstract class ItemModelProvider extends AbstractModelProvider {
    public ItemModelProvider(DataGenContext context) {
        super("item", "Item Models", context);
    }

    protected ModelBuilder model() {
        return new ModelBuilder();
    }

    protected ModelBuilder generated() {
        return new ModelBuilder().parent(Models.Item.GENERATED.id);
    }

    protected ModelBuilder handheld() {
        return new ModelBuilder().parent(Models.Item.HANDHELD.id);
    }

    protected ModelBuilder handheldRod() {
        return new ModelBuilder().parent(Models.Item.HANDHELD_ROD.id);
    }

    protected ModelBuilder blockItem(Block block) {
        return new ModelBuilder().parent(Objects.requireNonNull(BlockRegistry.INSTANCE.getId(block)).withPrefixedPath("block/"));
    }

    protected ModelBuilder simpleItem(Item item) {
        return generated().texture("layer0", Objects.requireNonNull(ItemRegistry.INSTANCE.getId(item)).withPrefixedPath("item/"));
    }
}
