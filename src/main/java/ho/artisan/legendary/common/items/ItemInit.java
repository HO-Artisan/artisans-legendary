package ho.artisan.legendary.common.items;

import ho.artisan.legendary.ArtisansLegendary;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {

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

}
