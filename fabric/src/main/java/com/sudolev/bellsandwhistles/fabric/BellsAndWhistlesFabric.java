package com.sudolev.bellsandwhistles.fabric;

import net.fabricmc.api.ModInitializer;
import com.sudolev.bellsandwhistles.BellsAndWhistles;

public class BellsAndWhistlesFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		BellsAndWhistles.init();
		BellsAndWhistles.REGISTRATE.register();
	}
}
