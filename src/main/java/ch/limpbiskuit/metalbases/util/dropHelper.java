package ch.limpbiskuit.metalbases.util;

import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class dropHelper {
    public static void dropDismantledBlock(ItemStack drop, World world, BlockPos pos) {
        float f = 0.3F;
        double x2 = world.random.nextFloat() * f + (1.0F - f) * 0.5D;
        double y2 = world.random.nextFloat() * f + (1.0F - f) * 0.5D;
        double z2 = world.random.nextFloat() * f + (1.0F - f) * 0.5D;
        ItemEntity dropEntity = new ItemEntity(world, pos.getX() + x2, pos.getY() + y2, pos.getZ() + z2, drop);
        dropEntity.setPickUpDelay(10);

        world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        world.addFreshEntity(dropEntity);
    }
}
