package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;

/**
 * AdvancedCraft
 * 
 * Config
 * @category Configuration
 * @author JohnTheAwsome123
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */
public class Config
{
    public int startBlockID = 2500;
    public int BlockIncr = 0;
    public int startItemID = 2700;
    public int ItemIncr = 0;
    
    
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
        netherStarHelmetID = config.get("Item", "Nether Star Helmet", startItemID + ItemIncr).getInt();         ItemIncr += 1;
        netherStarChestplateID = config.get("Item", "Nether Star Chestplate", startItemID + ItemIncr).getInt(); ItemIncr += 1;
        netherStarLeggingsID = config.get("Item", "Nether Star Leggings", startItemID + ItemIncr).getInt();     ItemIncr += 1;
        netherStarBootsID = config.get("Item", "Nether Star Boots", startItemID + ItemIncr).getInt();           ItemIncr += 1;

        disableNetherStarHelmet = config.get("Options", "disable Nether Star Helmet", false).getBoolean(false);
        disableNetherStarChestplate = config.get("Options", "disable Nether Star Chestplate", false).getBoolean(false);
        disableNetherStarLeggings = config.get("Options", "disable Nether Star Leggings", false).getBoolean(false);
        disableNetherStarBoots = config.get("Options", "disable Nether Star Boots", false).getBoolean(false);

        // Configs for Items//
        netherStarShardID = config.get("Item", "Nether Star Shard", startItemID + ItemIncr).getInt();           ItemIncr += 1;
        netherStarNuggetID = config.get("Item", "Nether Star Nugget", startItemID + ItemIncr).getInt();         ItemIncr += 1;
        enderHeartID = config.get("Item", "Ender Heart", startItemID + ItemIncr).getInt();                      ItemIncr += 1;
        DoublerID = config.get("Item", "Doubler", startItemID + ItemIncr).getInt();                             ItemIncr += 1;
        
        disableDragonEgg = config.get("Options", "disable Dragon Egg crafting", false).getBoolean(false);

        // Configs for Food//
        sugarCookieID = config.get("Item", "Sugar Cookie", startItemID + ItemIncr).getInt();                    ItemIncr += 1;
        sugarCookieDoughID = config.get("Item", "Sugar Cookie Dough", startItemID + ItemIncr).getInt();         ItemIncr += 1;
        cookieDoughID = config.get("Item", "Cookie Dough", startItemID + ItemIncr).getInt();                    ItemIncr += 1;

        disableAlternateCookie = config.get("Options", "disable alternate cookie recipes", false).getBoolean(false);

        // Configs for Tools//
        netherStarSwordID = config.get("Item", "Nether Star Sword", startItemID + ItemIncr).getInt();           ItemIncr += 1;
        netherStarShovelID = config.get("Item", "Nether Star Shovel", startItemID + ItemIncr).getInt();         ItemIncr += 1;
        netherStarPickaxeID = config.get("Item", "Nether Star Pickaxe", startItemID + ItemIncr).getInt();       ItemIncr += 1;
        netherStarAxeID = config.get("Item", "Nether Star Axe", startItemID + ItemIncr).getInt();               ItemIncr += 1;
        netherStarHoeID = config.get("Item", "Nether Star Hoe", startItemID + ItemIncr).getInt();               ItemIncr += 1;
        netherStarOmniToolID = config.get("Item", "Nether Star Omni Tool", startItemID + ItemIncr).getInt();    ItemIncr += 1;
        netherStarBowID = config.get("Item", "Nether Star Bow", startItemID + ItemIncr).getInt();               ItemIncr += 1;
        netherStarQuiverID = config.get("Item", "Nether Star Quiver", startItemID + ItemIncr).getInt();         ItemIncr += 1;
        advancedClockID = config.get("Item", "Advanced Clock", startItemID + ItemIncr).getInt();                ItemIncr += 1;
        weathermansCompassID = config.get("Item", "Weatherman's Clock", startItemID + ItemIncr).getInt();       ItemIncr += 1;
//        talismanOfRecollectionID = config.get("Item", "Talisman Of Recollection", startItemID + ItemIncr).getInt(); ItemIncr += 1;
        SpongeID = config.get("Item", "Sponge", startItemID + ItemIncr).getInt();                               ItemIncr += 1;

        // Configs for suits of armor//
        suitOfArmor_NetherStarID = config.get("Item", "Suit Of Armor - Nether Star", startItemID + ItemIncr).getInt();  ItemIncr += 1;
        suitOfArmor_DiamondID = config.get("Item", "Suit Of Armor - Diamond", startItemID + ItemIncr).getInt(); ItemIncr += 1;
        suitOfArmor_IronID = config.get("Item", "Suit Of Armor - Iron", startItemID + ItemIncr).getInt();       ItemIncr += 1;
        suitOfArmor_GoldID = config.get("Item", "Suit Of Armor - Gold", startItemID + ItemIncr).getInt();       ItemIncr += 1;

        // Configs for Blocks//
        netherStarBlockID = config.get("Block", "Nether Star Block", startBlockID + BlockIncr).getInt();        BlockIncr += 1;
        netherStarOreID = config.get("Block", "Nether Star Ore", startBlockID + BlockIncr).getInt();            BlockIncr += 1;
        advancedFurnaceIdleID = config.get("Block", "Advanced Furnace (Idle)", startBlockID + BlockIncr).getInt();  BlockIncr += 1;
        advancedFurnaceActiveID = config.get("Block", "Advanced Furnace (Active)", startBlockID + BlockIncr).getInt();  BlockIncr += 1;
        mobCurtainID = config.get("Block", "Mob Curtain", startBlockID + BlockIncr).getInt();                   BlockIncr += 1;
        cobblestoneGeneratorID = config.get("Block", "Cobblestone Generator", startBlockID + BlockIncr).getInt();   BlockIncr += 1;
        nerdPoleID = config.get("Block", "Nerd Pole", startBlockID + BlockIncr).getInt();                       BlockIncr += 1;
        LiquidRemove_HolderID = config.get("Block", "Sponge_utility", startBlockID + BlockIncr).getInt();       BlockIncr += 1;

        // Configs for fuels//
        disableFuels = config.get("Options", "disable alternate smelting fuels", false).getBoolean(false);
        
        //Configs for Doubler//
        disableDoubler = config.get("Options", "disable item Doubler", false).getBoolean(false);
        disableAdvancedDoubler = config.get("Options", "disable item Doubler NBT Copy (does not disable doubler completely)", false).getBoolean(false);
        
        
        if (config.hasChanged())
        {
            config.save();
        }

    }
}
