package moe.timgor.kilnmod.setup;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.crafting.recipe.KilningRecipe;
import net.minecraft.item.crafting.*;
import net.minecraftforge.fml.RegistryObject;

public class ModRecipes {
    public static final class Types {
        public static final IRecipeType<KilningRecipe> KILNING = IRecipeType.register(KilnMod.MOD_ID + ":kilning");

        private Types() {}


    }

    public static final class Serializers {
        public static final RegistryObject<IRecipeSerializer<?>> KILNING_RECIPE = Registration.RECIPE_SERIALIZERS.register("kilning", KilningRecipe.CookingRecipeSerializer::new);

        private Serializers() {}
    }

    private ModRecipes() {}

    static void register() {}
}
