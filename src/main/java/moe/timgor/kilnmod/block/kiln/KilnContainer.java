package moe.timgor.kilnmod.block.kiln;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class KilnContainer extends AbstractFurnaceContainer {
    public KilnContainer(int containerId, PlayerInventory inventory) {
        super(ContainerType.BLAST_FURNACE, IRecipeType.BLASTING, RecipeBookCategory.BLAST_FURNACE, containerId, inventory);
    }

    public KilnContainer(int containerId, PlayerInventory playerInventory, IInventory inventory, IIntArray data) {
        super(ContainerType.BLAST_FURNACE, IRecipeType.BLASTING, RecipeBookCategory.BLAST_FURNACE, containerId, playerInventory, inventory, data);
    }
}