package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.suitOfArmorBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeAdder
{
    public static void craftingAll()
    {
    	
        craftingArmor();
        craftingBlocks();
        craftingFood();
        craftingItems();
        craftingSuitOfArmor();
        craftingTools();
        craftingEE();
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.netherStar, true, new Object[] { "sss", Character.valueOf('s'), "stickWood" }));
    }

    public static void craftingBlocks()
    {

        // Recipes for Blocks//
        GameRegistry.addRecipe(new ItemStack(Block.web), "s s", " s ", "s s", 's', new ItemStack(Item.silk));
        GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomRed), 'd', new ItemStack(Block.dirt));
        GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomBrown), 'd', new ItemStack(Block.dirt));
        // GameRegistry.addShapelessRecipe(new ItemStack(Block.planks), new
        // ItemStack(Item.stick), new ItemStack(Item.stick), new
        // ItemStack(Item.stick), new ItemStack(Item.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBlock), "sss", "sss", "sss", 's', new ItemStack(Item.netherStar));
    }

    public static void craftingItems()
    {
        // Recipes for Items//
        GameRegistry.addRecipe(new ItemStack(Item.emerald), "ggg", "gdg", "ggg", 'g', new ItemStack(Item.dyePowder, 1, 2), 'd', new ItemStack(Item.diamond));
        if (!Config.disableDragonEgg)
        {
            GameRegistry.addRecipe(new ItemStack(Block.dragonEgg), " o ", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 'h', new ItemStack(AdvancedCraft.enderHeart));
        }
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.enderHeart), "ses", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 's', new ItemStack(Block.whiteStone));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarNugget), "sss", "sss", "sss", 's', new ItemStack(AdvancedCraft.netherStarShard));
        GameRegistry.addRecipe(new ItemStack(Item.netherStar), "nnn", "nnn", "nnn", 'n', new ItemStack(AdvancedCraft.netherStarNugget));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.glowstone, 4), new ItemStack(Block.glowStone));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.snowball, 4), new ItemStack(Block.snow));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.clay, 4), new ItemStack(Block.blockClay));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarShard, 9), new ItemStack(AdvancedCraft.netherStarNugget));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarNugget, 9), new ItemStack(Item.netherStar));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.netherStar, 9), new ItemStack(AdvancedCraft.netherStarBlock));
    }

    public static void craftingFood()
    {
        // Recipes for Food//

        if (!Config.disableAlternateCookie)
        {
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.sugarCookieDough, 8), "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.cookieDough, 8), "wcw", 'c', new ItemStack(Item.dyePowder, 1, 3), 'w', new ItemStack(Item.wheat));
        }
        else
        {
            GameRegistry.addRecipe(new ItemStack(AdvancedCraft.sugarCookie, 8), "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
        }
    }

    public static void craftingArmor()
    {

        // Recipes for Armor//
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHelmet), "nnn", "n n", "   ", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarChestplate), "n n", "nnn", "nnn", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarLeggings), "nnn", "n n", "n n", 'n', new ItemStack(Item.netherStar));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBoots), "n n", "n n", 'n', new ItemStack(Item.netherStar));
    }

    public static void craftingTools()
    {
        // Recipes for Tools//
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarSword), " n ", " n ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarShovel), " n ", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarPickaxe), "nnn", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarAxe), "nn ", "ns ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHoe), "nn ", " s ", " s ", 'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), new ItemStack(Block.sponge));
        GameRegistry.addRecipe(new ItemStack(AdvancedCraft.Sponge), "yyy", "ysy", "yyy", 'y', new ItemStack(Item.dyePowder, 1, 11), 's', new ItemStack(Block.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), new ItemStack(Block.sponge));
    }

    public static void craftingSuitOfArmor()
    {
        // Recipes for Suit of armor//
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_NetherStar), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_NetherStar.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Diamond), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Diamond.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Iron), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Iron.itemID));
        GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Gold), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Gold.itemID));
    }

    public static void craftingEE()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.rottenFlesh));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 4), new ItemStack(Item.diamond), new ItemStack(Item.rottenFlesh));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.rottenFlesh));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 8), new ItemStack(Item.ingotGold), new ItemStack(Item.rottenFlesh));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.enderPearl), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.rottenFlesh));
        GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 4), new ItemStack(Item.enderPearl), new ItemStack(Item.rottenFlesh));
    }

    public static void craftingBC()
    {
        //Gears//
        GameRegistry.addRecipe(new ItemStack(buildcraft.BuildCraftCore.stoneGearItem), "tst", "s s", "tst", 't', new ItemStack(Block.cobblestone), 's', new ItemStack(Item.stick));
        GameRegistry.addRecipe(new ItemStack(buildcraft.BuildCraftCore.ironGearItem), "isi", "sgs", "isi", 'i', new ItemStack(Item.ingotIron), 's', new ItemStack(Block.cobblestone), 'g', new ItemStack(buildcraft.BuildCraftCore.woodenGearItem));
        GameRegistry.addRecipe(new ItemStack(buildcraft.BuildCraftCore.goldGearItem), "isi", "sgs", "isi", 's', new ItemStack(Item.ingotIron), 'i', new ItemStack(Item.ingotGold), 'g', new ItemStack(buildcraft.BuildCraftCore.stoneGearItem));
        GameRegistry.addRecipe(new ItemStack(buildcraft.BuildCraftCore.diamondGearItem), "did", "igi", "did", 'd', new ItemStack(Item.diamond), 'i', new ItemStack(Item.ingotGold), 'g', new ItemStack(buildcraft.BuildCraftCore.ironGearItem));
        //Blocks//
        GameRegistry.addRecipe(new ItemStack(buildcraft.BuildCraftBuilders.markerBlock), " l ", " r ", " s ", 'l', new ItemStack(Item.dyePowder, 1, 4), 'r', new ItemStack(Item.redstone), 's', new ItemStack(Item.stick));
    }

    public static void smeltingAll()
    {
        // Food Smelting//
        GameRegistry.addSmelting(AdvancedCraft.sugarCookieDough.itemID, new ItemStack(AdvancedCraft.sugarCookie), 1.0f);
        GameRegistry.addSmelting(AdvancedCraft.cookieDough.itemID, new ItemStack(Item.cookie), 1.0f);
    }

}
