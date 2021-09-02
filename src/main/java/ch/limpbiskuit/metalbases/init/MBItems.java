package ch.limpbiskuit.metalbases.init;

import ch.limpbiskuit.metalbases.item.WrenchItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class MBItems {

    public static final WrenchItem WRENCH = new WrenchItem(new Item.Properties().stacksTo(1).tab(MBGroup.ITEM_GROUP));
    public static final Item BLANK_MODULE = new Item(new Item.Properties().tab(MBGroup.ITEM_GROUP));
    public static final Item BLANK_UPGRADE = new Item(new Item.Properties().tab(MBGroup.ITEM_GROUP));
    public static final Item SPEED_UPGRADE = new Item(new Item.Properties().tab(MBGroup.ITEM_GROUP));
    public static final Item ENERGY_UPGRADE = new Item(new Item.Properties().tab(MBGroup.ITEM_GROUP));



    public static void register() {
        create("wrench", () -> WRENCH);
        create("blank_module", () -> BLANK_MODULE);
        create("blank_upgrade", () -> BLANK_UPGRADE);
        create("speed_upgrade", () -> SPEED_UPGRADE);
        create("energy_upgrade", () -> ENERGY_UPGRADE);
    }

    private static void create(String name, Supplier<? extends Item> supplier) {
        Registration.ITEMS.register(name, supplier);
    }

}
