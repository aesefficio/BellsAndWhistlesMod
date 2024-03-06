package com.sudolev.bellsandwhistles.fabric;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import com.sudolev.bellsandwhistles.BellsAndWhistles;

public abstract class UtilsImpl {
	public static String getVersion(String modid) {
		return FabricLoader.getInstance()
						   .getModContainer(modid)
						   .orElseThrow()
						   .getMetadata()
						   .getVersion()
						   .getFriendlyString();
	}

	public static boolean isDevEnv() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}

	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		ForgeConfigRegistry.INSTANCE.register(BellsAndWhistles.ID, type, spec);
	}

	public static CompoundTag getCustomData(Entity entity) {
		return entity.getCustomData();
	}

	public static TagKey<Item> tagFromColor(DyeColor color) {
		return color.getTag();
	}
}
