package net.aaw.bellsandwhistles.block;

import static com.simibubi.create.Create.REGISTRATE;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.actors.seat.SeatBlock;
import com.simibubi.create.content.contraptions.actors.seat.SeatInteractionBehaviour;
import com.simibubi.create.content.contraptions.actors.seat.SeatMovementBehaviour;
import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.foundation.block.DyedBlockList;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.aaw.bellsandwhistles.block.custom.MetalPilotBlock;
import net.aaw.bellsandwhistles.block.custom.StoolSeatBlock;
import net.aaw.bellsandwhistles.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            () -> new MetalPilotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final BlockEntry<MetalLadderBlock> ANDESITE_GRAB_RAILS =
        REGISTRATE.block("andesite_grab_rails", MetalLadderBlock::new)
                    .transform(BuilderTransformers.ladder("andesite", () -> DataIngredient.items(AllItems.ANDESITE_ALLOY.get()),
                            MapColor.STONE))
                    .register();

    public static final BlockEntry<MetalLadderBlock> BRASS_GRAB_RAILS =
            REGISTRATE.block("brass_grab_rails", MetalLadderBlock::new)
                    .transform(BuilderTransformers.ladder("brass",
                            () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/brass")), MapColor.TERRACOTTA_YELLOW))
                    .register();

    public static final BlockEntry<MetalLadderBlock> COPPER_GRAB_RAILS =
            REGISTRATE.block("copper_grab_rails", MetalLadderBlock::new)
                    .transform(BuilderTransformers.ladder("copper",
                            () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/copper")), MapColor.COLOR_ORANGE))
                    .register();


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
