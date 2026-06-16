package com.kolobov.simplecameras;

import com.kolobov.simplecameras.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

public class SimpleCamerasModInitializer implements ModInitializer {
    public static final String MOD_ID = "simplecameras";

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
    }
}
