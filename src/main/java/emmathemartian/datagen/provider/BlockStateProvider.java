package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.VariantStateBuilder;

public abstract class BlockStateProvider extends AbstractDataProvider {
    public BlockStateProvider(DataGenContext context) {
        super("blockstates", "Block States", context);
    }

    protected VariantStateBuilder variant() {
        return new VariantStateBuilder();
    }
}
