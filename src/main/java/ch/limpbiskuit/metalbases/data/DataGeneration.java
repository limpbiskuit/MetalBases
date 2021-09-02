package ch.limpbiskuit.metalbases.data;

import ch.limpbiskuit.metalbases.MetalBases;
import ch.limpbiskuit.metalbases.data.recipe.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MetalBases.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();

        if(e.includeServer()) {
            gen.addProvider(new RecipeGenerator(gen));
        }
    }

}
