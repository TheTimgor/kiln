package moe.timgor.kilnmod.setup;

import moe.timgor.kilnmod.KilnMod;
import moe.timgor.kilnmod.block.kiln.KilnContainer;
import moe.timgor.kilnmod.block.kiln.KilnScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.network.IContainerFactory;

@Mod.EventBusSubscriber(modid = KilnMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainerTypes {
    public static final RegistryObject<ContainerType<KilnContainer>> KILN_CONTAINER = register("kiln", KilnContainer::new);

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String name, IContainerFactory<T> factory) {
        return Registration.CONTAINERS.register(name, () -> IForgeContainerType.create(factory));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        ScreenManager.register(KILN_CONTAINER.get(), KilnScreen::new);
    }

    static void register(){}
}
