package com.kolobov.simplecameras.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class SecurityCameraBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SecurityCameraBlock(Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState().with(FACING, Direction.SOUTH)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
