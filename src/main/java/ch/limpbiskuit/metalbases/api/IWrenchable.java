package ch.limpbiskuit.metalbases.api;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;

public interface IWrenchable extends IForgeBlock {

    default void wrenchBlock(BlockState state, World world, BlockPos pos, Direction direction) {}

}
