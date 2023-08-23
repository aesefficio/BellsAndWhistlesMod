package net.aaw.bellsandwhistles.block;

import com.tterrag.registrate.builders.BlockBuilder;
import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.aaw.bellsandwhistles.block.custom.MetalBogieStepsBlock;
import net.aaw.bellsandwhistles.block.custom.MetalGrabRailsBlock;
import net.aaw.bellsandwhistles.block.custom.PilotBlock;
import net.aaw.bellsandwhistles.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
        return b -> b.tag(BlockTags.MINEABLE_WITH_AXE);
    }
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BellsAndWhistles.MOD_ID);
    public static final RegistryObject<Block> METAL_PILOT = registerBlock("metal_pilot",
            () -> new PilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
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


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    };
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
    }
}
