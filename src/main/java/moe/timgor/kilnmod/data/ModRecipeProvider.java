package moe.timgor.kilnmod.data;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.crafting.recipe.KilningRecipe;
import moe.timgor.kilnmod.crafting.recipe.KilningRecipeBuilder;
import moe.timgor.kilnmod.setup.ModBlocks;
import moe.timgor.kilnmod.setup.ModItems;
import moe.timgor.kilnmod.setup.ModRecipes;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Proxy;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.KILN_BLOCK.get())
                .define('#', Items.BRICK)
                .define('%', Items.IRON_INGOT)
                .define('!', Items.FURNACE)
                .pattern("###")
                .pattern("#!#")
                .pattern("#%#")
                .unlockedBy("has_item", has(Items.FURNACE))
                .save(consumer);

        KilningRecipeBuilder.kilning(Ingredient.of(Items.CLAY), Items.TERRACOTTA, 0.7f, 100).save(consumer, modId("clay_kilning"));

        //CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 200)
        //        .unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get()))
        //        .save(consumer, modId("silver_ingot_smelting"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(KilnMod.MOD_ID, path);
    }
}
