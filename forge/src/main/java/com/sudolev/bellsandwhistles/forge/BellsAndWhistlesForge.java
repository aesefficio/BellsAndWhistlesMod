package com.sudolev.bellsandwhistles.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import com.sudolev.bellsandwhistles.content.registry.forge.BWTabImpl;

@Mod(BellsAndWhistles.ID)
public class BellsAndWhistlesForge {
	public BellsAndWhistlesForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		BellsAndWhistles.init();
		BWTabImpl.register(modEventBus);
		BellsAndWhistles.REGISTRATE.registerEventListeners(modEventBus);
	}
}
