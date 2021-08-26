package ch.limpbiskuit.metalbases.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> WRENCH = Registration.ITEMS.register("wrench", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));
    
    public static final RegistryObject<Item> BLANK_MODULE = Registration.ITEMS.register("blank_module", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));

    public static final RegistryObject<Item> BLANK_UPGRADE = Registration.ITEMS.register("blank_upgrade", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));

    public static final RegistryObject<Item> SPEED_UPGRADE = Registration.ITEMS.register("speed_upgrade", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));

    public static final RegistryObject<Item> ENERGY_UPGRADE = Registration.ITEMS.register("energy_upgrade", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));

    public static final RegistryObject<Item> CAPACITY_UPGRADE = Registration.ITEMS.register("capacity_upgrade", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));



    static void register() {}

}
