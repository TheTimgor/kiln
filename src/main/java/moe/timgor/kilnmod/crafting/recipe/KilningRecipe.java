package moe.timgor.kilnmod.crafting.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import moe.timgor.kilnmod.setup.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class KilningRecipe extends AbstractCookingRecipe {
    public KilningRecipe(ResourceLocation recipeId, String group, Ingredient ingredient, ItemStack result, float xp, int cookingTime) {
        super(ModRecipes.Types.KILNING, recipeId, group, ingredient, result, xp, cookingTime);
    }

    public static class CookingRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<KilningRecipe> {
        private static final int defaultCookingTime = 200;

        @Nullable
        @Override
        public KilningRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String group = JSONUtils.getAsString(json, "group", "");
            JsonElement jsonelement = (JsonElement)(JSONUtils.isArrayNode(json, "ingredient") ? JSONUtils.getAsJsonArray(json, "ingredient") : JSONUtils.getAsJsonObject(json, "ingredient"));
            Ingredient ingredient = Ingredient.fromJson(jsonelement);
            //Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
            if (!json.has("result")) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
            ItemStack itemstack;
            if (json.get("result").isJsonObject()) itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
            else {
                String s1 = JSONUtils.getAsString(json, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                    return new IllegalStateException("Item: " + s1 + " does not exist");
                }));
            }
            float xp = JSONUtils.getAsFloat(json, "experience", 0.0F);
            int cookingTime = JSONUtils.getAsInt(json, "cookingtime", this.defaultCookingTime);
            return new KilningRecipe(recipeId, group, ingredient, itemstack, xp, cookingTime);
        }

        @Override
        public KilningRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            String group = buffer.readUtf(32767);
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemstack = buffer.readItem();
            float xp = buffer.readFloat();
            int cookingTime = buffer.readVarInt();
            return new KilningRecipe(recipeId, group, ingredient, itemstack, xp, cookingTime);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, KilningRecipe recipe) {
            buffer.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookingTime);
        }
    }

    public IRecipeSerializer<?> getSerializer() {
        return new CookingRecipeSerializer();
    }
}