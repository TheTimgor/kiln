package moe.timgor.kilnmod.setup;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.block.kiln.KilnTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = KilnMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTileEntityTypes {
    public static final RegistryObject<TileEntityType<KilnTileEntity>> KILN_TE = register("kiln_te", KilnTileEntity::new, ModBlocks.KILN_BLOCK);

    static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () ->  TileEntityType.Builder.of(factory, block.get()).build(null));
    }
}
