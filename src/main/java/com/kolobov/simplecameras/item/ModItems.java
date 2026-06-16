package com.kolobov.simplecameras.item;

import com.kolobov.simplecameras.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kolobov.simplecameras.SimpleCamerasModInitializer.MOD_ID;

public class ModItems {
    public static final Item SECURITY_CAMERA = registerBlockItem(
            "security_camera",
            ModBlocks.SECURITY_CAMERA
    );

    public static final Item CAMERA_MONITOR = registerBlockItem(
            "camera_monitor",
            ModBlocks.CAMERA_MONITOR
    );

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static void registerItems() {
        // Items are registered through the static initializer
    }
}
