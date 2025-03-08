package systems.alexander.bellsandwhistles;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import systems.alexander.bellsandwhistles.block.ModBlocks;
import systems.alexander.bellsandwhistles.item.ModCreativeModeTabs;
import systems.alexander.bellsandwhistles.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BellsAndWhistles.MOD_ID)
public class BellsAndWhistles {
    public static final String MOD_ID = "bellsandwhistles";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public BellsAndWhistles(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        ModCreativeModeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

}