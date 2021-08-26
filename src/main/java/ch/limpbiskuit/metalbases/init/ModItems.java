package ch.limpbiskuit.metalbases.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    
    public static final RegistryObject<Item> BLANK_MODULE = Registration.ITEMS.register("blank_module", () -> 
        new Item(new Item.Properties().tab(ModItemGroup.MOD_GROUP)));

    static void register() {}

}
