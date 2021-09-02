package ch.limpbiskuit.metalbases.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MBGroup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("metalbasesTab"){
        
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MBItems.WRENCH);
        }

    };
    
}
