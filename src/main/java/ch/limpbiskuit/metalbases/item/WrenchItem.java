package ch.limpbiskuit.metalbases.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public class WrenchItem extends Item {

    protected static final String MODE_TAG = "rotationMode";

    public WrenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        BlockState clickedBlock = world.getBlockState(context.getClickedPos());
        ItemStack itemInHand = context.getItemInHand();

        if(!world.isClientSide && player != null) {

            if(getMode(itemInHand)) {
                orientBlock(clickedBlock, world, context, context.getClickedFace());
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_,@Nonnull Hand p_77659_3_) {
        ItemStack itemInHand = p_77659_2_.getItemInHand(p_77659_3_);

        if(p_77659_2_.isShiftKeyDown()) {
            if ((getMode(itemInHand))) {
                setMode(itemInHand, false);
            } else {
                setMode(itemInHand, true);
            }
            return ActionResult.success(itemInHand);
        }

        return ActionResult.pass(itemInHand);
    }



    private void orientBlock(BlockState clickedBlock, World world, ItemUseContext context, Direction direction) {
        BlockPos blockPos = context.getClickedPos();

        if (clickedBlock.hasProperty(BlockStateProperties.FACING)) {
            world.setBlockAndUpdate(blockPos, clickedBlock.setValue(BlockStateProperties.FACING, direction));
        }
        else if (clickedBlock.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            if(direction == Direction.UP || direction == Direction.DOWN) {
                world.setBlockAndUpdate(blockPos, clickedBlock.rotate(world, blockPos, Rotation.COUNTERCLOCKWISE_90));
            } else {
                world.setBlockAndUpdate(blockPos, clickedBlock.setValue(BlockStateProperties.HORIZONTAL_FACING, direction));
            }
        }
        else if (clickedBlock.hasProperty(BlockStateProperties.FACING_HOPPER)) {
            if(direction == Direction.UP) {
                world.setBlockAndUpdate(blockPos, clickedBlock.setValue(BlockStateProperties.FACING_HOPPER, Direction.DOWN));
            } else {
                world.setBlockAndUpdate(blockPos, clickedBlock.setValue(BlockStateProperties.FACING_HOPPER, direction));
            }
        }
    }

    public  static void setMode(ItemStack stack, boolean mode) {
        stack.getOrCreateTag().putBoolean(MODE_TAG, mode);
    }

    public static boolean getMode(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(MODE_TAG);
    }

}

