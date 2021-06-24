package moe.timgor.kilnmod;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KilnTileEntity extends AbstractFurnaceTileEntity {
    public static final Logger LOGGER = LogManager.getLogger();


    public static TileEntityType<KilnTileEntity> TYPE_KILN = TileEntityType.Builder.of(KilnTileEntity::new, BlockInit.kiln_block.get()).build(null);

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> evt) {
        TYPE_KILN.setRegistryName(KilnMod.MOD_ID, "kiln_te");
        evt.getRegistry().register(TYPE_KILN);
        LOGGER.debug("HELLO FROM REGISTERTE");
    }

    protected KilnTileEntity() {
        super(TYPE_KILN, IRecipeType.SMELTING);
        LOGGER.debug("HELLO FROM KilnTileEntity CONSTRUCTOR");
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.furnace");
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new KilnContainer(p_213906_1_, p_213906_2_, this, this.dataAccess);
    }
}
