package ho.artisan.legendary.api.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosTags;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioItem extends Item implements ICurioItem {
    public CurioItem(Properties properties) {
        super(properties);
    }

    public TagKey<Item> getCurioTag() {
        return CuriosTags.CURIO;
    }
}
