package net.aaw.bellsandwhistles.item;

import net.aaw.bellsandwhistles.BellsAndWhistles;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
