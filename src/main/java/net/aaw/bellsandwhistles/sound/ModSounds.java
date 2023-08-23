package net.aaw.bellsandwhistles.sound;

import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BellsAndWhistles.MOD_ID);
    public static final RegistryObject<SoundEvent> BRASS_WHISTLE = registerSoundEvent("brass_whistle");
    public static final RegistryObject<SoundEvent> WOOD_WHISTLE = registerSoundEvent("wood_whistle");
    public static final RegistryObject<SoundEvent> FLY_ME_TO_THE_MOON = registerSoundEvent("fly_me_to_the_moon");

    public static final RegistryObject<SoundEvent> FRENCHCORE = registerSoundEvent("frenchcore");
    public static final RegistryObject<SoundEvent> KOPPABAVISAN = registerSoundEvent("koppabavisan");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(BellsAndWhistles.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}