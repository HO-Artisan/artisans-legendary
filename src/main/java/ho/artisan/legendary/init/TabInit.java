package ho.artisan.legendary.init;

import ho.artisan.legendary.ArtisansLegendary;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, ArtisansLegendary.NAMESPACE);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEFAULT_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EASY_EGG_TAB;

    static {
        DEFAULT_TAB = TABS.register("default_tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("%s.%s.%s".formatted(ArtisansLegendary.NAMESPACE, "CreativeTab", "default")))
                // .icon(ItemInit.CURSED_IRON_RING::toStack)
                .displayItems((idp, output) ->
                    ItemInit.ITEMS.getEntries().stream()
                            .map(Supplier::get)
                            .map(Item::getDefaultInstance)
                            .forEach(output::accept))
                .build());

        EASY_EGG_TAB = TABS.register("easy_egg", () -> CreativeModeTab.builder()
                .title(Component.translatable("%s.%s.%s".formatted(ArtisansLegendary.NAMESPACE, "CreativeTab", "easyEgg")))
                // .icon(ItemInit.WOLF_COLLAR::toStack)
                .displayItems((idp, output) ->
                        ItemInit.EASY_EGG.getEntries().stream()
                                .map(Supplier::get)
                                .map(Item::getDefaultInstance)
                                .forEach(output::accept))
                .build());
    }
}
