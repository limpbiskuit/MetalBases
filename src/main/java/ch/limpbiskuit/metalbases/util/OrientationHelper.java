package ch.limpbiskuit.metalbases.util;

import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OrientationHelper {

    public static void orientBlock(BlockState block, World world, BlockPos blockPos, Direction direction) {
        BlockState finalBlock;

        if (block.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            switch (direction) {
                case UP:
                    finalBlock = block.rotate(world, blockPos, Rotation.COUNTERCLOCKWISE_90);
                    world.setBlockAndUpdate(blockPos, finalBlock);
                case DOWN:
                    finalBlock = block.rotate(world, blockPos, Rotation.COUNTERCLOCKWISE_90);
                    world.setBlockAndUpdate(blockPos, finalBlock);
                default:
                    finalBlock = block.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
                    world.setBlockAndUpdate(blockPos, finalBlock);
            }
        }
        else if (block.hasProperty(BlockStateProperties.FACING_HOPPER)) {
            if(direction == Direction.UP) {
                finalBlock = block.setValue(BlockStateProperties.FACING_HOPPER, Direction.DOWN);
                world.setBlockAndUpdate(blockPos, finalBlock);
            } else {
                finalBlock = block.setValue(BlockStateProperties.FACING_HOPPER, direction);
                world.setBlockAndUpdate(blockPos, finalBlock);
            }
        }
        else if (block.hasProperty(BlockStateProperties.FACING)) {
            finalBlock = block.setValue(BlockStateProperties.FACING, direction);
            world.setBlockAndUpdate(blockPos, finalBlock);
        }

    }

}
