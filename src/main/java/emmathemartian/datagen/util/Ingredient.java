package emmathemartian.datagen.util;

import com.google.gson.JsonObject;
import cyclops.control.Either;
import emmathemartian.datagen.DataGenException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;

public record Ingredient(Either<Item, TagKey<Item>> item, int count, int damage) {
    public JsonObject toJson() {
        JsonObject object = new JsonObject();

        if (item.isLeft()) {
            Identifier maybeItem = ItemRegistry.INSTANCE.getId(item.leftOrElse(null));
            if (maybeItem == null)
                throw new DataGenException("Item did not exist in registry: " + item.leftOrElse(null));
            object.addProperty("item", maybeItem.toString());
            if (damage != 0)
                object.addProperty("damage", damage);
        } else if (item.isRight()) {
            object.addProperty("tag", item.orElse(null).id().toString());
        } else {
            throw new DataGenException("Ingredient.toJson() called but Ingredient.item was not present.");
        }

        if (count != 1)
            object.addProperty("count", count);

        return object;
    }

    public static Ingredient of(Item item, int count, int damage) {
        return new Ingredient(Either.left(item), count, damage);
    }

    public static Ingredient of(Item item, int count) {
        return of(item, count, 0);
    }

    public static Ingredient of(Item item) {
        return of(item, 1, 0);
    }

    public static Ingredient of(ItemStack stack) {
        return of(stack.getItem(), stack.count, stack.getDamage());
    }

    public static Ingredient of(TagKey<Item> tag, int count) {
        return new Ingredient(Either.right(tag), count, 0);
    }

    public static Ingredient of(TagKey<Item> tag) {
        return of(tag, 1);
    }
}
