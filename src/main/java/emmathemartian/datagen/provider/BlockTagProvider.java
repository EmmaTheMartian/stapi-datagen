package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.TagBuilder;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.registry.BlockRegistry;

public abstract class BlockTagProvider extends TagProvider<Block> {
    public BlockTagProvider(DataGenContext context) {
        super("blocks", "Block Tags", context);
    }

    @Override
    protected TagBuilder<Block> tag() {
        return new TagBuilder<>(BlockRegistry.INSTANCE);
    }
}
