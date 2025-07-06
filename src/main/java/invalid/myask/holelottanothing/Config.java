package invalid.myask.holelottanothing;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
    public static int centerX = 8, centerY = 3, centerZ = 8;
    public static int widthX = 16, widthY = 0, widthZ = 16;
    public static int void_biome_ID = 44;
    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        centerX = configuration.getInt("centerX", Configuration.CATEGORY_GENERAL,
            centerX, -3000000, 3000000,
            "Center x of void start platform.",
            "config.biome.void.x");
        centerY = configuration.getInt("centerY", Configuration.CATEGORY_GENERAL,
            centerY, -3000000, 3000000,
            "Center y of void start platform. (Normal worlds are 0 to 255)",
            "config.biome.void.y");
        centerZ = configuration.getInt("centerZ", Configuration.CATEGORY_GENERAL,
            centerZ, -3000000, 3000000,
            "Center Z of void start platform.",
            "config.biome.void.z");
        widthX = configuration.getInt("widthX", Configuration.CATEGORY_GENERAL,
            widthX, -3000000, 3000000,
            "Width X on each side of void start platform.16 means (16*2 + 1) = 33 wide.",
            "config.biome.void.width.x");
        widthY = configuration.getInt("widthY", Configuration.CATEGORY_GENERAL,
            widthY, -3000000, 3000000,
            "Added Y thickness of void start platform, like others. Ex. 3 means (3*2 + 1) = 7 thick.",
            "config.biome.void.depth.y");
        widthZ = configuration.getInt("widthZ", Configuration.CATEGORY_GENERAL,
            widthX, -3000000, 3000000,
            "Breadth Z on each side of void start platform.16 means (16*2 + 1) = 33 wide.",
            "config.biome.void.width.z");

        void_biome_ID = configuration.getInt("void_biome_ID", Configuration.CATEGORY_GENERAL,
            void_biome_ID,
            0, Integer.MAX_VALUE,
            "ID for void biome. Note that vanilla biome max is effectively 127, consult your ID extender for details.",
            "config.biome.void.id");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
