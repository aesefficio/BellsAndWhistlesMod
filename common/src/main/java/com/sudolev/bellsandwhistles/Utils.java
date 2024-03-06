package com.sudolev.bellsandwhistles;

import dev.architectury.injectables.annotations.ExpectPlatform;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public abstract class Utils {
	@ExpectPlatform
	public static String getVersion(String modid) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static boolean isDevEnv() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static String platformName() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static CompoundTag getCustomData(Entity entity) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static TagKey<Item> tagFromColor(DyeColor color) {
		throw new AssertionError();
	}

	public static DyeColor colorFromItem(ItemStack stack) {
		if (stack.getItem() instanceof DyeItem) {
			return ((DyeItem)stack.getItem()).getDyeColor();
		} else {
			for (int x = 0; x < DyeColor.BLACK.getId(); ++x) {
				DyeColor color = DyeColor.byId(x);
				if (stack.is(tagFromColor(color))) {
					return color;
				}
			}

			return null;
		}
	}

	public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
		VoxelShape[] buffer = new VoxelShape[]{ shape, Shapes.empty() };

		int times = (to.ordinal() - from.get2DDataValue() + 4) % 4;
		for(int i = 0; i < times; i++) {
			buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = Shapes.empty();
		}

		return buffer[0];
	}
}
