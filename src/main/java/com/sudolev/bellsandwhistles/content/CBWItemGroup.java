package com.sudolev.bellsandwhistles.content;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CBWItemGroup {
	public static final CreativeModeTab BELLS_AND_WHISTLES_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
		new ResourceLocation(BellsAndWhistles.ID, "bellsandwhistlestab"),
		FabricItemGroup.builder()
			.title(Component.translatable("itemGroup.bellsandwhistles.bellsandwhistlestab"))
			.icon(() -> new ItemStack(CBWBlocks.METAL_PILOT))
			.displayItems((pParameters, pOutput) -> {
				pOutput.accept(CBWBlocks.ANDESITE_BOGIE_STEPS);
				pOutput.accept(CBWBlocks.BRASS_BOGIE_STEPS);
				pOutput.accept(CBWBlocks.COPPER_BOGIE_STEPS);
				pOutput.accept(CBWBlocks.ANDESITE_GRAB_RAILS);
				pOutput.accept(CBWBlocks.BRASS_GRAB_RAILS);
				pOutput.accept(CBWBlocks.COPPER_GRAB_RAILS);
				pOutput.accept(CBWBlocks.ANDESITE_DOOR_STEP);
				pOutput.accept(CBWBlocks.BRASS_DOOR_STEP);
				pOutput.accept(CBWBlocks.COPPER_DOOR_STEP);
				pOutput.accept(CBWBlocks.ORNATE_IRON_TRAPDOOR);
				pOutput.accept(CBWBlocks.HEADLIGHT);
				pOutput.accept(CBWBlocks.STATION_PLATFORM);
				pOutput.accept(CBWBlocks.METRO_CASING);
				pOutput.accept(CBWBlocks.CORRUGATED_METRO_CASING);
				pOutput.accept(CBWBlocks.METRO_PANEL);
				pOutput.accept(CBWBlocks.CORRUGATED_METRO_PANEL);
				pOutput.accept(CBWBlocks.METRO_TRAPDOOR);
				pOutput.accept(CBWBlocks.METRO_WINDOW);

				pOutput.accept(CBWBlocks.ANDESITE_PILOT);
				pOutput.accept(CBWBlocks.BRASS_PILOT);
				pOutput.accept(CBWBlocks.COPPER_PILOT);
				pOutput.accept(CBWBlocks.METAL_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_ANDESITE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_GRANITE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_DIORITE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_DEEPSLATE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_DRIPSTONE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_TUFF_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_CALCITE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_LIMESTONE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_SCORIA_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_SCORCHIA_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_CRIMSITE_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_OCHRUM_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_VERIDIUM_PILOT);
				pOutput.accept(CBWBlocks.POLISHED_ASURINE_PILOT);
			}).build());

	public static void registerItemGroups() {
		BellsAndWhistles.LOGGER.info("Registering Item Groups for " + BellsAndWhistles.ID);
	}
}