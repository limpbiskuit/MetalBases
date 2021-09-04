package ch.limpbiskuit.metalbases.api;

import ch.limpbiskuit.metalbases.util.dropHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;

public interface IDismantleable extends IForgeBlock {

    default void dismantleBlock(BlockState state, World world, BlockPos pos, RayTraceResult target, PlayerEntity player) {
        ItemStack drop = this.getPickBlock(state, target, world, pos, player);
        dropHelper.dropDismantledBlock(drop, world, pos);
    }

}
