package com.sudolev.bellsandwhistles;

import net.minecraft.resources.ResourceLocation;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription.Modifier;
import com.simibubi.create.foundation.item.TooltipHelper.Palette;

import com.sudolev.bellsandwhistles.content.registry.BWBlocks;
import com.sudolev.bellsandwhistles.content.registry.BWTab;
import com.sudolev.bellsandwhistles.content.registry.BWTags;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BellsAndWhistles {
	public static final String ID = "bellsandwhistles";
	public static final String NAME = "Create: Bells & Whistles";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final String VERSION = Utils.getVersion(ID);

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

	static {
		REGISTRATE.setTooltipModifierFactory(item -> new Modifier(item, Palette.STANDARD_CREATE));
	}

	public static void init() {
		LOGGER.info("{} v{} initializing! Create version: {} on platform: {}",
			NAME, VERSION, Create.VERSION, Utils.platformName());

		BWTags.register();
		BWTab.register();
		BWBlocks.register();
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
}
