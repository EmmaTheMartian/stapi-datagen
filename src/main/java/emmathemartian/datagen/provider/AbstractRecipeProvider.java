package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;

public abstract class AbstractRecipeProvider extends AbstractDataProvider {
    public AbstractRecipeProvider(String subpath, DataGenContext context) {
        super("recipes/" + subpath, "Recipes", context);
    }
}
