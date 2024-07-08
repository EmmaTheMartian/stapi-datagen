package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.ItemModelProvider;
import emmathemartian.datagen.test.TestMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        simpleItem(TestMod.itemRuby).save("ruby", this, context);
        simpleItem(TestMod.itemDirtyRuby).save("dirty_ruby", this, context);

        handheldRod()
                .texture("layer0", TestMod.NAMESPACE.id("item/ruby_rod"))
                .save("ruby_rod", this, context);

        blockItem(TestMod.blockRuby).save("ruby_block", this, context);
    }
}
