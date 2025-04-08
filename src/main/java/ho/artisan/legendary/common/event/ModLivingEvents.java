package ho.artisan.legendary.common.event;

import ho.artisan.legendary.core.CuriosUtil;
import ho.artisan.legendary.core.init.ItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public final class ModLivingEvents {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void demonWolfDollEffect(final LivingDamageEvent.Pre event) {
        final var target = event.getEntity();
        if (CuriosUtil.entityEquippedCurio(target, ItemInit.DEMON_WOLF_DOLL.asItem())) {
            event.setNewDamage(event.getNewDamage() * 1.2f);
        }

        if (!(event.getSource().getEntity() instanceof LivingEntity source)) {
            return;
        }

        if (CuriosUtil.entityEquippedCurio(source, ItemInit.DEMON_WOLF_DOLL.asItem())) {
            event.setNewDamage(event.getNewDamage() * 1.2f);
        }
    }
}
