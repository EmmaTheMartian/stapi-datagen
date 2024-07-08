package emmathemartian.datagen.util;

import net.modificationstation.stationapi.api.util.Identifier;

@SuppressWarnings("unused")
public class Models {
    public enum Block {
        BLOCK("block"),
        CROSS("cross"),
        CUBE("cube"),
        CUBE_ALL("cube_all"),
        CUBE_BOTTOM_TOP("cube_bottom_top"),
        CUBE_COLUMN("cube_column"),
        CUBE_COLUMN_HORIZONTAL("cube_column_horizontal"),
        CUBE_COLUMN_MIRRORED("cube_column_mirrored"),
        CUBE_DIRECTIONAL("cube_directional"),
        CUBE_MIRRORED("cube_mirrored"),
        CUBE_MIRRORED_ALL("cube_mirrored_all"),
        CUBE_TOP("cube_top"),
        ORIENTABLE("orientable"),
        ORIENTABLE_WITH_BOTTOM("orientable_with_bottom"),
        TINTED_CROSS("tinted_cross"),
        ;

        public final Identifier id;

        Block(String name) {
            this.id = Identifier.of("minecraft:block/" + name);
        }
    }

    public enum Item {
        GENERATED("generated"),
        HANDHELD("handheld"),
        HANDHELD_ROD("handheld_rod"),
        ;

        public final Identifier id;

        Item(String name) {
            this.id = Identifier.of("minecraft:item/" + name);
        }
    }
}
