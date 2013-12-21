package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GameRegisteryHandler
{
    public static AdvancedCraft AC;

    // LanguageRegistry.instance().addStringLocalization("item.NetherStarHelmet.name",
    // "en_US", "Nether Star Helmet");

    public static void registerBlocks()
    {
        // Register Blocks//
        GameRegistry.registerBlock(AC.netherStarBlock, "netherStarBlock");
        MinecraftForge.setBlockHarvestLevel(AC.netherStarBlock, "pickaxe", 4);

        GameRegistry.registerBlock(AC.netherStarOre, "netherStarOre");
        MinecraftForge.setBlockHarvestLevel(AC.netherStarOre, "pickaxe", 3);

//        GameRegistry.registerBlock(AC.mobCurtain, "mobCurtain");
        GameRegistry.registerBlock(AC.nerdPole, "nerdPole");
        GameRegistry.registerBlock(AC.cobblestoneGenerator, "cobblestoneGenerator");
        GameRegistry.registerBlock(AC.LiquidRemove_Holder, "LiquidRemove_Holder");

        // GameRegistry.registerBlock(advancedFurnaceIdle,
        // "advancedFurnaceIdle");
        // LanguageRegistry.addName(advancedFurnaceIdle, "Advanced Furnace");
        // MinecraftForge.setBlockHarvestLevel(advancedFurnaceIdle, "pickaxe",
        // 1);
    }

    public static void registerArmor()
    {
        // Register Armor//
        GameRegistry.registerItem(AC.netherStarHelmet, "netherStarHelmet");
        GameRegistry.registerItem(AC.netherStarChestplate, "netherStarChestplate");
        GameRegistry.registerItem(AC.netherStarLeggings, "netherStarLeggings");
        GameRegistry.registerItem(AC.netherStarBoots, "netherStarBoots");

    }

    public static void registerItems()
    {
        // Register Items//
        GameRegistry.registerItem(AC.netherStarNugget, "netherStarNugget");
        GameRegistry.registerItem(AC.netherStarShard, "netherStarShard");
        GameRegistry.registerItem(AC.enderHeart, "enderHeart");

        if (!Config.disableDoubler)
        {
            GameRegistry.registerItem(AC.Doubler, "Doubler");
        }
    }

    public static void registerFood()
    {
        // Register Food//
        GameRegistry.registerItem(AC.sugarCookie, "sugarCookie");
        GameRegistry.registerItem(AC.sugarCookieDough, "sugarCookieDough");
        GameRegistry.registerItem(AC.cookieDough, "cookieDough");

    }

    public static void registerFuels()
    {
        // Register Fuels//
        if (!Config.disableFuels)
        {
            GameRegistry.registerFuelHandler(new ACFuelHandler());
        }

    }

    public static void registerTools()
    {
        // Register Tools//
        GameRegistry.registerItem(AC.netherStarSword, "netherStarSword");
        GameRegistry.registerItem(AC.netherStarShovel, "netherStarShovel");
        GameRegistry.registerItem(AC.netherStarPickaxe, "netherStarPickaxe");
        GameRegistry.registerItem(AC.netherStarAxe, "netherStarAxe");
        GameRegistry.registerItem(AC.netherStarHoe, "netherStarHoe");
        GameRegistry.registerItem(AC.netherStarOmniTool, "netherStarOmniTool");
        GameRegistry.registerItem(AC.netherStarBow, "netherStarBow");
        GameRegistry.registerItem(AC.netherStarQuiver, "netherStarQuiver");
        GameRegistry.registerItem(AC.advancedClock, "advancedClock");
        GameRegistry.registerItem(AC.weathermansCompass, "weathermansCompass");

        // GameRegistry.registerItem(talismanOfRecollection,
        // "talismanOfRecollection");

        GameRegistry.registerItem(AC.Sponge, "Sponge");

    }

    public static void registerSuitOfArmor()
    {
        // Register suits of armor//
        GameRegistry.registerItem(AC.suitOfArmor_NetherStar, "suitOfArmor_NetherStar");
        GameRegistry.registerItem(AC.suitOfArmor_Diamond, "suitOfArmor_Diamond");
        GameRegistry.registerItem(AC.suitOfArmor_Iron, "suitOfArmor_Iron");
        GameRegistry.registerItem(AC.suitOfArmor_Gold, "suitOfArmor_Gold");
    }

    public static void registerAll()
    {
        registerArmor();
        registerBlocks();
        registerFood();
        registerFuels();
        registerItems();
        registerSuitOfArmor();
        registerTools();
    }
}
