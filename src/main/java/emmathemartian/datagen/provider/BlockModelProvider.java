package emmathemartian.datagen.provider;

import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.builder.ModelBuilder;
import emmathemartian.datagen.util.Models;

public abstract class BlockModelProvider extends AbstractModelProvider {
    public BlockModelProvider(DataGenContext context) {
        super("block", "Block Models", context);
    }

    protected ModelBuilder model() {
        return new ModelBuilder();
    }

    protected ModelBuilder cross() {
        return new ModelBuilder().parent(Models.Block.CROSS.id);
    }

    protected ModelBuilder cube() {
        return new ModelBuilder().parent(Models.Block.CUBE.id);
    }

    protected ModelBuilder cubeAll() {
        return new ModelBuilder().parent(Models.Block.CUBE_ALL.id);
    }

    protected ModelBuilder cubeBottomTop() {
        return new ModelBuilder().parent(Models.Block.CUBE_BOTTOM_TOP.id);
    }

    protected ModelBuilder cubeColumn() {
        return new ModelBuilder().parent(Models.Block.CUBE_COLUMN.id);
    }

    protected ModelBuilder cubeTop() {
        return new ModelBuilder().parent(Models.Block.CUBE_TOP.id);
    }
}
