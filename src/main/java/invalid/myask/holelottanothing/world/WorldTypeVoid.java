package invalid.myask.holelottanothing.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldTypeVoid extends WorldType {

    public static WorldType VOID;

    public WorldTypeVoid(String name) {
        super(name);
    }

    @Override
    public boolean showWorldInfoNotice() {
        return true;
    }

    @Override
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
        return new GenLayerVoidOnly(worldSeed);
    }

    @Override
    public int getMinimumSpawnHeight(World world) {
        return 4; // maybelater: tall world
    }

    @Override
    public int getSpawnFuzz() {
        return 8;
    }

    @Override
    public double getHorizon(World world) {
        return 0.0D;
    }

    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
        return new ChunkProviderVoid(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
    }

    @Override
    public WorldChunkManager getChunkManager(World world) { // TODO
        return super.getChunkManager(world);
    }

    @Override
    public boolean isCustomizable() {
        return false; // maybelater: allow moving platform
    }

    @Override
    public boolean handleSlimeSpawnReduction(Random random, World world) {
        return true;
    }
}
