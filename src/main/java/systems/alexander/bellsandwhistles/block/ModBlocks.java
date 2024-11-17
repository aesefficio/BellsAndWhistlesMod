package systems.alexander.bellsandwhistles.block;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.behaviour.DoorMovingInteraction;
import com.simibubi.create.content.decoration.TrainTrapdoorBlock;
import com.simibubi.create.content.decoration.copycat.CopycatPanelBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorMovementBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import systems.alexander.bellsandwhistles.BellsAndWhistles;
import systems.alexander.bellsandwhistles.block.custom.*;
import systems.alexander.bellsandwhistles.data.LookupAsset;
import systems.alexander.bellsandwhistles.item.ModCreativeModeTab;
import systems.alexander.bellsandwhistles.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.IOException;
import java.util.function.Supplier;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.simibubi.create.Create.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ModBlocks {
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
        return b -> b.tag(BlockTags.MINEABLE_WITH_AXE);
    }
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BellsAndWhistles.MOD_ID);
    public static final RegistryObject<Block> ANDESITE_GRAB_RAILS = registerBlock("andesite_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> BRASS_GRAB_RAILS = registerBlock("brass_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> COPPER_GRAB_RAILS = registerBlock("copper_grab_rails",
            () -> new MetalGrabRailsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> ANDESITE_BOGIE_STEPS = registerBlock("andesite_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> BRASS_BOGIE_STEPS = registerBlock("brass_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> COPPER_BOGIE_STEPS = registerBlock("copper_bogie_steps",
            () -> new MetalBogieStepsBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_DOOR_STEP = registerBlock("andesite_door_step",
            () -> new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> BRASS_DOOR_STEP = registerBlock("brass_door_step",
            () -> new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> COPPER_DOOR_STEP = registerBlock("copper_door_step" +
                    "",
            () -> new MetalStepBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> HEADLIGHT = registerBlock("headlight",
            () -> new HeadlightBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.LANTERN)));
    public static final RegistryObject<Block> ORNATE_IRON_TRAPDOOR = registerBlock("ornate_iron_trapdoor",
            () -> new TrainTrapdoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> STATION_PLATFORM = registerBlock("station_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).sound(SoundType.STONE).noOcclusion()));

    public static final RegistryObject<Block> METRO_CASING = registerBlock("metro_casing",
            () -> new CasingBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL), true));

    public static final RegistryObject<Block> CORRUGATED_METRO_CASING = registerBlock("corrugated_metro_casing",
            () -> new CasingBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL), true));

    public static final RegistryObject<Block> METRO_PANEL = registerBlock("metro_panel",
            () -> new PanelBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> CORRUGATED_METRO_PANEL = registerBlock("corrugated_metro_panel",
            () -> new PanelBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> METRO_WINDOW = registerBlock("metro_window",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> METRO_TRAPDOOR = registerBlock("metro_trapdoor",
            () -> new TrainTrapdoorBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> METAL_PILOT = registerBlock("metal_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> ANDESITE_PILOT = registerBlock("andesite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BRASS_PILOT = registerBlock("brass_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> COPPER_PILOT = registerBlock("copper_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_ANDESITE_PILOT = registerBlock("polished_andesite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_ASURINE_PILOT = registerBlock("polished_asurine_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_CALCITE_PILOT = registerBlock("polished_calcite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_CRIMSITE_PILOT = registerBlock("polished_crimsite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_DEEPSLATE_PILOT = registerBlock("polished_deepslate_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_DIORITE_PILOT = registerBlock("polished_diorite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_PILOT = registerBlock("polished_dripstone_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_GRANITE_PILOT = registerBlock("polished_granite_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_LIMESTONE_PILOT = registerBlock("polished_limestone_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_OCHRUM_PILOT = registerBlock("polished_ochrum_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_SCORCHIA_PILOT = registerBlock("polished_scorchia_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_SCORIA_PILOT = registerBlock("polished_scoria_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_TUFF_PILOT = registerBlock("polished_tuff_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> POLISHED_VERIDIUM_PILOT = registerBlock("polished_veridium_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModCreativeModeTab.BELLS_AND_WHISTLES_TAB);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
    }
}
