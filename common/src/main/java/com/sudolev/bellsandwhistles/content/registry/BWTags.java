package com.sudolev.bellsandwhistles.content.registry;

import com.sudolev.bellsandwhistles.BellsAndWhistles;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BWTags {
	public static final class Blocks {
		public static final TagKey<Block> PILOTS = TagKey.create(Registries.BLOCK, BellsAndWhistles.asResource("pilots"));
	}

	public static final class Items {
		public static final TagKey<Block> PILOTS = TagKey.create(Registries.BLOCK, BellsAndWhistles.asResource("pilots"));
	}

	public static void register() {}
}
