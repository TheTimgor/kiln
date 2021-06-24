package moe.timgor.kilnmod.block.kiln;

import moe.timgor.kilnmod.setup.ModRecipes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import moe.timgor.kilnmod.setup.ModContainerTypes;
import net.minecraft.util.text.ITextComponent;

public class KilnContainer extends AbstractFurnaceContainer {
    public KilnContainer(int containerID, PlayerInventory playerInventory) {
        super(ModContainerTypes.KILN_CONTAINER.get(), ModRecipes.Types.KILNING, RecipeBookCategory.FURNACE, containerID, playerInventory);
    }

    public KilnContainer(int containerID, PlayerInventory playerInventory, IInventory inventory, IIntArray data) {
        super(ModContainerTypes.KILN_CONTAINER.get(), ModRecipes.Types.KILNING, RecipeBookCategory.FURNACE, containerID, playerInventory, inventory, data);
    }

    public KilnContainer(int containerID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ModContainerTypes.KILN_CONTAINER.get(), ModRecipes.Types.KILNING, RecipeBookCategory.FURNACE, containerID, playerInventory);
    }
}