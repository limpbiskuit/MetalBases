package ch.limpbiskuit.metalbases.init.item;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import org.lwjgl.glfw.GLFW;


public class Wrench extends Item {
    
    public Wrench(Properties prop) {
        super(prop);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        if(!world.isClientSide && player != null) {
            BlockState clickedBlock = world.getBlockState(context.getClickedPos());

            rightClickOnBlockstate(player, clickedBlock, world, context);
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnBlockstate(PlayerEntity player, BlockState clickedBlock, World world, ItemUseContext context) {
        if(player.isShiftKeyDown()) {
            orientBlock(clickedBlock, world, context, context.getClickedFace());
        }
    }

    private void orientBlock(BlockState clickedBlock, World world, ItemUseContext context, Direction direction) {
        BlockPos blockPos = context.getClickedPos();

        if (clickedBlock.hasProperty(BlockStateProperties.FACING)) {
            world.setBlock(blockPos, clickedBlock.setValue(BlockStateProperties.FACING, direction), Constants.BlockFlags.BLOCK_UPDATE);
        }
        else if (clickedBlock.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            if(direction == Direction.UP || direction == Direction.DOWN) {
                world.setBlock(blockPos, clickedBlock.rotate(world, blockPos, Rotation.COUNTERCLOCKWISE_90), Constants.BlockFlags.BLOCK_UPDATE);
            } else {
                world.setBlock(blockPos, clickedBlock.setValue(BlockStateProperties.HORIZONTAL_FACING, direction), Constants.BlockFlags.BLOCK_UPDATE);
            }
        }
        else if (clickedBlock.hasProperty(BlockStateProperties.FACING_HOPPER)) {
            if(direction == Direction.UP) {
                world.setBlock(blockPos, clickedBlock.setValue(BlockStateProperties.FACING_HOPPER, Direction.DOWN), Constants.BlockFlags.BLOCK_UPDATE);
            } else {
                world.setBlock(blockPos, clickedBlock.setValue(BlockStateProperties.FACING_HOPPER, direction), Constants.BlockFlags.BLOCK_UPDATE);
            }
        }
    }
}

