package invalid.myask.holelottanothing.world;

import net.minecraft.world.gen.layer.GenLayer;

import java.util.Arrays;

public class GenLayerVoidOnly extends GenLayer {

    public GenLayerVoidOnly(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] result = new int[areaWidth * areaHeight];
        Arrays.fill(result, BiomeGenVoid.voidBiomeInstance.biomeID);
        return result;
    }
}
