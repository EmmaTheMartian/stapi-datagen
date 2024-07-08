package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.BlockStateProvider;
import emmathemartian.datagen.test.TestMod;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        variant()
                .variant("", TestMod.NAMESPACE.id("block/ruby_block"))
                .save("ruby_block", this, context);
    }
}
