package ho.artisan.legendary.common.item;

import com.google.common.collect.Lists;
import ho.artisan.legendary.api.item.CurioItem;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import top.theillusivec4.curios.api.CuriosTags;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.Random;

public class Collar extends CurioItem {
    public Collar() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public List<TagKey<Item>> getCurioTag() {
        return List.of(CuriosTags.NECKLACE, CuriosTags.BRACELET, CuriosTags.HEAD);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(getTooltipText());
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess access) {
        if (action != ClickAction.SECONDARY) return false;
        access.set(Items.BONE.getDefaultInstance());
        return true;
    }

    @Override
    public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan, ItemStack stack) {
        return false;
    }

    /* Dirty Method for Client */
    private static final Random random = new Random();
    private static final List<String> texts = Lists.newArrayList(
            "尝试一下!",
            "反射一下!",
            "阿萨姆一下!",
            "什么，怎么可以米线!",
            "我打现代收割机?真的假的?",
            "凤梨科技!",
            "凤梨凤梨大凤梨~",
            "大胆尝试!",
            "凤梨最好的朋友!",
            "聚光灯下!",
            "非人类!",
            "桌子下有非常多凤梨，而你，我的朋友，你一只都吃不到",
            "我有两只，给你零只",
            "狼生短暂，多吃凤梨！",
            "最近还“嚎”吗？"
    );

    private static final char[] code = "@#$%^&".toCharArray();

    private static int tickOfRender = 0;
    private static final int maxTickOfRender = 20 * 6;

    private static String textHolder = "";
    private static final StringBuilder textInRender = new StringBuilder();

    private Component getTooltipText() {
        if (textHolder.isEmpty()) textHolder = texts.get(random.nextInt(texts.size()));

        if (textInRender.length() < textHolder.length() || !textInRender.toString().equals(textHolder)) {
            if (++tickOfRender < 5) {
                return Component.literal(textInRender.toString());
            }

            tickOfRender = 0;
            if (!textInRender.isEmpty()) {
                var pointer = textInRender.length() - 1;
                textInRender.deleteCharAt(pointer);
                textInRender.append(textHolder.charAt(pointer));
                if (textInRender.length() == textHolder.length()) {
                    return Component.literal(textInRender.toString());
                }
            }

            textInRender.append(code[random.nextInt(code.length)]);
            return Component.literal(textInRender.toString());
        } else if (++tickOfRender < maxTickOfRender) {
            return Component.literal(textInRender.toString());
        }

        tickOfRender = 0;
        textHolder = "";
        textInRender.setLength(0);

        return Component.literal("NaN");
    }

}
