package net.aaw.bellsandwhistles.item;

import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.aaw.bellsandwhistles.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BellsAndWhistles.MOD_ID);

        public static final RegistryObject<Item> BRASS_WHISTLE = ITEMS.register("brass_whistle",
            () -> new Item(new Item.Properties().stacksTo(1)));
        public static final RegistryObject<Item> WOODEN_WHISTLE = ITEMS.register("wooden_whistle",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EVANGELION_DISC = ITEMS.register("evangelion_disc",
            () -> new RecordItem(15, ModSounds.FLY_ME_TO_THE_MOON, new Item.Properties().stacksTo(1), 4840));
    public static final RegistryObject<Item> FRENCHCORE_DISC = ITEMS.register("frenchcore_disc",
            () -> new RecordItem(14, ModSounds.FRENCHCORE, new Item.Properties().stacksTo(1), 3320));
    public static final RegistryObject<Item> DALARNA_DISC = ITEMS.register("dalarna_disc",
            () -> new RecordItem(13, ModSounds.KOPPABAVISAN, new Item.Properties().stacksTo(1), 3160));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
