package systems.alexander.bellsandwhistles.block;

import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import systems.alexander.bellsandwhistles.BellsAndWhistles;
import systems.alexander.bellsandwhistles.block.custom.*;
import systems.alexander.bellsandwhistles.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BellsAndWhistles.MOD_ID);

    public static final DeferredBlock<Block> ANDESITE_GRAB_RAILS = registerBlock("andesite_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> BRASS_GRAB_RAILS = registerBlock("brass_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> COPPER_GRAB_RAILS = registerBlock("copper_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> ANDESITE_BOGIE_STEPS = registerBlock("andesite_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> BRASS_BOGIE_STEPS = registerBlock("brass_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> COPPER_BOGIE_STEPS = registerBlock("copper_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> ANDESITE_DOOR_STEP = registerBlock("andesite_door_step",
            () -> new MetalStepBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> BRASS_DOOR_STEP = registerBlock("brass_door_step",
            () -> new MetalStepBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> COPPER_DOOR_STEP = registerBlock("copper_door_step",
            () -> new MetalStepBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> HEADLIGHT = registerBlock("headlight",
            () -> new HeadlightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> ORNATE_IRON_TRAPDOOR = registerBlock("ornate_iron_trapdoor",
            () -> new TrainTrapdoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.GLASS).noOcclusion()));

    public static final DeferredBlock<Block> STATION_PLATFORM = registerBlock("station_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> METRO_CASING = registerBlock("metro_casing",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> CORRUGATED_METRO_CASING = registerBlock("corrugated_metro_casing",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> METRO_PANEL = registerBlock("metro_panel",
            () -> new PanelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> CORRUGATED_METRO_PANEL = registerBlock("corrugated_metro_panel",
            () -> new PanelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> METRO_WINDOW = registerBlock("metro_window",
            () -> new TrapDoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> METRO_TRAPDOOR = registerBlock("metro_trapdoor",
            () -> new TrainTrapdoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> METAL_PILOT = registerBlock("metal_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> ANDESITE_PILOT = registerBlock("andesite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> BRASS_PILOT = registerBlock("brass_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> COPPER_PILOT = registerBlock("copper_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    // Polished Pilots
    public static final DeferredBlock<Block> POLISHED_ANDESITE_PILOT = registerBlock("polished_andesite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_GRANITE_PILOT = registerBlock("polished_granite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_DIORITE_PILOT = registerBlock("polished_diorite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_DEEPSLATE_PILOT = registerBlock("polished_deepslate_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_PILOT = registerBlock("polished_dripstone_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_TUFF_PILOT = registerBlock("polished_tuff_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_CALCITE_PILOT = registerBlock("polished_calcite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_PILOT = registerBlock("polished_limestone_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_SCORIA_PILOT = registerBlock("polished_scoria_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_SCORCHIA_PILOT = registerBlock("polished_scorchia_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_CRIMSITE_PILOT = registerBlock("polished_crimsite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_OCHRUM_PILOT = registerBlock("polished_ochrum_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_VERIDIUM_PILOT = registerBlock("polished_veridium_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> POLISHED_ASURINE_PILOT = registerBlock("polished_asurine_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}