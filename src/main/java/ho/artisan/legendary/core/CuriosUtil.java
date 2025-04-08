package ho.artisan.legendary.core;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public final class CuriosUtil {
    public static boolean entityEquippedCurio(final LivingEntity entity, final Item item) {
        if (!(item instanceof ICurioItem curio)) {
            return false;
        }

        final var opt = CuriosApi.getCuriosHelper().getEquippedCurios(entity);
        if (opt.isEmpty()) {
            return false;
        }

        final var slots = opt.get();
        for (int i = 0; i < slots.getSlots(); i++) {
            final var it = slots.getStackInSlot(i);
            if (it.is(item)) {
                return true;
            }
        }

        return false;
    }
}
