package JohnTheAwsome123.mods.AdvancedCraft;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
{

    public void registerRenderers()
    {
    }

    public String getCurrentLanguage()
    {
        return null;
    }

    public void RegisterCommonTickHandler()
    {
        TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);
    }

    // From MachineMuse's PowerSuits mod
    public static boolean shouldAddAdditionalInfo()
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            {
                return true;
            }
        }
        return false;
    }

    public static Object additionalInfoInstructions()
    {
        String message = "§oPress §b<SHIFT>§7§o for more information.";
        return message;
    }
}