package com.sudolev.bellsandwhistles.content.registry.forge;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.simibubi.create.foundation.utility.Components;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import com.sudolev.bellsandwhistles.content.registry.BWBlocks;

public class BWTabImpl {
	private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BellsAndWhistles.ID);

	public static final RegistryObject<CreativeModeTab> TAB = REGISTER.register("main",
		CreativeModeTab.builder()
			.title(Components.literal(BellsAndWhistles.NAME))
			.icon(() -> BWBlocks.CHAIRS.get(DyeColor.RED).asStack(1))
			.displayItems((parameters, output) -> BellsAndWhistles.REGISTRATE
				.getAll(Registries.BLOCK).stream()
				.map(entry -> entry.get().asItem())
				.forEach(output::accept))
			::build);

	public static void register(IEventBus modEventBus) {
		REGISTER.register(modEventBus);
	}

	public static ResourceKey<CreativeModeTab> getKey() {
		return TAB.getKey();
	}

	public static CreativeModeTab get() {
		return TAB.get();
	}
}
