package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.block.Block;
import net.minecraftforge.common.Property;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import JohnTheAwsome123.mods.AdvancedCraft.food.*;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import JohnTheAwsome123.mods.AdvancedCraft.*;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import JohnTheAwsome123.mods.AdvancedCraft.armor.*;
import JohnTheAwsome123.mods.AdvancedCraft.item.*;
import JohnTheAwsome123.mods.AdvancedCraft.block.*;
import JohnTheAwsome123.mods.AdvancedCraft.tools.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.Side;

@Mod(name = "AdvancedCraft", version = "0.0.1", useMetadata = false, modid = "AdvancedCraft", acceptedMinecraftVersions = "[1.6,1.7)", dependencies = "required-after:Forge@[9.10.0.800,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AdvancedCraft
{

    public static CreativeTabs tabAdvancedCraft = new CreativeTabs("tabAdvancedCraft")
    {
        public ItemStack getIconItemStack()
        {
            return new ItemStack(Block.workbench);
        }
    };

    // Define Items//
    public static Item enderHeart;

    public static Item netherStarNugget;

    public static Item netherStarShard;

    public static Item Doubler;

    // Define Food//
    public static Item sugarCookie;

    public static Item sugarCookieDough;

    public static Item cookieDough;

    // Define Tool Material
    public static EnumToolMaterial netherStarTool = EnumHelper.addToolMaterial("netherStar", 4, 1024, 10.0F, 4.0F, 30);

    // Define Tools//
    public static Item netherStarPickaxe;

    public static Item netherStarAxe;

    public static Item netherStarShovel;

    public static Item netherStarSword;

    public static Item netherStarHoe;

    public static Item netherStarOmniTool;

    public static Item netherStarBow;

    public static Item netherStarQuiver;

    public static Item advancedClock;

    public static Item weathermansCompass;
    
    public static Item talismanOfRecollection;
    
    public static Item Sponge;
    
    
    //Define Suits of armor//
    public static Item suitOfArmor_NetherStar;

    public static Item suitOfArmor_Diamond;

    public static Item suitOfArmor_Iron;

    public static Item suitOfArmor_Gold;

    // Define Blocks//
    public static Block netherStarBlock;

    public static Block netherStarOre;

    public static Block cobblestoneGenerator;

    public static Block nerdPole;

    public static Block advancedFurnaceIdle;

    public static Block advancedFurnaceActive;

    public static Block mobCurtain;
    
    public static Block LiquidRemove_Holder;


    // Define Armor Material
    public static EnumArmorMaterial netherStarArmor = EnumHelper.addArmorMaterial("netherStar", 75, new int[] { 5, 10, 8, 5 }, 30);

    // Define Armor//
    public static Item netherStarHelmet;

    public static Item netherStarChestplate;

    public static Item netherStarLeggings;

    public static Item netherStarBoots;


    // The instance of your mod that Forge uses.
    @Instance("AdvancedCraft")
    public static AdvancedCraft instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "JohnTheAwsome123.mods.AdvancedCraft.client.ClientProxy", serverSide = "JohnTheAwsome123.mods.AdvancedCraft.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("Loading AdvancedCraft");
        // Stub Method
        proxy.registerRenderers();

        LanguageRegistry.instance().addStringLocalization("itemGroup.tabAdvancedCraft", "en_US", "AdvancedCraft");
        
        // Set up Config File//
        Config config = new Config(new Configuration(event.getSuggestedConfigurationFile()));


        // Remove Vanilla crafting recipes//
        if (!Config.disableAlternateCookie){
            removeVanillaRecipe.remove(Item.cookie);}

        // Settings for NS Armor
        // if (!DisableNetherStarHelmet){
        netherStarHelmet = new netherStarHelmet(Config.netherStarHelmetID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 0);// }
        netherStarChestplate = new netherStarChestplate(Config.netherStarChestplateID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 1);
        netherStarLeggings = new netherStarLeggings(Config.netherStarLeggingsID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 2);
        netherStarBoots = new netherStarBoots(Config.netherStarBootsID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 3);

        // Set up Items//
        enderHeart = new enderHeart(Config.enderHeartID);
        netherStarNugget = new netherStarNugget(Config.netherStarNuggetID);
        netherStarShard = new netherStarShard(Config.netherStarShardID);
        if (!Config.disableDoubler){
            Doubler = new Doubler(Config.DoublerID);}

        // Set up Food//
        sugarCookie = new sugarCookie(Config.sugarCookieID, 2, false);
        sugarCookieDough = new sugarCookieDough(Config.sugarCookieDoughID, 1, 0.1F, false);
        cookieDough = new cookieDough(Config.cookieDoughID, 1, 0.1F, false);

        // Set up Tools//
        netherStarSword = new netherStarSword(Config.netherStarSwordID, netherStarTool);
        netherStarShovel = new netherStarShovel(Config.netherStarShovelID, netherStarTool);
        netherStarPickaxe = new netherStarPickaxe(Config.netherStarPickaxeID, netherStarTool);
        netherStarAxe = new netherStarAxe(Config.netherStarAxeID, netherStarTool);
        netherStarHoe = new netherStarHoe(Config.netherStarHoeID, netherStarTool);
        netherStarOmniTool = new netherStarOmniTool(Config.netherStarOmniToolID, netherStarTool);
        netherStarBow = new netherStarBow(Config.netherStarBowID);
        netherStarQuiver = new netherStarQuiver(Config.netherStarQuiverID);
        advancedClock = new advancedClock(Config.advancedClockID);
        weathermansCompass = new weathermansCompass(Config.weathermansCompassID);
        talismanOfRecollection = new talismanOfRecollection(Config.talismanOfRecollectionID);
        Sponge = new Sponge(Config.SpongeID);

        // Set Up Suit Of Armor//
        suitOfArmor_NetherStar = new suitOfArmorBase(Config.suitOfArmor_NetherStarID, new ItemStack[] { new ItemStack(AdvancedCraft.netherStarBoots), new ItemStack(AdvancedCraft.netherStarLeggings), new ItemStack(AdvancedCraft.netherStarChestplate), new ItemStack(AdvancedCraft.netherStarHelmet), new ItemStack(AdvancedCraft.netherStarSword) }).setUnlocalizedName("suitOfArmor_NetherStar");
        suitOfArmor_Diamond = new suitOfArmorBase(Config.suitOfArmor_DiamondID, new ItemStack[] { new ItemStack(Item.bootsDiamond), new ItemStack(Item.legsDiamond), new ItemStack(Item.plateDiamond), new ItemStack(Item.helmetDiamond), new ItemStack(Item.swordDiamond) }).setUnlocalizedName("suitOfArmor_Diamond");
        suitOfArmor_Iron = new suitOfArmorBase(Config.suitOfArmor_IronID, new ItemStack[] { new ItemStack(Item.bootsIron), new ItemStack(Item.legsIron), new ItemStack(Item.plateIron), new ItemStack(Item.helmetIron), new ItemStack(Item.swordIron) }).setUnlocalizedName("suitOfArmor_Iron");
        suitOfArmor_Gold = new suitOfArmorBase(Config.suitOfArmor_GoldID, new ItemStack[] { new ItemStack(Item.bootsGold), new ItemStack(Item.legsGold), new ItemStack(Item.plateGold), new ItemStack(Item.helmetGold), new ItemStack(Item.swordGold) }).setUnlocalizedName("suitOfArmor_Gold");

        // Set up Blocks//
        netherStarBlock = new netherStarBlock(Config.netherStarBlockID, Material.iron);
        mobCurtain = new mobCurtain(Config.mobCurtainID, Material.grass);
        netherStarOre = new netherStarOre(Config.netherStarOreID, Material.rock);
        cobblestoneGenerator = new cobblestoneGenerator(Config.cobblestoneGeneratorID);
        nerdPole = new nerdPole(Config.nerdPoleID);
        LiquidRemove_Holder = new LiquidRemoveHolder(Config.LiquidRemove_HolderID);
        // advancedFurnaceIdle = new advancedFurnace(advancedFurnaceIdleID,
        // false);
        // advancedFurnaceActive = new advancedFurnace(advancedFurnaceActiveID,
        // true);

        // advancedFurnace = new advancedFurnace(advancedFurnaceID, false);

        // final Item EnderShard = new EnderShard(5000);
        // final Block blazingTorch = new blazingTorch(5001);
        // blazingTorch = new
        // blazingTorch(500).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Blazing Torch").setCreativeTab(CreativeTabs.tabDecorations);
        // GameRegistry.registerBlock(blazingTorch, "blazingTorch");
        // LanguageRegistry.addName(blazingTorch, "Blazing Torch");

        // Register Blocks//
        GameRegistry.registerBlock(netherStarBlock, "netherStarBlock");
        LanguageRegistry.addName(netherStarBlock, "Nether Star Block");
        MinecraftForge.setBlockHarvestLevel(netherStarBlock, "pickaxe", 4);

        GameRegistry.registerBlock(netherStarOre, "netherStarOre");
        LanguageRegistry.addName(netherStarOre, "Nether Star Ore");
        MinecraftForge.setBlockHarvestLevel(netherStarOre, "pickaxe", 3);

        GameRegistry.registerBlock(mobCurtain, "mobCurtain");
        LanguageRegistry.addName(mobCurtain, "Mob Curtain (WIP)");

        GameRegistry.registerBlock(nerdPole, "nerdPole");
        LanguageRegistry.addName(nerdPole, "Nerd Pole");

        GameRegistry.registerBlock(cobblestoneGenerator, "cobblestoneGenerator");
        LanguageRegistry.addName(cobblestoneGenerator, "Cobblestone Generator (WIP)");
        
        GameRegistry.registerBlock(LiquidRemove_Holder, "LiquidRemove_Holder");
        LanguageRegistry.addName(LiquidRemove_Holder, "Liquid Removal Holder");

        // GameRegistry.registerBlock(advancedFurnaceIdle,
        // "advancedFurnaceIdle");
        // LanguageRegistry.addName(advancedFurnaceIdle, "Advanced Furnace");
        // MinecraftForge.setBlockHarvestLevel(advancedFurnaceIdle, "pickaxe",
        // 1);

        // Register Armor//
        GameRegistry.registerItem(netherStarHelmet, "netherStarHelmet");
        LanguageRegistry.addName(netherStarHelmet, "Nether Star Helmet");
        // LanguageRegistry.instance().addStringLocalization("item.NetherStarHelmet.name",
        // "en_US", "Nether Star Helmet");

        GameRegistry.registerItem(netherStarChestplate, "netherStarChestplate");
        LanguageRegistry.addName(netherStarChestplate, "Nether Star Chestplate");

        GameRegistry.registerItem(netherStarLeggings, "netherStarLeggings");
        LanguageRegistry.addName(netherStarLeggings, "Nether Star Leggings");

        GameRegistry.registerItem(netherStarBoots, "netherStarBoots");
        LanguageRegistry.addName(netherStarBoots, "Nether Star Boots");

        // Register Items//
        GameRegistry.registerItem(netherStarNugget, "netherStarNugget");
        LanguageRegistry.addName(netherStarNugget, "Nether Star Nugget");

        GameRegistry.registerItem(netherStarShard, "netherStarShard");
        LanguageRegistry.addName(netherStarShard, "Nether Star Shard");

        GameRegistry.registerItem(enderHeart, "enderHeart");
        LanguageRegistry.addName(enderHeart, "Ender Heart");
        
        if (!Config.disableDoubler){
        GameRegistry.registerItem(Doubler, "Doubler");
        LanguageRegistry.addName(Doubler, "Doubler");}

        // Register Food//
        GameRegistry.registerItem(sugarCookie, "sugarCookie");
        LanguageRegistry.addName(sugarCookie, "Sugar Cookie");

        GameRegistry.registerItem(sugarCookieDough, "sugarCookieDough");
        LanguageRegistry.addName(sugarCookieDough, "Sugar Cookie Dough");

        GameRegistry.registerItem(cookieDough, "cookieDough");
        LanguageRegistry.addName(cookieDough, "Cookie Dough");

        // Register Fuels//
        if (!Config.disableFuels)
        {
            GameRegistry.registerFuelHandler(new AdvancedCraftFuelHandler());
        }

        // Register Tools//
        GameRegistry.registerItem(netherStarSword, "netherStarSword");
        LanguageRegistry.addName(netherStarSword, "Nether Star Sword");

        GameRegistry.registerItem(netherStarShovel, "netherStarShovel");
        LanguageRegistry.addName(netherStarShovel, "Nether Star Shovel");

        GameRegistry.registerItem(netherStarPickaxe, "netherStarPickaxe");
        LanguageRegistry.addName(netherStarPickaxe, "Nether Star Pickaxe");

        GameRegistry.registerItem(netherStarAxe, "netherStarAxe");
        LanguageRegistry.addName(netherStarAxe, "Nether Star Axe");

        GameRegistry.registerItem(netherStarHoe, "netherStarHoe");
        LanguageRegistry.addName(netherStarHoe, "Nether Star Hoe");

        GameRegistry.registerItem(netherStarOmniTool, "netherStarOmniTool");
        LanguageRegistry.addName(netherStarOmniTool, "Nether Star Omni Tool");

        GameRegistry.registerItem(netherStarBow, "netherStarBow");
        LanguageRegistry.addName(netherStarBow, "Nether Star Bow");

        GameRegistry.registerItem(netherStarQuiver, "netherStarQuiver");
        LanguageRegistry.addName(netherStarQuiver, "Nether Star Quiver");

        GameRegistry.registerItem(advancedClock, "advancedClock");
        LanguageRegistry.addName(advancedClock, "Advanced Clock");

        GameRegistry.registerItem(weathermansCompass, "weathermansCompass");
        LanguageRegistry.addName(weathermansCompass, "Weatherman's Compass");
        
        GameRegistry.registerItem(talismanOfRecollection, "talismanOfRecollection");
        LanguageRegistry.addName(talismanOfRecollection, "Talisman Of Recollection");
        
        GameRegistry.registerItem(Sponge, "Sponge");
        LanguageRegistry.addName(Sponge, "Sponge");
        

        // Register suits of armor//
        GameRegistry.registerItem(suitOfArmor_NetherStar, "suitOfArmor_NetherStar");
        LanguageRegistry.addName(suitOfArmor_NetherStar, "Nether Star Suit Of Armor");

        GameRegistry.registerItem(suitOfArmor_Diamond, "suitOfArmor_Diamond");
        LanguageRegistry.addName(suitOfArmor_Diamond, "Diamond Suit Of Armor");

        GameRegistry.registerItem(suitOfArmor_Iron, "suitOfArmor_Iron");
        LanguageRegistry.addName(suitOfArmor_Iron, "Iron Suit Of Armor");

        GameRegistry.registerItem(suitOfArmor_Gold, "suitOfArmor_Gold");
        LanguageRegistry.addName(suitOfArmor_Gold, "Gold Suit Of Armor");

        // Universal Ingredients//
        ItemStack nStarStack = new ItemStack(Item.netherStar);
        ItemStack stickStack = new ItemStack(Item.stick);

        // Recipes for Blocks//
        GameRegistry.addRecipe(new ItemStack(Block.web), "s s", " s ", "s s", 's', new ItemStack(Item.silk));
        GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomRed), 'd', new ItemStack(Block.dirt));
        GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomBrown), 'd', new ItemStack(Block.dirt));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBlock), "sss", "sss", "sss", 's', new ItemStack(Item.netherStar));

        // Recipes for Items//
        GameRegistry.addRecipe(new ItemStack(Item.emerald), "ggg", "gdg", "ggg", 'g', new ItemStack(Item.dyePowder, 1, 2), 'd', new ItemStack(Item.diamond));
        if (!Config.disableDragonEgg){
            GameRegistry.addRecipe(new ItemStack(Block.dragonEgg), " o ", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 'h', new ItemStack(AdvancedCraft.enderHeart));}
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.enderHeart), "ses", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 's', new ItemStack(Block.whiteStone));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarNugget), "sss", "sss", "sss", 's', new ItemStack(AdvancedCraft.netherStarShard));
        GameRegistry.addRecipe(new ItemStack(Item.netherStar), "nnn", "nnn", "nnn", 'n', new ItemStack(AdvancedCraft.netherStarNugget));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.glowstone, 4), new ItemStack(Block.glowStone));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.snowball, 4), new ItemStack(Block.snow));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.clay, 4), new ItemStack(Block.blockClay));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarShard, 9), new ItemStack(AdvancedCraft.netherStarNugget));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarNugget, 9), new ItemStack(Item.netherStar));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.netherStar, 9), new ItemStack(AdvancedCraft.netherStarBlock));

        // Recipes for Food//
        
        if (!Config.disableAlternateCookie){
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.sugarCookieDough, 8), "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.cookieDough, 8), "wcw", 'c', new ItemStack(Item.dyePowder, 1, 3), 'w', new ItemStack(Item.wheat));
        }
        else{
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.sugarCookie, 8), "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
        }
            

        // Recipes for Armor//
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHelmet), "nnn", "n n", "   ", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarChestplate), "n n", "nnn", "nnn", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarLeggings), "nnn", "n n", "n n", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBoots), "n n", "n n", 'n', new ItemStack(Item.netherStar));

        // Recipes for Tools//
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarSword), " n ", " n ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarShovel), " n ", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarPickaxe), "nnn", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarAxe), "nn ", "ns ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHoe), "nn ", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), new ItemStack(Block.sponge));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.Sponge), "yyy", "ysy", "yyy", 'y', new ItemStack(Item.dyePowder, 1, 11), 's', new ItemStack(Block.cobblestone));

        // Recipes for Suit of armor//
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_NetherStar), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_NetherStar.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Diamond), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Diamond.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Iron), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Iron.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Gold), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Gold.itemID));

         

        // Smelting//
        GameRegistry.addSmelting(AdvancedCraft.sugarCookieDough.itemID, new ItemStack(AdvancedCraft.sugarCookie), 1.0f);
        GameRegistry.addSmelting(AdvancedCraft.cookieDough.itemID, new ItemStack(Item.cookie), 1.0f);

        // Crafting//
        // GameRegistry.addRecipe(new ItemStack(Block.commandBlock), "srs",
        // "rnr", "srs",
        // 'r', new ItemStack(Item.redstone), 'n', nStarStack, 's', new
        // ItemStack(Block.stone));
        // GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new
        // ItemStack(Block.planks, 4));
    }
    
    @EventHandler
    public void Init(FMLPostInitializationEvent event){
        TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);
        GameRegistry.registerCraftingHandler(new ACCraftingHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println(FluidRegistry.getFluidID(FluidRegistry.lookupFluidForBlock(Block.waterStill).getName()));
        System.out.println(FluidRegistry.lookupFluidForBlock(Block.waterStill).getName());
        
//        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), new ItemStack(Item.shears));
        
        if (!Config.disableDoubler)
        {
            // Recipes for Doubler//
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 2), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 3), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 4), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 5), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 6), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
            for (int i = 0; i < Item.itemsList.length; i++)
            {
                if (Item.itemsList[i] != null)
                {
                    GameRegistry.addShapelessRecipe(new ItemStack(Item.itemsList[i], 7), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(AdvancedCraft.Doubler), new ItemStack(Item.itemsList[i]));
                }
            }
        }
    }
}