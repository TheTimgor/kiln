package moe.timgor.kilnmod.data;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.setup.ModItems;
import moe.timgor.kilnmod.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, KilnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
    }
}
