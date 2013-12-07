package JohnTheAwsome123.mods.AdvancedCraft;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics or entities!
    }
    public String getCurrentLanguage()
    {
        return null;
    }
    
    public void RegisterCommonTickHandler(){
        TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);
    }
}