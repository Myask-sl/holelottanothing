package invalid.myask.holelottanothing.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.*;

import invalid.myask.holelottanothing.Config;

public class MapGenStructurePlatform extends MapGenStructure {

    static {
        MapGenStructureIO.registerStructure(PlatformStart.class, "VoidStartPlatform");
        MapGenStructureIO.func_143031_a(PlatformComponent.class, "VoidStartPlatformComponent");
    }

    @Override
    public String func_143025_a() {
        return "VoidStartPlatform";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        return chunkX == Config.centerX / 16 && chunkZ == Config.centerZ / 16
            && worldObj.getBiomeGenForCoords(Config.centerX, Config.centerZ) == BiomeGenVoid.voidBiomeInstance;
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        return new PlatformStart();
    }

    public class PlatformStart extends StructureStart {

        public PlatformStart() {
            components.add(new PlatformComponent());
            updateBoundingBox();
        }
    }

    public class PlatformComponent extends StructureComponent {

        PlatformComponent() {
            boundingBox = new StructureBoundingBox(
                Config.centerX - Config.widthX, Config.centerY - Config.widthY, Config.centerZ - Config.widthZ,
                Config.centerX + Config.widthX, Config.centerY + Config.widthY, Config.centerZ + Config.widthZ);
        }

        @Override
        protected void func_143012_a(NBTTagCompound p_143012_1_) {

        }

        @Override
        protected void func_143011_b(NBTTagCompound p_143011_1_) {

        }

        @Override
        public boolean addComponentParts(World world, Random rNG, StructureBoundingBox sBB) {
            coordBaseMode = -1;
            fillWithBlocks(world, sBB, boundingBox.minX, boundingBox.minY, boundingBox.minZ,
                boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ,
                Blocks.stone, Blocks.obsidian, false); //second isn't REPLACEblock, it's FILL.
            placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, Config.centerX, Config.centerY, Config.centerZ, sBB);
            return true;
        }
    }
}
