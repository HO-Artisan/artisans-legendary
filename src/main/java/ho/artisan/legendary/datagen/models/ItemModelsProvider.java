package ho.artisan.legendary.datagen.models;

import ho.artisan.legendary.ArtisansLegendary;
import ho.artisan.legendary.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ItemModelsProvider extends ItemModelProvider {
    public ItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArtisansLegendary.NAMESPACE, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemInit.ITEMS.getEntries()
                .stream()
                .map(DeferredHolder::get)
                .forEach(this::basicItem);
    }
}
