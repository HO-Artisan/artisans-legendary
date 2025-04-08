package ho.artisan.legendary.datagen.models;

import ho.artisan.legendary.ArtisansLegendary;
import ho.artisan.legendary.common.items.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelsProvider extends ItemModelProvider {
    public ItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArtisansLegendary.NAMESPACE, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemInit.CURSED_IRON_RING.get());
        basicItem(ItemInit.CURSED_IRON_INGOT.get());
    }
}
