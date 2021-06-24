package moe.timgor.kilnmod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;
import net.minecraft.util.registry.Registry;

import static moe.timgor.kilnmod.KilnMod.LOGGER;


public class KilnContainer extends AbstractFurnaceContainer {
//    public static final ContainerType<FurnaceContainer> FURNACE = register("furnace", FurnaceContainer::new);
    public static final ContainerType<KilnContainer> KILN_CONT_TYPE = Registry.register(Registry.MENU, "kiln_cont", new ContainerType<>(KilnContainer::new));

    public KilnContainer(int p_i50082_1_, PlayerInventory p_i50082_2_) {
        super(KILN_CONT_TYPE, IRecipeType.SMELTING, RecipeBookCategory.FURNACE, p_i50082_1_, p_i50082_2_);
        LOGGER.info("HELLO FROM CONSTRUCTOR ONE");
    }

    public KilnContainer(int p_i50083_1_, PlayerInventory p_i50083_2_, IInventory p_i50083_3_, IIntArray p_i50083_4_) {
        super(KILN_CONT_TYPE, IRecipeType.SMELTING, RecipeBookCategory.FURNACE, p_i50083_1_, p_i50083_2_, p_i50083_3_, p_i50083_4_);
        LOGGER.info("HELLO FROM CONSTRUCTOR TWO");
    }
}
