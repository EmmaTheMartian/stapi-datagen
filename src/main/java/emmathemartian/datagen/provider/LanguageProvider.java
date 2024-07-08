package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;

public abstract class LanguageProvider extends AbstractDataProvider {
    public LanguageProvider(DataGenContext context) {
        super("lang", "Languages", context);
    }
}
