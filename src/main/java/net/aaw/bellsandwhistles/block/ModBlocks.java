package net.aaw.bellsandwhistles.block;

import static com.simibubi.create.Create.REGISTRATE;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.actors.seat.SeatBlock;
import com.simibubi.create.content.contraptions.actors.seat.SeatInteractionBehaviour;
import com.simibubi.create.content.contraptions.actors.seat.SeatMovementBehaviour;
import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.foundation.block.DyedBlockList;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.utility.CreateRegistry;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.aaw.bellsandwhistles.block.custom.MetalGrabRailsBlock;
import net.aaw.bellsandwhistles.block.custom.MetalPilotBlock;
import net.aaw.bellsandwhistles.block.custom.StoolSeatBlock;
import net.aaw.bellsandwhistles.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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
            () -> new MetalPilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_TRAPDOOR)));
    public static final RegistryObject<Block> ANDESITE_GRAB_RAILS = registerBlock("andesite_grab_rails",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));
    public static final RegistryObject<Block> BRASS_GRAB_RAILS = registerBlock("brass_grab_rails",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));
    public static final RegistryObject<Block> COPPER_GRAB_RAILS = registerBlock("copper_grab_rails",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));

    public static final RegistryObject<Block> ANDESITE_BOGIE_STEPS = registerBlock("andesite_bogie_steps",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));
    public static final RegistryObject<Block> BRASS_BOGIE_STEPS = registerBlock("brass_bogie_steps",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));
    public static final RegistryObject<Block> COPPER_BOGIE_STEPS = registerBlock("copper_bogie_steps",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.copy(Blocks.RAIL)));


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
