package invalid.myask.holelottanothing;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import invalid.myask.holelottanothing.event.HearTheToon;
import invalid.myask.holelottanothing.event.HearTheVoid;
import invalid.myask.holelottanothing.world.BiomeGenVoid;
import invalid.myask.holelottanothing.world.WorldTypeVoid;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        HoleLottaNothing.LOG.info("I am " + HoleLottaNothing.MODNAME + " at version " + Tags.VERSION);
        BiomeGenVoid.voidBiomeInstance = new BiomeGenVoid(Config.void_biome_ID);
        BiomeGenVoid.voidBiomeInstance.setBiomeName("void");
        WorldTypeVoid.VOID = new WorldTypeVoid("void");
        MinecraftForge.TERRAIN_GEN_BUS.register(HearTheVoid.instance);
        MinecraftForge.EVENT_BUS.register(HearTheToon.instance);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {}

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
