package com.sudolev.bellsandwhistles.content.registry;


import com.sudolev.bellsandwhistles.BellsAndWhistles;
import com.sudolev.bellsandwhistles.content.block.HeadlightBlock;
import com.tterrag.registrate.util.entry.BlockEntry;

import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

import dev.architectury.injectables.annotations.ExpectPlatform;

import com.simibubi.create.foundation.data.SharedProperties;

import static com.simibubi.create.foundation.block.ProperWaterloggedBlock.WATERLOGGED;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

@SuppressWarnings("unused")
public final class BWBlocks {

	public static final BlockEntry<HeadlightBlock> HEADLIGHT = BellsAndWhistles.REGISTRATE.block("headlight", HeadlightBlock::new)
		.initialProperties(() -> Blocks.LANTERN)
		.transform(pickaxeOnly())
		.blockstate((c, p) -> p.getVariantBuilder(c.get())
			.forAllStatesExcept(state -> {
				String facing = state.getValue(HorizontalDirectionalBlock.FACING).getSerializedName();
				int rotation = facing(state.getValue(HorizontalDirectionalBlock.FACING));

//				return modelWithRotation(getExistingModelFile(p, "block/headlight/" + facing), rotation);
				return ConfiguredModel.builder()
					.modelFile(createModelFileWithExistingParent(p, "block/headlight/" + facing, c.getName()))
					.rotationY(rotation)
					.build();
			}, WATERLOGGED))
		.simpleItem()
		.register();

	public static void register() {
		// load class
	}

	private static int facing(Direction d) {
		return switch(d) {
			case NORTH, UP, DOWN -> 0;
			case EAST -> 90;
			case SOUTH -> 180;
			case WEST -> 270;
		};
	}

	static {
		setupCreativeTab();
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
	public static <ConfiguredModel> ConfiguredModel modelWithRotation(Object /* ModelFile */ model, int rotation) {
		throw new AssertionError();
	}
}
