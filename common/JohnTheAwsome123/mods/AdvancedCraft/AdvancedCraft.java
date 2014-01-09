package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import JohnTheAwsome123.mods.AdvancedCraft.armor.netherStarBoots;
import JohnTheAwsome123.mods.AdvancedCraft.armor.netherStarChestplate;
import JohnTheAwsome123.mods.AdvancedCraft.armor.netherStarHelmet;
import JohnTheAwsome123.mods.AdvancedCraft.armor.netherStarLeggings;
import JohnTheAwsome123.mods.AdvancedCraft.block.LiquidRemoveHolder;
import JohnTheAwsome123.mods.AdvancedCraft.block.cobblestoneGenerator;
import JohnTheAwsome123.mods.AdvancedCraft.block.nerdPole;
import JohnTheAwsome123.mods.AdvancedCraft.block.netherStarBlock;
import JohnTheAwsome123.mods.AdvancedCraft.block.netherStarOre;
import JohnTheAwsome123.mods.AdvancedCraft.food.cookieDough;
import JohnTheAwsome123.mods.AdvancedCraft.food.sugarCookie;
import JohnTheAwsome123.mods.AdvancedCraft.food.sugarCookieDough;
import JohnTheAwsome123.mods.AdvancedCraft.item.Doubler;
import JohnTheAwsome123.mods.AdvancedCraft.item.enderHeart;
import JohnTheAwsome123.mods.AdvancedCraft.item.netherStarNugget;
import JohnTheAwsome123.mods.AdvancedCraft.item.netherStarShard;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ModCompatability;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import JohnTheAwsome123.mods.AdvancedCraft.recipes.DoublerRecipe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.Sponge;
import JohnTheAwsome123.mods.AdvancedCraft.tools.advancedClock;
import JohnTheAwsome123.mods.AdvancedCraft.tools.blockPlacer;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarAxe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarBow;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarHoe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarOmniTool;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarPickaxe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarQuiver;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarShovel;
import JohnTheAwsome123.mods.AdvancedCraft.tools.netherStarSword;
import JohnTheAwsome123.mods.AdvancedCraft.tools.suitOfArmorBase;
import JohnTheAwsome123.mods.AdvancedCraft.tools.weathermansCompass;
import JohnTheAwsome123.mods.AdvancedCraft.util.removeVanillaRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, useMetadata = false, modid = Reference.MOD_ID, acceptedMinecraftVersions = "[1.6,1.7)", dependencies = "required-after:Forge@[9.10.0.800,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AdvancedCraft
{
	// The instance of your mod that Forge uses.
    @Instance(Reference.MOD_ID)
    public static AdvancedCraft instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_COMMON)
    public static CommonProxy proxy;
    
    public static CreativeTabs tabAdvancedCraft = new CreativeTabs("tabAdvancedCraft")
    {
        public ItemStack getIconItemStack()
        {
            return new ItemStack(Block.workbench);
        }
    };

    // Define Config//
    public static Config config;

    // Define Items//
    public static Item enderHeart;
    public static Item netherStarNugget;
    public static Item netherStarShard;
    public static Item universalItem;
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
    public static Item blockPlacer;
    public static Item entityPlacer;

    // Define Suits of armor//
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

    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("Loading " + Reference.MOD_NAME);
        // Stub Method
        proxy.registerRenderers();


        // Set up Config File//
        config = new Config(new Configuration(event.getSuggestedConfigurationFile()));

        // Remove Vanilla crafting recipes//
        if (!Config.disableAlternateCookie)
        {
            removeVanillaRecipe.remove(Item.cookie);
        }
        

        // Settings for NS Armor
        // if (!DisableNetherStarHelmet){
        netherStarHelmet = new netherStarHelmet(Config.netherStarHelmetID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 0);// }
        netherStarChestplate = new netherStarChestplate(Config.netherStarChestplateID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 1);
        netherStarLeggings = new netherStarLeggings(Config.netherStarLeggingsID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 2);
        netherStarBoots = new netherStarBoots(Config.netherStarBootsID, netherStarArmor, RenderingRegistry.addNewArmourRendererPrefix("netherStar"), 3);

        // Set up Items//
        enderHeart = new enderHeart(Config.enderHeartID);
//        universalItem = new UniversalCraftingItem(5000, 0);
        netherStarNugget = new netherStarNugget(Config.netherStarNuggetID);
        netherStarShard = new netherStarShard(Config.netherStarShardID);
        if (!Config.disableDoubler)
        {
            Doubler = new Doubler(Config.DoublerID);
        }

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
        // talismanOfRecollection = new
        // talismanOfRecollection(config.talismanOfRecollectionID); TODO work on
        // taliisman of recollection
        Sponge = new Sponge(Config.SpongeID);
        blockPlacer = new blockPlacer(Config.blockPlacerID);
//        entityPlacer = new entityPlacer(21000);

        // Set Up Suit Of Armor//
        suitOfArmor_NetherStar = new suitOfArmorBase(Config.suitOfArmor_NetherStarID, new ItemStack[] { new ItemStack(AdvancedCraft.netherStarBoots), new ItemStack(AdvancedCraft.netherStarLeggings), new ItemStack(AdvancedCraft.netherStarChestplate), new ItemStack(AdvancedCraft.netherStarHelmet), new ItemStack(AdvancedCraft.netherStarSword) }).setUnlocalizedName("suitOfArmor_NetherStar");
        suitOfArmor_Diamond = new suitOfArmorBase(Config.suitOfArmor_DiamondID, new ItemStack[] { new ItemStack(Item.bootsDiamond), new ItemStack(Item.legsDiamond), new ItemStack(Item.plateDiamond), new ItemStack(Item.helmetDiamond), new ItemStack(Item.swordDiamond) }).setUnlocalizedName("suitOfArmor_Diamond");
        suitOfArmor_Iron = new suitOfArmorBase(Config.suitOfArmor_IronID, new ItemStack[] { new ItemStack(Item.bootsIron), new ItemStack(Item.legsIron), new ItemStack(Item.plateIron), new ItemStack(Item.helmetIron), new ItemStack(Item.swordIron) }).setUnlocalizedName("suitOfArmor_Iron");
        suitOfArmor_Gold = new suitOfArmorBase(Config.suitOfArmor_GoldID, new ItemStack[] { new ItemStack(Item.bootsGold), new ItemStack(Item.legsGold), new ItemStack(Item.plateGold), new ItemStack(Item.helmetGold), new ItemStack(Item.swordGold) }).setUnlocalizedName("suitOfArmor_Gold");

        // Set up Blocks//
        netherStarBlock = new netherStarBlock(Config.netherStarBlockID, Material.iron);
//        mobCurtain = new mobCurtain(Config.mobCurtainID, Material.grass);
        netherStarOre = new netherStarOre(Config.netherStarOreID, Material.rock);
        cobblestoneGenerator = new cobblestoneGenerator(Config.cobblestoneGeneratorID);
        nerdPole = new nerdPole(Config.nerdPoleID);
        LiquidRemove_Holder = new LiquidRemoveHolder(Config.LiquidRemove_HolderID);
        
        LanguageRegisteryHandler.registerAll();
        GameRegisteryHandler.registerAll();
        OreDictionaryHandler.registerAll();
        
        
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

        
        RecipeAdder.craftingAll();
        RecipeAdder.smeltingAll();
        
        
        // Crafting//
        // GameRegistry.addRecipe(new ItemStack(Block.commandBlock), "srs",
        // "rnr", "srs",
        // 'r', new ItemStack(Item.redstone), 'n', nStarStack, 's', new
        // ItemStack(Block.stone));
        // GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new
        // ItemStack(Block.planks, 4));
        
    }

    @EventHandler
    public void Init(FMLPostInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);
        GameRegistry.registerCraftingHandler(new ACCraftingHandler());
        if (ModCompatability.isBuildCraftLoaded())
        {
        	System.out.println("Loading BuildCraft Advanced Gear Recipes.");
//            RecipeAdder.craftingBC();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // System.out.println(FluidRegistry.getFluidID(FluidRegistry.lookupFluidForBlock(Block.waterStill).getName()));
        // System.out.println(FluidRegistry.lookupFluidForBlock(Block.waterStill).getName());

        // Recipes for Doubler//
        if (!config.disableDoubler)
        {
                GameRegistry.addRecipe(new DoublerRecipe());
        }
    }
}