package ch.limpbiskuit.metalbases.item;

import ch.limpbiskuit.metalbases.api.IDismantleable;
import ch.limpbiskuit.metalbases.util.OrientationHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public class WrenchItem extends Item {

    protected static final String MODE_TAG = "configmode";

    public WrenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        BlockPos clickedPos = context.getClickedPos();
        BlockState clickedBlock = world.getBlockState(clickedPos);
        Direction direction = context.getClickedFace();
        ItemStack itemInHand = context.getItemInHand();

        if(!world.isClientSide && player != null) {
            if(getMode(itemInHand)) {
                if(clickedBlock.getBlock() instanceof IDismantleable) {
                    BlockRayTraceResult target = new BlockRayTraceResult(context.getClickLocation(), direction, clickedPos, context.isInside());
                    //EntityRayTraceResult target = new EntityRayTraceResult(player, context.getClickLocation());

                    ((IDismantleable) clickedBlock.getBlock()).dismantleBlock(clickedBlock, world, clickedPos, target, player);
                }
            } else if(!getMode(itemInHand)) {
                OrientationHelper.orientBlock(clickedBlock, world, context.getClickedPos(), direction);
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(@Nonnull World p_77659_1_, PlayerEntity p_77659_2_, @Nonnull Hand p_77659_3_) {
        ItemStack itemInHand = p_77659_2_.getItemInHand(p_77659_3_);

        if(p_77659_2_.isShiftKeyDown()) {
            setMode(itemInHand, !getMode(itemInHand));
            return ActionResult.success(itemInHand);
        }

        return ActionResult.pass(itemInHand);
    }



    public  static void setMode(ItemStack stack, boolean mode) {
        stack.getOrCreateTag().putBoolean(MODE_TAG, mode);
    }

    public static boolean getMode(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(MODE_TAG);
    }

}

