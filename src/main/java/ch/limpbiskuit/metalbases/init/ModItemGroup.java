package ch.limpbiskuit.metalbases.init;

import ch.limpbiskuit.metalbases.init.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MOD_GROUP = new ItemGroup("metalbasesTab"){
        
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WRENCH.get());
        }

    };
    
}
