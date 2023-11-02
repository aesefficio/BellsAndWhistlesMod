package com.sudolev.bellsandwhistles;

import com.sudolev.bellsandwhistles.content.CBWBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class BellsAndWhistlesClient implements ClientModInitializer {
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.METRO_WINDOW, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.ORNATE_IRON_TRAPDOOR, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.HEADLIGHT, RenderType.cutout());

		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.ANDESITE_GRAB_RAILS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.BRASS_GRAB_RAILS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.COPPER_GRAB_RAILS, RenderType.cutout());

		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.ANDESITE_BOGIE_STEPS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.BRASS_BOGIE_STEPS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.COPPER_BOGIE_STEPS, RenderType.cutout());

		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.ANDESITE_DOOR_STEP, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.BRASS_DOOR_STEP, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CBWBlocks.COPPER_DOOR_STEP, RenderType.cutout());
	}
}
