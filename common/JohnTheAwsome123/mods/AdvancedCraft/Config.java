package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;

/**Config
 * @mod AdvancedCraft
 * 
 * @author JohnTheAwsome123
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Config
{
    public int startBlockID = 2500;
    public int BlockIncr = 0;
    public int startItemID = 2700;
    public int ItemIncr = 0;
    
    //Define Options//
    public static int validDistance;
    
    
    // Define Items//
    public static int enderHeartID;
    public static int netherStarNuggetID;
    public static int netherStarShardID;
    public static int DoublerID;

    // Define Food//
    public static int sugarCookieID;
    public static int sugarCookieDoughID;
    public static int cookieDoughID;

    // Define Tool Material
    public static EnumToolMaterial netherStarTool = EnumHelper.addToolMaterial("netherStar", 4, 1024, 10.0F, 4.0F, 30);

    // Define Tools//
    public static int netherStarPickaxeID;
    public static int netherStarAxeID;
    public static int netherStarShovelID;
    public static int netherStarSwordID;
    public static int netherStarHoeID;
    public static int netherStarOmniToolID;
    public static int netherStarBowID;
    public static int netherStarQuiverID;
    public static int advancedClockID;
    public static int weathermansCompassID;
    public static int talismanOfRecollectionID;
    public static int SpongeID;
    public static int blockPlacerID;
    public static int controlPanelID;
    
    
    //Define Suits of armor//
    public static int suitOfArmor_NetherStarID;
    public static int suitOfArmor_DiamondID;
    public static int suitOfArmor_IronID;
    public static int suitOfArmor_GoldID;

    // Define Blocks//
    public static int netherStarBlockID;
    public static int netherStarOreID;
    public static int cobblestoneGeneratorID;
    public static int nerdPoleID;
    public static int advancedFurnaceIdleID;
    public static int advancedFurnaceActiveID;
    public static int mobCurtainID;
    public static int LiquidRemove_HolderID;
    public static int RemoteInterfaceID;


    // Define Armor Material
    public static EnumArmorMaterial netherStarArmor = EnumHelper.addArmorMaterial("netherStar", 75, new int[] { 5, 10, 8, 5 }, 30);

    // Define Armor//
    public static int netherStarHelmetID;
    public static int netherStarChestplateID;
    public static int netherStarLeggingsID;
    public static int netherStarBootsID;

    // Define Item Crafting Disabling//
    public static boolean disableDragonEgg;

    // Define Food Crafting Disabling//
    public static boolean disableAlternateCookie;

    // Define Fuels Disabling//
    public static boolean disableFuels;

    // Define Doubler Disabling//
    public static boolean disableDoubler;
    
    //Define NBT Doubler Disabling//
    public static boolean disableAdvancedDoubler;

    // Define Armor Disabling//
    public static boolean disableNetherStarHelmet;
    public static boolean disableNetherStarChestplate;
    public static boolean disableNetherStarLeggings;
    public static boolean disableNetherStarBoots;
    
    
    public Config(Configuration config)
    {
        config.load();
        
     // Cofigs for armor//
        netherStarHelmetID = config.get("Item", "Nether Star Helmet", startItemID + ItemIncr++).getInt();
        netherStarChestplateID = config.get("Item", "Nether Star Chestplate", startItemID + ItemIncr++).getInt();
        netherStarLeggingsID = config.get("Item", "Nether Star Leggings", startItemID + ItemIncr++).getInt();
        netherStarBootsID = config.get("Item", "Nether Star Boots", startItemID + ItemIncr++).getInt();

        disableNetherStarHelmet = config.get("Options", "disable Nether Star Helmet", false).getBoolean(false);
        disableNetherStarChestplate = config.get("Options", "disable Nether Star Chestplate", false).getBoolean(false);
        disableNetherStarLeggings = config.get("Options", "disable Nether Star Leggings", false).getBoolean(false);
        disableNetherStarBoots = config.get("Options", "disable Nether Star Boots", false).getBoolean(false);

        // Configs for Items//
        netherStarShardID = config.get("Item", "Nether Star Shard", startItemID + ItemIncr++).getInt();
        netherStarNuggetID = config.get("Item", "Nether Star Nugget", startItemID + ItemIncr++).getInt();
        enderHeartID = config.get("Item", "Ender Heart", startItemID + ItemIncr++).getInt();
        DoublerID = config.get("Item", "Doubler", startItemID + ItemIncr++).getInt();
        
        disableDragonEgg = config.get("Options", "disable Dragon Egg crafting", false).getBoolean(false);

        // Configs for Food//
        sugarCookieID = config.get("Item", "Sugar Cookie", startItemID + ItemIncr++).getInt();
        sugarCookieDoughID = config.get("Item", "Sugar Cookie Dough", startItemID + ItemIncr++).getInt();
        cookieDoughID = config.get("Item", "Cookie Dough", startItemID + ItemIncr++).getInt();

        disableAlternateCookie = config.get("Options", "disable alternate cookie recipes", false).getBoolean(false);

        // Configs for Tools//
        netherStarSwordID = config.get("Item", "Nether Star Sword", startItemID + ItemIncr++).getInt();
        netherStarShovelID = config.get("Item", "Nether Star Shovel", startItemID + ItemIncr++).getInt();
        netherStarPickaxeID = config.get("Item", "Nether Star Pickaxe", startItemID + ItemIncr++).getInt();
        netherStarAxeID = config.get("Item", "Nether Star Axe", startItemID + ItemIncr++).getInt();
        netherStarHoeID = config.get("Item", "Nether Star Hoe", startItemID + ItemIncr++).getInt();
        netherStarOmniToolID = config.get("Item", "Nether Star Omni Tool", startItemID + ItemIncr++).getInt();
        netherStarBowID = config.get("Item", "Nether Star Bow", startItemID + ItemIncr++).getInt();
        netherStarQuiverID = config.get("Item", "Nether Star Quiver", startItemID + ItemIncr++).getInt();
        advancedClockID = config.get("Item", "Advanced Clock", startItemID + ItemIncr++).getInt();
        weathermansCompassID = config.get("Item", "Weatherman's Clock", startItemID + ItemIncr++).getInt();
//        talismanOfRecollectionID = config.get("Item", "Talisman Of Recollection", startItemID + ItemIncr++).getInt();
        SpongeID = config.get("Item", "Sponge", startItemID + ItemIncr++).getInt();
        blockPlacerID = config.get("Item", "Block Placer", startItemID + ItemIncr++).getInt();
        controlPanelID = config.get("Item", "Control Panel", startItemID + ItemIncr++).getInt();

        // Configs for suits of armor//
        suitOfArmor_NetherStarID = config.get("Item", "Suit Of Armor - Nether Star", startItemID + ItemIncr++).getInt();
        suitOfArmor_DiamondID = config.get("Item", "Suit Of Armor - Diamond", startItemID + ItemIncr++).getInt();
        suitOfArmor_IronID = config.get("Item", "Suit Of Armor - Iron", startItemID + ItemIncr++).getInt();
        suitOfArmor_GoldID = config.get("Item", "Suit Of Armor - Gold", startItemID + ItemIncr++).getInt();

        // Configs for Blocks//
        netherStarBlockID = config.get("Block", "Nether Star Block", startBlockID + BlockIncr++).getInt();
        netherStarOreID = config.get("Block", "Nether Star Ore", startBlockID + BlockIncr++).getInt();
        advancedFurnaceIdleID = config.get("Block", "Advanced Furnace (Idle)", startBlockID + BlockIncr++).getInt();
        advancedFurnaceActiveID = config.get("Block", "Advanced Furnace (Active)", startBlockID + BlockIncr++).getInt();
        mobCurtainID = config.get("Block", "Mob Curtain", startBlockID + BlockIncr++).getInt();
        cobblestoneGeneratorID = config.get("Block", "Cobblestone Generator", startBlockID + BlockIncr++).getInt();
        nerdPoleID = config.get("Block", "Nerd Pole", startBlockID + BlockIncr++).getInt();
        LiquidRemove_HolderID = config.get("Block", "Sponge_utility", startBlockID + BlockIncr++).getInt();
        RemoteInterfaceID = config.get("Block", "Remote Interface", startBlockID + BlockIncr++).getInt();

        // Configs for fuels//
        disableFuels = config.get("Options", "disable alternate smelting fuels", false).getBoolean(false);
        
        //Configs for Doubler//
        disableDoubler = config.get("Options", "disable item Doubler", false).getBoolean(false);
        disableAdvancedDoubler = config.get("Options", "disable item Doubler NBT Copy (does not disable doubler completely)", false).getBoolean(false);
        
        //Config for Options//
        validDistance = config.get("Options", "Max Remote Interface Distance", 16).getInt(16);
        
        if (config.hasChanged())
        {
            config.save();
        }

    }
}
