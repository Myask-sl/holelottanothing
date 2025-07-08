package invalid.myask.holelottanothing.event;

import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import invalid.myask.holelottanothing.Config;
import invalid.myask.holelottanothing.world.WorldTypeVoid;

public class HearTheToon {

    public static HearTheToon instance = new HearTheToon();

    @SubscribeEvent
    public void spawnZero(WorldEvent.CreateSpawnPosition event) {
        if (event.world.getWorldInfo().getTerrainType() == WorldTypeVoid.VOID) {
            event.setCanceled(true);
            event.world.setSpawnLocation(Config.centerX, Config.centerY + 3, Config.centerZ);
        }
    }
}
