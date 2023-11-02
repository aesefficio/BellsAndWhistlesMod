package com.sudolev.bellsandwhistles.content;

import com.sudolev.bellsandwhistles.BellsAndWhistles;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CBWItemGroup {
	public static final CreativeModeTab BELLSANDWHISTLESTAB = FabricItemGroupBuilder.build(
			new ResourceLocation(BellsAndWhistles.ID, "bellsandwhistlestab"), () -> new ItemStack(CBWBlocks.METAL_PILOT));
}
