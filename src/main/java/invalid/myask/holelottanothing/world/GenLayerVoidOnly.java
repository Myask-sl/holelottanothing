package invalid.myask.holelottanothing.world;

import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerVoidOnly extends GenLayer {
    public GenLayerVoidOnly(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] result = new int[areaWidth * areaHeight];
        for (int i = 0; i < result.length; i++) {
            result[i] = BiomeGenVoid.voidBiomeInstance.biomeID;
        }
        return result;
    }
}
