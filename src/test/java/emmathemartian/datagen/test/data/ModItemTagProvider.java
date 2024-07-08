package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.provider.ItemTagProvider;
import emmathemartian.datagen.test.TestMod;

public class ModItemTagProvider extends ItemTagProvider {
    public ModItemTagProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        tag()
                .add(TestMod.itemRuby)
                .add(TestMod.itemDirtyRuby)
                .save("ruby_gems", this, context);

        tag()
                .add(TestMod.itemDirtyRuby)
                .add(TestMod.itemSandyRuby)
                .add(TestMod.itemGravellyRuby)
                .save("dirty_ruby_gems", this, context);
    }
}
