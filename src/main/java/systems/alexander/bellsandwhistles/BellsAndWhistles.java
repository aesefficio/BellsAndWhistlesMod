package systems.alexander.bellsandwhistles;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.Event;
import systems.alexander.bellsandwhistles.block.ModBlocks;
import systems.alexander.bellsandwhistles.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(BellsAndWhistles.MOD_ID)
public class BellsAndWhistles {
    public static final String MOD_ID = "bellsandwhistles";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public BellsAndWhistles() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANDESITE_BOGIE_STEPS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANDESITE_DOOR_STEP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANDESITE_GRAB_RAILS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_BOGIE_STEPS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_DOOR_STEP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_GRAB_RAILS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_BOGIE_STEPS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_DOOR_STEP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_GRAB_RAILS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEADLIGHT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORNATE_IRON_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.METRO_WINDOW.get(), RenderType.cutout());

        }
    }
}