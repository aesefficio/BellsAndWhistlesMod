package com.sudolev.bellsandwhistles.content.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import dev.architectury.injectables.annotations.ExpectPlatform;

public final class BWTab {
	@ExpectPlatform
	public static ResourceKey<CreativeModeTab> getKey() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static CreativeModeTab get() {
		throw new AssertionError();
	}

	public static void register() {}
}