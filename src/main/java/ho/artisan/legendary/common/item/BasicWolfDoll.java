package ho.artisan.legendary.common.item;

import ho.artisan.legendary.api.item.CurioItem;
import ho.artisan.legendary.core.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

/*
 * 毛绒狼娃娃能够让你安全的踏过细雪。
 * “普通的狼娃娃，但你知道它没有看着那么普通。“”
 * 制作更高级狼娃娃的基本原料。
 */
public final class BasicWolfDoll extends CurioItem {
    public BasicWolfDoll() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        final var sound = level.getRandom().nextDouble() < 0.1 ? SoundEvents.WOLF_HOWL : SoundEvents.SHEEP_AMBIENT;
        level.playSound(player, player.getOnPos(), sound, SoundSource.PLAYERS);
        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }

    private static void spawnDemonWolf(Level world, Vec3 pos) {
        final var item = new ItemEntity(world, pos.x, pos.y, pos.z, ItemInit.DEMON_WOLF_DOLL.toStack());
        item.setDefaultPickUpDelay();
        world.addFreshEntity(item);
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if (damageSource == itemEntity.damageSources().lava()) {
            spawnDemonWolf(itemEntity.level(), itemEntity.position());
        }
    }

    @Override
    public @NotNull ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, boolean recentlyHit, ItemStack stack) {
        final var entity = slotContext.entity();
        if (source != entity.damageSources().lava()) {
            return super.getDropRule(slotContext, source, recentlyHit, stack);
        }

        spawnDemonWolf(entity.level(), entity.position());
        return ICurio.DropRule.DESTROY;
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public boolean canWalkOnPowderedSnow(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
