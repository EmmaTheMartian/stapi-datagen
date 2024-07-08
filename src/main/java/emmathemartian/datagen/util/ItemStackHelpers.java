package emmathemartian.datagen.util;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.registry.ItemRegistry;

public class ItemStackHelpers {
    //TODO: Save stack.getStationNbt()
    public static JsonObject stackToJson(ItemStack stack) {
        JsonObject object = new JsonObject();
        object.addProperty("item", ItemRegistry.INSTANCE.getId(stack.itemId).orElseThrow().toString());
        if (stack.count != 1)
            object.addProperty("count", stack.count);
        if (stack.getDamage() != 0)
            object.addProperty("damage", stack.getDamage());
        return object;
    }
}
