package ho.artisan.legendary.init;

import ho.artisan.legendary.ArtisansLegendary;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ArtisansLegendary.NAMESPACE);
}
