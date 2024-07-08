package emmathemartian.datagen.test;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

@SuppressWarnings("unused")
public class TestMod {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item itemRuby, itemDirtyRuby, itemRubyRod;
    public static Block blockRuby;

    @EventListener
    private static void onRegisterItems(ItemRegistryEvent event) {
        itemRuby = new TemplateItem(NAMESPACE.id("ruby")).setTranslationKey(NAMESPACE, "ruby");
        itemDirtyRuby = new TemplateItem(NAMESPACE.id("dirty_ruby")).setTranslationKey(NAMESPACE, "dirty_ruby");
        itemRubyRod = new TemplateItem(NAMESPACE.id("ruby_rod")).setTranslationKey(NAMESPACE, "ruby_rod");
    }

    @EventListener
    private static void onRegisterBlocks(BlockRegistryEvent event) {
        blockRuby = new TemplateBlock(NAMESPACE.id("ruby_block"), Material.STONE).setTranslationKey(NAMESPACE, "ruby_block").setHardness(2.0f).setResistance(4.0f);
    }

    public static class Client {
        public static int blockRubyTexture;

        @EventListener
        private static void onRegisterTextures(TextureRegisterEvent event) {
            itemRuby.setTexture(NAMESPACE.id("item/ruby"));

            ExpandableAtlas atlas = Atlases.getTerrain();
            blockRubyTexture = atlas.addTexture(NAMESPACE.id("block/ruby_block")).index;
            blockRuby.textureId = blockRubyTexture;
        }
    }
}
