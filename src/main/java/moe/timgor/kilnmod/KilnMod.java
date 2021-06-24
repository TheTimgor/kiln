package moe.timgor.kilnmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import moe.timgor.kilnmod.setup.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KilnMod.MOD_ID)
public class KilnMod {
    // Directly reference a log4j logger.
    public static final String MOD_ID = "kilnmod";

    public static final Logger LOGGER = LogManager.getLogger();

    public KilnMod() {
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
