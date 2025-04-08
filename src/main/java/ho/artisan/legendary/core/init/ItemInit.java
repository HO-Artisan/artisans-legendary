package ho.artisan.legendary.core.init;

import ho.artisan.legendary.common.item.BasicWolfDoll;
import ho.artisan.legendary.common.item.Collar;
import ho.artisan.legendary.common.item.DemonWolfDoll;
import ho.artisan.legendary.core.ArtisansLegendary;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ItemInit {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ArtisansLegendary.NAMESPACE);

    public static final DeferredItem<Item> CURSED_IRON_INGOT =
            ITEMS.registerSimpleItem(
                    "cursed_iron_ingot",
                    new Item.Properties()
                            .fireResistant()
            );

    public static final DeferredItem<Item> CURSED_IRON_RING =
            ITEMS.registerSimpleItem(
                    "cursed_iron_ring",
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(16)
                            .rarity(Rarity.UNCOMMON)
            );

    public static final DeferredItem<Item> WOLF_COLLAR = registerItem("demon_wolf_doll", Collar::new);
    public static final DeferredItem<Item> WOLF_DOLL = registerItem("wolf_doll", BasicWolfDoll::new);
    public static final DeferredItem<Item> DEMON_WOLF_DOLL = registerItem("demon_wolf_doll", DemonWolfDoll::new);


    private static DeferredItem<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.registerItem(name, it -> item.get());
    }
}
