package moe.timgor.kilnmod.data;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator p_i48256_1_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i48256_1_, KilnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //tag(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
    }
}
