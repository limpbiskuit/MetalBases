package ch.limpbiskuit.metalbases.init;

import ch.limpbiskuit.metalbases.MetalBases;
import ch.limpbiskuit.metalbases.init.item.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registration {

    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);

    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(bus);

        ModItems.register();
    }



    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, MetalBases.MODID);
    }
    
}
