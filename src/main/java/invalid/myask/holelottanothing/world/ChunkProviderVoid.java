package invalid.myask.holelottanothing.world;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChunkProviderVoid implements IChunkProvider {
    protected World worldObj;
    protected Random rNG;
    protected MapGenStructure platform;
    protected boolean features;
    public ChunkProviderVoid(World world, long seed, boolean features) {
        this.worldObj = world;
        rNG = new Random(seed);
        platform = new MapGenStructurePlatform();
        this.features = features;
    }

    @Override
    public boolean chunkExists(int chunkX, int chunkZ) {
        return true;
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ) {
        Block[] blockArray = new Block[65536];
        byte[] biomeArray = new byte[65536];


        for (int i = 0; i < biomeArray.length; i++)
        {
            blockArray[i] = Blocks.air;
            biomeArray[i] = (byte) BiomeGenVoid.voidBiomeInstance.biomeID;
        }

        Chunk empty = new Chunk(this.worldObj, blockArray, biomeArray, chunkX, chunkZ);

        if (features)
            platform.func_151539_a(this, this.worldObj, chunkX, chunkZ, (Block[])null);
        return empty;
    }

    @Override
    public Chunk loadChunk(int chunkX, int chunkZ) {
        return provideChunk(chunkX, chunkZ);
    }

    @Override
    public void populate(IChunkProvider chunkProvider, int chunkX, int chunkZ) {
        if (features)
            platform.generateStructuresInChunk(worldObj, rNG, chunkX, chunkZ);
    }

    @Override
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        return true;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String makeString() {
        return "ChunkProviderVoid";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, int x, int y, int z) {
        return new ArrayList<>();
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null; //closest structure
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(int p_82695_1_, int p_82695_2_) {

    }

    @Override
    public void saveExtraData() {

    }
}
