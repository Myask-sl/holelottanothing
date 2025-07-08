package invalid.myask.holelottanothing.world;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoid extends BiomeGenBase {

    public static final BiomeGenBase.Height voidHeight = new BiomeGenBase.Height(-5, 0);
    public static BiomeGenVoid voidBiomeInstance;

    public BiomeGenVoid(int id) {
        this(id, true);
        temperature = 0.5F;
        rainfall = 0.5F;
        setDisableRain();
        waterColorMultiplier = 0x3F_76_E4;
    }

    public BiomeGenVoid(int id, boolean register) {
        super(id, register);
        heightVariation = voidHeight.variation;
        rootHeight = voidHeight.rootHeight;
    }
}
