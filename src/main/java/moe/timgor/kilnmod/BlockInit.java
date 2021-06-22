package moe.timgor.kilnmod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, KilnMod.MOD_ID);
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, KilnMod.MOD_ID);

    public static final RegistryObject<Block> kiln_block = Blocks.register("kiln_block", () -> new KilnBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE)));
    public static final RegistryObject<Item> kiln_item = Items.register("kiln_item", () -> new BlockItem(kiln_block.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

}
