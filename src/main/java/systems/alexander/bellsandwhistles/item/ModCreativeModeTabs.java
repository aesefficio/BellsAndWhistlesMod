package systems.alexander.bellsandwhistles.item;

import systems.alexander.bellsandwhistles.BellsAndWhistles;
import systems.alexander.bellsandwhistles.block.ModBlocks;
import systems.alexander.bellsandwhistles.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BellsAndWhistles.MOD_ID);

    public static final Supplier<CreativeModeTab> BELLS_AND_WHISTLES_TAB = CREATIVE_MODE_TABS.register("bells_and_whistles_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.METAL_PILOT))
                    .title(Component.translatable("creativetab.bellsandwhistles.bells_and_whistles"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ANDESITE_BOGIE_STEPS);
                        output.accept(ModBlocks.BRASS_BOGIE_STEPS);
                        output.accept(ModBlocks.COPPER_BOGIE_STEPS);

                        output.accept(ModBlocks.ANDESITE_GRAB_RAILS);
                        output.accept(ModBlocks.BRASS_GRAB_RAILS);
                        output.accept(ModBlocks.COPPER_GRAB_RAILS);

                        output.accept(ModBlocks.ANDESITE_DOOR_STEP);
                        output.accept(ModBlocks.BRASS_DOOR_STEP);
                        output.accept(ModBlocks.COPPER_DOOR_STEP);
                        output.accept(ModBlocks.ORNATE_IRON_TRAPDOOR);
                        output.accept(ModBlocks.HEADLIGHT);
                        output.accept(ModBlocks.STATION_PLATFORM);
                        output.accept(ModBlocks.METRO_CASING);
                        output.accept(ModBlocks.CORRUGATED_METRO_CASING);
                        output.accept(ModBlocks.METRO_PANEL);
                        output.accept(ModBlocks.CORRUGATED_METRO_PANEL);
                        output.accept(ModBlocks.METRO_TRAPDOOR);
                        output.accept(ModBlocks.METRO_WINDOW);

                        output.accept(ModBlocks.ANDESITE_PILOT);
                        output.accept(ModBlocks.BRASS_PILOT);
                        output.accept(ModBlocks.COPPER_PILOT);
                        output.accept(ModBlocks.METAL_PILOT);
                        output.accept(ModBlocks.POLISHED_ANDESITE_PILOT);
                        output.accept(ModBlocks.POLISHED_GRANITE_PILOT);
                        output.accept(ModBlocks.POLISHED_DIORITE_PILOT);
                        output.accept(ModBlocks.POLISHED_DEEPSLATE_PILOT);
                        output.accept(ModBlocks.POLISHED_DRIPSTONE_PILOT);
                        output.accept(ModBlocks.POLISHED_TUFF_PILOT);
                        output.accept(ModBlocks.POLISHED_CALCITE_PILOT);
                        output.accept(ModBlocks.POLISHED_LIMESTONE_PILOT);
                        output.accept(ModBlocks.POLISHED_SCORIA_PILOT);
                        output.accept(ModBlocks.POLISHED_SCORCHIA_PILOT);
                        output.accept(ModBlocks.POLISHED_CRIMSITE_PILOT);
                        output.accept(ModBlocks.POLISHED_OCHRUM_PILOT);
                        output.accept(ModBlocks.POLISHED_VERIDIUM_PILOT);
                        output.accept(ModBlocks.POLISHED_ASURINE_PILOT);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}