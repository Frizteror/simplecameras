package com.kolobov.simplecameras.block;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kolobov.simplecameras.SimpleCamerasModInitializer.MOD_ID;

public class ModBlocks {
    public static final Block SECURITY_CAMERA = registerBlock(
            "security_camera",
            new SecurityCameraBlock(Block.Settings.create())
    );

    public static final Block CAMERA_MONITOR = registerBlock(
            "camera_monitor",
            new CameraMonitorBlock(Block.Settings.create())
    );

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static void registerBlocks() {
        // Blocks are registered through the static initializer
    }
}
