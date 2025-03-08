package systems.alexander.bellsandwhistles.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import systems.alexander.bellsandwhistles.BellsAndWhistles;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BellsAndWhistles.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
