package ho.artisan.legendary.common.item;

import ho.artisan.legendary.api.item.CurioItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class DemonWolfDoll extends CurioItem {
    public DemonWolfDoll() {
        super(new Properties().fireResistant());
    }

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        final var entity = slotContext.entity();
        return entity.getHealth() == entity.getMaxHealth();
    }

    @Override
    public @NotNull ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, boolean recentlyHit, ItemStack stack) {
        return ICurio.DropRule.ALWAYS_KEEP;
    }
}
