package JohnTheAwsome123.mods.AdvancedCraft;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageRegisteryHandler
{
    // LanguageRegistry.instance().addStringLocalization("item.NetherStarHelmet.name",
    // "en_US", "Nether Star Helmet");
    public static AdvancedCraft AC;

    public static void registerBlocks()
    {
        // Register Blocks//
        LanguageRegistry.addName(AC.netherStarBlock, "Nether Star Block");
        LanguageRegistry.addName(AC.netherStarOre, "Nether Star Ore");
//        LanguageRegistry.addName(AC.mobCurtain, "Mob Curtain (WIP)");
        LanguageRegistry.addName(AC.nerdPole, "Nerd Pole");
        LanguageRegistry.addName(AC.cobblestoneGenerator, "Cobblestone Generator (WIP)");
        LanguageRegistry.addName(AC.LiquidRemove_Holder, "Liquid Removal Holder");

        // GameRegistry.registerBlock(advancedFurnaceIdle,
        // "advancedFurnaceIdle");
        // LanguageRegistry.addName(advancedFurnaceIdle, "Advanced Furnace");
        // MinecraftForge.setBlockHarvestLevel(advancedFurnaceIdle, "pickaxe",
        // 1);
    }

    public static void registerArmor()
    {
        // Register Armor//
        LanguageRegistry.addName(AC.netherStarHelmet, "Nether Star Helmet");
        LanguageRegistry.addName(AC.netherStarChestplate, "Nether Star Chestplate");
        LanguageRegistry.addName(AC.netherStarLeggings, "Nether Star Leggings");
        LanguageRegistry.addName(AC.netherStarBoots, "Nether Star Boots");
    }

    public static void registerItems()
    {
        // Register Items//
        LanguageRegistry.addName(AC.netherStarNugget, "Nether Star Nugget");
        LanguageRegistry.addName(AC.netherStarShard, "Nether Star Shard");
        LanguageRegistry.addName(AC.enderHeart, "Ender Heart");

        if (!Config.disableDoubler)
        {
            LanguageRegistry.addName(AC.Doubler, "Doubler");
        }
    }

    public static void registerFood()
    {

        // Register Food//
        LanguageRegistry.addName(AC.sugarCookie, "Sugar Cookie");
        LanguageRegistry.addName(AC.sugarCookieDough, "Sugar Cookie Dough");
        LanguageRegistry.addName(AC.cookieDough, "Cookie Dough");
    }

    public static void registerTools()
    {
        // Register Tools//
        LanguageRegistry.addName(AC.netherStarSword, "Nether Star Sword");
        LanguageRegistry.addName(AC.netherStarShovel, "Nether Star Shovel");
        LanguageRegistry.addName(AC.netherStarPickaxe, "Nether Star Pickaxe");
        LanguageRegistry.addName(AC.netherStarAxe, "Nether Star Axe");
        LanguageRegistry.addName(AC.netherStarHoe, "Nether Star Hoe");
        LanguageRegistry.addName(AC.netherStarOmniTool, "Nether Star Omni Tool");
        LanguageRegistry.addName(AC.netherStarBow, "Nether Star Bow");
        LanguageRegistry.addName(AC.netherStarQuiver, "Nether Star Quiver");
        LanguageRegistry.addName(AC.advancedClock, "Advanced Clock");
        LanguageRegistry.addName(AC.weathermansCompass, "Weatherman's Compass");

        // LanguageRegistry.addName(talismanOfRecollection,
        // "Talisman Of Recollection");
        LanguageRegistry.addName(AC.Sponge, "Sponge");
        LanguageRegistry.addName(AC.blockPlacer, "Block Placer");
    }

    public static void registerSuitOfArmor()
    {
        // Register suits of armor//
        LanguageRegistry.addName(AC.suitOfArmor_NetherStar, "Nether Star Suit Of Armor");
        LanguageRegistry.addName(AC.suitOfArmor_Diamond, "Diamond Suit Of Armor");
        LanguageRegistry.addName(AC.suitOfArmor_Iron, "Iron Suit Of Armor");
        LanguageRegistry.addName(AC.suitOfArmor_Gold, "Gold Suit Of Armor");
    }
    
    public static void registerTabs()
    {
    	LanguageRegistry.instance().addStringLocalization("itemGroup.tabAdvancedCraft", "en_US", "AdvancedCraft");
    }
    
    public static void registerAll()
    {
        registerArmor();
        registerBlocks();
        registerFood();
        registerItems();
        registerSuitOfArmor();
        registerTabs();
        registerTools();
        
    }
}
