package com.sudolev.bellsandwhistles.content;

import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.sudolev.bellsandwhistles.BellsAndWhistles;
import com.sudolev.bellsandwhistles.content.block.*;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CBWBlocks {
	public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
		return b -> b.tag(BlockTags.MINEABLE_WITH_AXE);
	}
	public static final Block ANDESITE_GRAB_RAILS = registerBlock("andesite_grab_rails",
			(new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block BRASS_GRAB_RAILS = registerBlock("brass_grab_rails",
			(new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block COPPER_GRAB_RAILS = registerBlock("copper_grab_rails",
			(new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block ANDESITE_BOGIE_STEPS = registerBlock("andesite_bogie_steps",
			( new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block BRASS_BOGIE_STEPS = registerBlock("brass_bogie_steps",
			(new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block COPPER_BOGIE_STEPS = registerBlock("copper_bogie_steps",
			(new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block ANDESITE_DOOR_STEP = registerBlock("andesite_door_step",
			( new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block BRASS_DOOR_STEP = registerBlock("brass_door_step",
			(new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block COPPER_DOOR_STEP = registerBlock("copper_door_step",
			(new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block HEADLIGHT = registerBlock("headlight",
			(new HeadlightBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.LANTERN))), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block ORNATE_IRON_TRAPDOOR = registerBlock("ornate_iron_trapdoor",
			(new TrainTrapdoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.GLASS).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block STATION_PLATFORM = registerBlock("station_platform",
			(new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).sound(SoundType.STONE).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block METRO_CASING = registerBlock("metro_casing",
			(new CasingBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL), true)), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block CORRUGATED_METRO_CASING = registerBlock("corrugated_metro_casing",
			(new CasingBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL), true)), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block METRO_PANEL = registerBlock("metro_panel",
			(new PanelBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block CORRUGATED_METRO_PANEL = registerBlock("corrugated_metro_panel",
			(new PanelBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block METRO_WINDOW = registerBlock("metro_window",
			(new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

	public static final Block METRO_TRAPDOOR = registerBlock("metro_trapdoor",
			(new TrainTrapdoorBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block METAL_PILOT = registerBlock("metal_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block ANDESITE_PILOT = registerBlock("andesite_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block BRASS_PILOT = registerBlock("brass_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block COPPER_PILOT = registerBlock("copper_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_ANDESITE_PILOT = registerBlock("polished_andesite_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_ASURINE_PILOT = registerBlock("polished_asurine_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_CALCITE_PILOT = registerBlock("polished_calcite_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_CRIMSITE_PILOT = registerBlock("polished_crimsite_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_DEEPSLATE_PILOT = registerBlock("polished_deepslate_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_DIORITE_PILOT = registerBlock("polished_diorite_pilot",
			(new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_DRIPSTONE_PILOT = registerBlock("polished_dripstone_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_GRANITE_PILOT = registerBlock("polished_granite_pilot",
			(new  PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_LIMESTONE_PILOT = registerBlock("polished_limestone_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_OCHRUM_PILOT = registerBlock("polished_ochrum_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_SCORCHIA_PILOT = registerBlock("polished_scorchia_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_SCORIA_PILOT = registerBlock("polished_scoria_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_TUFF_PILOT = registerBlock("polished_tuff_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);
	public static final Block POLISHED_VERIDIUM_PILOT = registerBlock("polished_veridium_pilot",
			( new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())), CBWItemGroup.BELLSANDWHISTLESTAB);

		private static Block registerBlock(String name, Block block, CreativeModeTab tab) {
			registerBlockItem(name, block, tab);
			return Registry.register(Registry.BLOCK, new ResourceLocation(BellsAndWhistles.ID, name), block);
		}

		private static Item registerBlockItem(String name, Block block, CreativeModeTab tab) {
			return Registry.register(Registry.ITEM, new ResourceLocation(BellsAndWhistles.ID, name),
					new BlockItem(block, new FabricItemSettings().group(tab)));
		}

		public static void registerModBlocks() {
			BellsAndWhistles.LOGGER.debug("Registering ModBlocks for " + BellsAndWhistles.ID);
		}

}
