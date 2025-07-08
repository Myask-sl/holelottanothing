package invalid.myask.holelottanothing.event;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import invalid.myask.holelottanothing.world.GenLayerVoidOnly;
import invalid.myask.holelottanothing.world.WorldTypeVoid;

public class HearTheVoid {

    public static final HearTheVoid instance = new HearTheVoid();

    @SubscribeEvent
    public void allIsVoid(WorldTypeEvent.InitBiomeGens event) {
        if (event.worldType == WorldTypeVoid.VOID) {
            GenLayer onlyLayer = new GenLayerVoidOnly(event.seed);
            event.newBiomeGens = new GenLayer[] { onlyLayer, onlyLayer, onlyLayer };
        }
    }
}
