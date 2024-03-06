package com.sudolev.bellsandwhistles.content.registry;


import org.jetbrains.annotations.ApiStatus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

import dev.architectury.injectables.annotations.ExpectPlatform;

@SuppressWarnings("unused")
public final class BWBlocks {

	static {
		setupCreativeTab();
	}

	public static void register() {
		// load class
	}

	private static int facing(BlockState state) {
		return switch(state.getValue(DirectionalBlock.FACING)) {
			case NORTH, UP, DOWN -> 0;
			case EAST -> 90;
			case SOUTH -> 180;
			case WEST -> 270;
		};
	}

	@ExpectPlatform
	@ApiStatus.Internal
	public static void setupCreativeTab() {
		throw new AssertionError();
	}

	@ExpectPlatform
	@ApiStatus.Internal
	public static <ModelFile> ModelFile createModelFileWithExistingParent(Object /* BlockStateProvider */ p, String parent, String name) {
		throw new AssertionError();
	}

	@ExpectPlatform
	@ApiStatus.Internal
	public static <ModelFile> ModelFile getExistingModelFile(Object /* BlockStateProvider */ p, String name) {
		throw new AssertionError();
	}

	@ExpectPlatform
	@ApiStatus.Internal
	public static <ModelFile> ModelFile customChairModelFile(Object /* BlockStateProvider */ p, String parent, String name,
															  ResourceLocation top, ResourceLocation side, ResourceLocation sideTop, ResourceLocation sideFront) {
		throw new AssertionError();
	}

	@ExpectPlatform
	@ApiStatus.Internal
	public static <ConfiguredModel> ConfiguredModel modelWithRotation(Object /* ModelFile */ model, int rotation) {
		throw new AssertionError();
	}
}
