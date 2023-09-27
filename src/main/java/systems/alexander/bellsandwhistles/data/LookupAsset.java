package systems.alexander.bellsandwhistles.data;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class LookupAsset {
    public static ModelFile partialBaseModel(DataGenContext<?, ?> ctx, RegistrateBlockstateProvider prov,
                                             String suffix) {
        String string = "/block";
        String location;

        if ( suffix == "folding_metro_bottom") {
            location = "block/metro/door/folding_metro_door_bottom";
        } else if ( suffix == "folding_metro_top") {
            location = "block/metro/door/folding_metro_door_top";
        } else if ( suffix == "sliding_metro_bottom") {
            location = "block/metro/door/sliding_metro_door_bottom";
        } else if ( suffix == "sliding_metro_top") {
            location = "block/metro/door/sliding_metro_door_top";
        } else {
            location = "block/metro/door/sliding_metro_door_top";
        }
        return prov.models()
                .getExistingFile(prov.modLoc(location));
    }

}
