package emmathemartian.datagen.provider;

import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.DataTarget;
import emmathemartian.datagen.builder.TagBuilder;

public abstract class TagProvider<T> extends AbstractDataProvider {
    public TagProvider(String path, String name, DataGenContext context) {
        super("tags/" + path, name, DataTarget.DATA, context);
    }

    protected abstract TagBuilder<T> tag();
}
