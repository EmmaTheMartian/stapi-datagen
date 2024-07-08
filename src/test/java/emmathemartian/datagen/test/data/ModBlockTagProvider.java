package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.BlockTagProvider;
import emmathemartian.datagen.test.TestMod;
import net.minecraft.block.Block;

public class ModBlockTagProvider extends BlockTagProvider {
    public ModBlockTagProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        tag()
                .add(Block.DIAMOND_BLOCK)
                .add(TestMod.blockRuby)
                .save("gem_blocks", this, context);
    }
}
