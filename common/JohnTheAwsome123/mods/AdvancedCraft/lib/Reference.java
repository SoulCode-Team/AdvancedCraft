package JohnTheAwsome123.mods.AdvancedCraft.lib;

import net.minecraft.creativetab.CreativeTabs;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;


/**
 * AdvancedCraft
 * 
 * Reference
 * @category Library
 * @author JohnTheAwsome123
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */
public class Reference {

    // General @Mod related constants //
    public static final String MOD_ID = "AdvancedCraft";
    public static final String MOD_NAME = "AdvancedCraft";
    public static final String VERSION_NUMBER = "0.0.2";
    
    //Proxy locations//
    public static final String PROXY_CLIENT = "JohnTheAwsome123.mods.AdvancedCraft.client.ClientProxy";
    public static final String PROXY_COMMON = "JohnTheAwsome123.mods.AdvancedCraft.CommonProxy";
    
    // Misc constants //
    public static final CreativeTabs ACTAB = AdvancedCraft.tabAdvancedCraft;
    public static final int MIN_FML_BUILD_NUMBER = 952;
    
    // Locations of the blacklists //
    public static final String DEFAULT_BLACKLIST_FILE_LOCATION = "/assets/advancedcraft/blacklist/";
    
}