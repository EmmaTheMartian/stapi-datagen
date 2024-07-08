package emmathemartian.datagen.test.data;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.LangBuilder;
import emmathemartian.datagen.provider.LanguageProvider;
import emmathemartian.datagen.test.TestMod;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenContext context) {
        super(context);
    }

    @Override
    public void run(DataGenContext context) {
        new LangBuilder()
                .add(TestMod.itemRuby, "Ruby")
                .add(TestMod.itemDirtyRuby, "Dirty Ruby")
                .add(TestMod.itemSandyRuby, "Sandy Ruby")
                .add(TestMod.itemGravellyRuby, "Gravelly Ruby")
                .add(TestMod.itemRubyRod, "Ruby Rod")
                .add(TestMod.blockRuby, "Block of Ruby")
                .save("en_US", this, context);
    }
}
