package com.sudolev.bellsandwhistles.content;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

import org.intellij.lang.annotations.Identifier;

public class CBWBlocksRegistry {
		public static final Block METAL_PILOT = registerBlock("metal_Pilot",
				new Block(FabricBlockSettings.of(Material.METAL).strength(4f)), CBWItemGroup.BELLSANDWHISTLESTAB);


		private static Block registerBlock(String name, Block block, CreativeModeTab tab) {
			registerBlockItem(name, block, tab);
			return Registry.register(Registry.BLOCK, new Identifier(BellsAndWhistles.ID, name), block);
		}

		private static Item registerBlockItem(String name, Block block, CreativeModeTab tab) {
			return Registry.register(Registry.ITEM, new Identifier(BellsAndWhistles.ID, name),
					new BlockItem(block, new FabricItemSettings().group(tab)));
		}

		public static void registerModBlocks() {
			BellsAndWhistles.LOGGER.debug("Registering ModBlocks for " + BellsAndWhistles.ID);
		}

}
