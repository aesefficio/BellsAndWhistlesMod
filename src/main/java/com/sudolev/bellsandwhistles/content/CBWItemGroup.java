package com.sudolev.bellsandwhistles.content;

import net.minecraft.world.item.CreativeModeTab;
import systems.alexander.bellsandwhistles.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
public class CBWItemGroup {
    public static final CreativeModeTab BELLS_AND_WHISTLES_TAB = new CreativeModeTab("bellsandwhistlestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CBWBlocksRegistry.METAL_PILOT.get());
        }
    };
}
