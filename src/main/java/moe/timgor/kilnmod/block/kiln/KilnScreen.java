package moe.timgor.kilnmod.block.kiln;

import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/blast_furnace.png");

    public KilnScreen(KilnContainer kilnContainer, PlayerInventory inventory, ITextComponent title) {
        super(kilnContainer, new FurnaceRecipeGui(), inventory, title, TEXTURE);
    }
}
