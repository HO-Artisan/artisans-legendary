package ho.artisan.legendary.api.item;

import ho.artisan.legendary.util.CuriosUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.CuriosTags;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

/**
 * The based of curio item.
 */
@SuppressWarnings("all")
public abstract class CurioItem extends Item implements ICurioItem {
    public CurioItem(Properties properties) {
        super(properties.stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    public List<TagKey<Item>> getCurioTag() {
        return List.of(CuriosTags.CURIO);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return !CuriosUtil.entityEquippedCurio(slotContext.entity(), stack.getItem());
    }

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
