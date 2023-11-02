package com.sudolev.bellsandwhistles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;
import com.sudolev.bellsandwhistles.content.CBWBlocks;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class BellsAndWhistles implements ModInitializer {
	public static final String ID = "bellsandwhistles";
	public static final String NAME = "Create: Bells & Whistles";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		CBWBlocks.registerModBlocks();
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
