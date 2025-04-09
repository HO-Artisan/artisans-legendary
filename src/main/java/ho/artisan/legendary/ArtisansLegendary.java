package ho.artisan.legendary;

import ho.artisan.legendary.init.ALConfigHolder;
import ho.artisan.legendary.init.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ArtisansLegendary.NAMESPACE)
public final class ArtisansLegendary {

    public static final String NAMESPACE = "artisans_legendary";
    public static final String NAME = "Artisans Legendary";
    public static final String VERSION = "0.0.1-alpha";

    public ArtisansLegendary(IEventBus modBus, ModContainer container) {
        AutoConfig.register(ALConfigHolder.class, Toml4jConfigSerializer::new);

        ItemInit.ITEMS.register(modBus);
        ItemInit.EASY_EGG.register(modBus);
        BlockInit.BLOCKS.register(modBus);
        TileInit.TILE_TYPES.register(modBus);
        EffectInit.EFFECTS.register(modBus);
        TabInit.TABS.register(modBus);
    }
}
