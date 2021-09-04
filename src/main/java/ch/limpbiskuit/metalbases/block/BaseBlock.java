package ch.limpbiskuit.metalbases.block;

import ch.limpbiskuit.metalbases.api.IDismantleable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class BaseBlock extends Block implements IDismantleable {

    public BaseBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

}
