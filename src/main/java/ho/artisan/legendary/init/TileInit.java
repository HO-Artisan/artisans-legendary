package ho.artisan.legendary.init;

import ho.artisan.legendary.ArtisansLegendary;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TileInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ArtisansLegendary.NAMESPACE);
}
