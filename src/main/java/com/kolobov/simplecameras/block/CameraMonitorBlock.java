package com.kolobov.simplecameras.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CameraMonitorBlock extends Block {
    private static final int HORIZONTAL_RANGE = 32;
    private static final int VERTICAL_RANGE = 16;
    private static final int MAX_LINES = 8;

    public CameraMonitorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            int found = 0;

            player.sendMessage(Text.literal("--- Nearby cameras ---"), false);

            for (BlockPos checkPos : BlockPos.iterate(
                    pos.add(-HORIZONTAL_RANGE, -VERTICAL_RANGE, -HORIZONTAL_RANGE),
                    pos.add(HORIZONTAL_RANGE, VERTICAL_RANGE, HORIZONTAL_RANGE)
            )) {
                BlockState checkState = world.getBlockState(checkPos);

                if (checkState.isOf(ModBlocks.SECURITY_CAMERA)) {
                    Direction facing = checkState.get(SecurityCameraBlock.FACING);
                    found++;
                    player.sendMessage(Text.literal(
                            found + ") X=" + checkPos.getX() +
                                    " Y=" + checkPos.getY() +
                                    " Z=" + checkPos.getZ() +
                                    " | facing: " + facing.getName()
                    ), false);

                    if (found >= MAX_LINES) {
                        player.sendMessage(Text.literal("Showing first " + MAX_LINES + " cameras only."), false);
                        break;
                    }
                }
            }

            if (found == 0) {
                player.sendMessage(Text.literal("No cameras found within " + HORIZONTAL_RANGE + " blocks."), false);
            }
        }

        return ActionResult.SUCCESS;
    }
}
