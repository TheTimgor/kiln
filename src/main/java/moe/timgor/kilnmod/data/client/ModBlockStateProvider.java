package moe.timgor.kilnmod.data.client;


import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.block.kiln.KilnBlock;
import moe.timgor.kilnmod.setup.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, KilnMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        String baseName = "kiln_block";
        Block block = ModBlocks.KILN_BLOCK.get();

        // make the shittiest assumption that the so called baseName also follows the textures
        ModelFile kilnModel = models().withExistingParent(baseName, "cube")
            .texture("north", KilnMod.MOD_ID + ":block/"+baseName+"_front")
            .texture("south", KilnMod.MOD_ID + ":block/"+baseName+"_back")
            .texture("east" , KilnMod.MOD_ID + ":block/"+baseName+"_side")
            .texture("west" , KilnMod.MOD_ID + ":block/"+baseName+"_side")
            .texture("up"   , KilnMod.MOD_ID + ":block/"+baseName+"_top")
            .texture("down" , KilnMod.MOD_ID + ":block/"+baseName+"_bottom");

        ModelFile kilnLitModel = models().withExistingParent(baseName, "cube")
            .texture("north", KilnMod.MOD_ID + ":block/"+baseName+"_front")
            .texture("south", KilnMod.MOD_ID + ":block/"+baseName+"_back")
            .texture("east" , KilnMod.MOD_ID + ":block/"+baseName+"_side")
            .texture("west" , KilnMod.MOD_ID + ":block/"+baseName+"_side")
            .texture("up"   , KilnMod.MOD_ID + ":block/"+baseName+"_top")
            .texture("down" , KilnMod.MOD_ID + ":block/"+baseName+"_bottom");

        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
            .modelFile(state.getValue(KilnBlock.LIT) ? kilnLitModel : kilnModel)
            .rotationY((int) state.getValue(KilnBlock.FACING).getOpposite().toYRot())
            .build());
    }
}
