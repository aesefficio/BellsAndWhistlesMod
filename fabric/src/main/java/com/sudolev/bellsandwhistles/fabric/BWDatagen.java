package com.sudolev.bellsandwhistles.fabric;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Set;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;

import com.simibubi.create.foundation.utility.FilesHelper;

import com.sudolev.bellsandwhistles.BellsAndWhistles;

public class BWDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator gen) {
		BellsAndWhistles.LOGGER.info("Initializing data generator");
		Path resources = Paths.get(System.getProperty(ExistingFileHelper.EXISTING_RESOURCES));
		// fixme re-enable the existing file helper when porting lib's ResourcePackLoader.createPackForMod is fixed
		ExistingFileHelper helper = new ExistingFileHelper(
			Set.of(resources), Set.of("create"), false, null, null
		);

		BellsAndWhistles.REGISTRATE.setupDatagen(gen.createPack(), helper);

		provideDefaultLang("tooltips");
	}

	@SuppressWarnings("SameParameterValue")
	private static void provideDefaultLang(String fileName) {
		String path = "assets/" + BellsAndWhistles.ID + "/lang/default/" + fileName + ".json";

		JsonObject jsonObject = Preconditions.checkNotNull(FilesHelper.loadJsonResource(path),
			"Could not find default lang file: %s", path).getAsJsonObject();

		jsonObject.entrySet().forEach(entry ->
			BellsAndWhistles.REGISTRATE.addRawLang(entry.getKey(), entry.getValue().getAsString())
		);
	}
}
