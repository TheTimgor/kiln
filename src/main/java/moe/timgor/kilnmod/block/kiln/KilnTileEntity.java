package moe.timgor.kilnmod.block.kiln;

import moe.timgor.kilnmod.setup.ModRecipes;
import moe.timgor.kilnmod.setup.ModTileEntityTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.BlastFurnaceContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class KilnTileEntity extends AbstractFurnaceTileEntity {

    public KilnTileEntity() {
        super(ModTileEntityTypes.KILN_TE.get(), ModRecipes.Types.KILNING);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.kiln");
    }

    protected int getBurnDuration(ItemStack fuel) {
        return super.getBurnDuration(fuel) / 2;
    }

    protected Container createMenu(int containerId, PlayerInventory playerInventory) {
        return new KilnContainer(containerId, playerInventory, this, this.dataAccess);
    }
}