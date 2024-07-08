package emmathemartian.datagen.builder;

import com.google.gson.JsonObject;
import emmathemartian.datagen.AbstractDataProvider;
import emmathemartian.datagen.DataGenContext;
import emmathemartian.datagen.IDataBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LangBuilder implements IDataBuilder {
    protected Map<String, String> translations = new HashMap<>();

    public LangBuilder add(String key, String value) {
        translations.put(key, value);
        return this;
    }

    public LangBuilder add(Item item, String value) {
        Identifier id = Objects.requireNonNull(ItemRegistry.INSTANCE.getId(item));
        return add("item." + id.namespace + "." + id.path + ".name", value);
    }

    public LangBuilder add(Block block, String value) {
        Identifier id = Objects.requireNonNull(BlockRegistry.INSTANCE.getId(block));
        return add("tile." + id.namespace + "." + id.path + ".name", value);
    }

    public String buildLang() {
        StringBuilder content = new StringBuilder();
        translations.forEach((key, translation) -> content
                .append(key)
                .append('=')
                .append(translation)
                .append('\n'));
        return content.toString();
    }

    @Override
    public JsonObject build() {
        throw new UnsupportedOperationException("LangBuilder should use .buildLang instead of .build");
    }

    @Override
    public void save(String path, AbstractDataProvider provider, DataGenContext context) {
        context.save(provider.path.resolve(path + ".lang"), buildLang());
    }
}
