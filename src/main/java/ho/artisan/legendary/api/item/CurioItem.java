package ho.artisan.legendary.api.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosTags;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

@SuppressWarnings("all")
public abstract class CurioItem extends Item implements ICurioItem {
    public CurioItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    public TagKey<Item> getCurioTag() {
        return CuriosTags.CURIO;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        final var entity = slotContext.entity();
        final var slotsOpt = CuriosApi.getCuriosHelper().getEquippedCurios(entity);
        if (slotsOpt.isEmpty()) {
            return true;
        }

        final var slots = slotsOpt.get();
        for (int i = 0; i < slots.getSlots(); i++) {
            final var item = slots.getStackInSlot(i);
            if (item.is(stack.getItem())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
