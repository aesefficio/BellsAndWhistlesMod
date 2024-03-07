package com.sudolev.bellsandwhistles.content.registry.fabric;

import java.util.function.Supplier;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;

import com.simibubi.create.AllCreativeModeTabs.TabInfo;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import com.sudolev.bellsandwhistles.content.registry.BWBlocks;

public class BWTabImpl {
	public static final TabInfo TAB = register("main", FabricItemGroup.builder()
		.title(Component.translatable("itemGroup.bellsandwhistles"))
		.icon(() -> BWBlocks.HEADLIGHT.get().asItem().getDefaultInstance())
		.displayItems((parameters, output) -> BellsAndWhistles.REGISTRATE
			.getAll(Registries.BLOCK).stream()
			.map(entry -> entry.get().asItem())
			.forEach(output::accept))
		::build);


	public static ResourceKey<CreativeModeTab> getKey() {
		return TAB.key();
	}

	private static TabInfo register(String name, Supplier<CreativeModeTab> supplier) {
		ResourceLocation id = BellsAndWhistles.asResource(name);
		ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id);
		CreativeModeTab tab = supplier.get();
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
		return new TabInfo(key, tab);
	}

	public static CreativeModeTab get() {
		return TAB.tab();
	}
}
