package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;

public abstract class AbstractModelProvider extends AbstractDataProvider {
    public AbstractModelProvider(String subpath, String name, DataGenContext context) {
        super("models/" + subpath, name, context);
    }
}