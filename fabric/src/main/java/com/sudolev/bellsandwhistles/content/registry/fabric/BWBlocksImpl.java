package com.sudolev.bellsandwhistles.content.registry.fabric;

import com.sudolev.bellsandwhistles.BellsAndWhistles;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockStateProvider;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unchecked")
public class BWBlocksImpl {
	@ApiStatus.Internal
	public static <ModelFile> ModelFile customChairModelFile(Object o, String parent, String name,
															 ResourceLocation top, ResourceLocation side,
															 ResourceLocation sideTop, ResourceLocation sideFront) {
		BlockStateProvider p = (BlockStateProvider) o;
		return (ModelFile) p.models()
			.withExistingParent(name,
				p.modLoc(parent))
			.texture("top", top)
			.texture("side_top", sideTop)
			.texture("side_front", sideFront)
			.texture("side", side);
	}

	@ApiStatus.Internal
	public static <ModelFile> ModelFile getExistingModelFile(Object o, String name) {
		BlockStateProvider p = (BlockStateProvider) o;
		return (ModelFile) p.models().getExistingFile(p.modLoc(name));
	}

	@ApiStatus.Internal
	public static <ModelFile> ModelFile createModelFileWithExistingParent(Object p, String parent, String name) {
		BlockStateProvider provider = (BlockStateProvider) p;
		return (ModelFile) provider.models().withExistingParent(name, provider.modLoc(parent));
	}

	@ApiStatus.Internal
	public static <CM> CM modelWithRotation(Object model, int rotation) {
		return (CM) ConfiguredModel.builder()
			.modelFile((ModelFile) model)
			.rotationY(rotation)
			.build();
	}

	@ApiStatus.Internal
	public static void setupCreativeTab() {
		BellsAndWhistles.REGISTRATE.setCreativeTab(BWTabImpl.getKey());
	}
}
