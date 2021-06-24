package moe.timgor.kilnmod.data.client;

import moe.timgor.kilnmod.KilnMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, KilnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        withExistingParent("kiln_block", modLoc("block/kiln_block"));

        builder(itemGenerated, "silver_ingot");
    }

    private ItemModelBuilder builder(ModelFile parent, String name) {
        return getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }
}
