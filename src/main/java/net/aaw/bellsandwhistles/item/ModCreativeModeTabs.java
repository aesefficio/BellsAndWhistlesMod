package net.aaw.bellsandwhistles.item;

import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.aaw.bellsandwhistles.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BellsAndWhistles.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BELLS_AND_WHISTLES_TAB = CREATIVE_MODE_TABS.register("bells_and_whistles_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRASS_WHISTLE.get()))
                    .title(Component.translatable("creativetab.bells_and_whistles_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WOODEN_WHISTLE.get());
                        pOutput.accept(ModItems.BRASS_WHISTLE.get());
                        pOutput.accept(ModBlocks.METAL_PILOT.get());
                        pOutput.accept(ModBlocks.ANDESITE_GRAB_RAILS.get());
                        pOutput.accept(ModBlocks.BRASS_GRAB_RAILS.get());
                        pOutput.accept(ModBlocks.COPPER_GRAB_RAILS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
