package ch.limpbiskuit.metalbases.block;

import ch.limpbiskuit.metalbases.api.IDismantleable;
import ch.limpbiskuit.metalbases.api.IWrenchable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractMachineBlock extends ContainerBlock implements IWrenchable, IDismantleable {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty WORKING = BlockStateProperties.ENABLED;

    AbstractMachineBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    protected abstract void openContainer(World p_220089_1_, BlockPos p_220089_2_, PlayerEntity p_220089_3_);

    protected abstract void wrenchBlock(BlockState state, World world, Direction direction);

    protected abstract void dismantleBlock(BlockState state, World world, PlayerEntity player);

}
