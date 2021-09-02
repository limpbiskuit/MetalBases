package ch.limpbiskuit.metalbases;

import ch.limpbiskuit.metalbases.init.Registration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MetalBases.MODID)
public class MetalBases {
    
    public static final String MODID = "metalbases";

    public MetalBases() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        Registration.register();
    }


    private void setup(FMLCommonSetupEvent e) {

    }

    private void clientSetup(FMLClientSetupEvent e) {

    }

}
