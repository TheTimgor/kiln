package moe.timgor.kiln;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, Kiln.MOD_ID);

    public static final RegistryObject<Item> kiln_item = Items.register("kiln", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

}
