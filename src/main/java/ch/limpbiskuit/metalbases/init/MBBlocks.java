package ch.limpbiskuit.metalbases.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class MBBlocks {

    public static final Block IRON_BASE = new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(3.0F, 6.0F).sound(SoundType.METAL));
    public static final Block STEEL_BASE = new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(3.0F, 6.0F).sound(SoundType.METAL));



    public static void register() {
        create("iron_base", () -> IRON_BASE);
        create("steel_base", () -> STEEL_BASE);
    }

    private static void create(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = Registration.BLOCKS.register(name, supplier);
        Registration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(MBGroup.ITEM_GROUP)));
    }

}
