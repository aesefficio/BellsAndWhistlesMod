package com.sudolev.bellsandwhistles.content;

import com.sudolev.bellsandwhistles.BellsAndWhistles;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.intellij.lang.annotations.Identifier;

public class CBWItemGroup {
	public static final CreativeModeTab BELLSANDWHISTLESTAB = FabricItemGroupBuilder.build(
			new Identifier(BellsAndWhistles.ID, "bellsandwhistlestab"), () -> new ItemStack(CBWBlocksRegistry.METAL_PILOT));
}
