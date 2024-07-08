package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.BlockModelProvider;
import emmathemartian.datagen.test.TestMod;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        cubeAll()
                .texture("all", TestMod.NAMESPACE.id("block/ruby_block"))
                .save("ruby_block", this, context);
    }
}
