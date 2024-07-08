package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.DataTarget;

public abstract class LanguageProvider extends AbstractDataProvider {
    public LanguageProvider(DataGenContext context) {
        super("lang", "Languages", DataTarget.ASSETS, context);
    }
}
