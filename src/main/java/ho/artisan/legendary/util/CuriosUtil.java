package ho.artisan.legendary.util;

import com.google.common.collect.Lists;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

@SuppressWarnings("all")
public final class CuriosUtil {
    /**
     * @param entity the target entity.
     * @param item the curio item.
     * @return return true if entity equipped the target curio.
     */
    public static boolean entityEquippedCurio(final LivingEntity entity, final Item item) {
        return !getEntityEquippedCurio(entity, item).isEmpty();
    }

    /**
     * @param entity the target entity.
     * @param item the curio item.
     * @return the first of target curio's itemstack, or the emtpy.
     */
    public static ItemStack getEntityEquippedCurio(final LivingEntity entity, final Item item) {
        if (!(item instanceof ICurioItem curio)) {
            return ItemStack.EMPTY;
        }

        final var opt = CuriosApi.getCuriosHelper().getEquippedCurios(entity);
        if (opt.isEmpty()) {
            return ItemStack.EMPTY;
        }

        final var slots = opt.get();
        for (int i = 0; i < slots.getSlots(); i++) {
            final var it = slots.getStackInSlot(i);
            if (it.is(item)) {
                return it;
            }
        }

        return ItemStack.EMPTY;
    }

    /**
     * @param entity the target entity.
     * @param item the curio item.
     * @return the first of target curios' itemstack, or the emtpy.
     */
    public static List<ItemStack> getEntityEquippedCurios(final LivingEntity entity, final Item item) {
        final var list = Lists.<ItemStack>newArrayList();
        if (!(item instanceof ICurioItem curio)) {
            return list;
        }

        final var opt = CuriosApi.getCuriosHelper().getEquippedCurios(entity);
        if (opt.isEmpty()) {
            return list;
        }

        final var slots = opt.get();
        for (int i = 0; i < slots.getSlots(); i++) {
            final var it = slots.getStackInSlot(i);
            if (it.is(item)) {
                list.add(it);
            }
        }

        return list;
    }
}
