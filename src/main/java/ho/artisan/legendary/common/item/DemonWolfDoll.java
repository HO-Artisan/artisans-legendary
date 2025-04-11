package ho.artisan.legendary.common.item;

import ho.artisan.legendary.api.item.CurioItem;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.awt.*;


/*
 * 恶魔狼娃娃能够让你造成的伤害提升 20%，同时受到的伤害也提升 20%。
 * “它似乎想与你做一笔交易，来完成它的年终业绩。”
 * 佩戴后只有血量完全恢复后才能取下。
 * 制作深渊狼娃娃与的勒革狼娃娃的原料。
 */
public final class DemonWolfDoll extends CurioItem {
    public DemonWolfDoll() {
        super(new Properties().fireResistant());
    }

    private static void onEquip(LivingEntity entity) {
        entity.setHealth(entity.getMaxHealth() / 2);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        onEquip(slotContext.entity());
    }

    @Override
    public void onEquipFromUse(SlotContext slotContext, ItemStack stack) {
        super.onEquipFromUse(slotContext, stack);
        onEquip(slotContext.entity());
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

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack)).setStyle(Style.EMPTY.withColor(Color.RED.getRGB()));
    }
}
