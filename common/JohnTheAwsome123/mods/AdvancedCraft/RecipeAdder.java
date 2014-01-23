package JohnTheAwsome123.mods.AdvancedCraft;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import JohnTheAwsome123.mods.AdvancedCraft.tools.suitOfArmorBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeAdder
{
	public static void craftingAll()
	{
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarBlock), "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar");
		
//		craftingArmor();
//		craftingBlocks();
//		craftingFood();
//		craftingItems();
//		craftingSuitOfArmor();
//		craftingTools();
//		craftingEE();
		//		        RecipeAdder.addRecipe(new ShapedOreRecipe(Item.netherStar, true, new Object[] { "sss", Character.valueOf('s'), "stickWood" }));
	}

	public static void addRecipe(ItemStack result, Object... recipe) {
		GameRegistry.addRecipe(new ShapedOreRecipe(result, recipe));
	}

//	public static void addShapelessRecipe(ItemStack result, Object... recipe) {
//		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(result, recipe));
//	}
	
	public static void addShapelessRecipe(ItemStack result, Object... recipe) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(result, recipe));
	}
	

	public static void addSmelting(String input, String output, float xp)
	{
		int[] TMP = {0};
		ArrayList<ItemStack> inputList = OreDictionary.getOres((String)input);
		for (int i = 0; i < TMP.length; i++) {

		}
		//		FurnaceRecipes.smelting().addSmelting(input, output, xp);
	}

	/**
	 * registers crafting recipes for armor given material and output armor.
	 * (ore dictionary enabled)
	 * 
	 * @param material
	 * @param output [boots, leggings, chestplate, helmet]
	 */
	public static void addArmorRecipes(Object material, ItemStack... output)
	{
		if (output[0] != null) RecipeAdder.addRecipe(output[0], true, "X X", "X X", 'X', material);
		if (output[1] != null) RecipeAdder.addRecipe(output[1], true, "XXX", "X X", "X X", 'X', material);
		if (output[2] != null) RecipeAdder.addRecipe(output[2], true, "X X", "XXX", "XXX", 'X', material);
		if (output[3] != null) RecipeAdder.addRecipe(output[3], true, "XXX", "X X", 'X', material);
	}


	public static void craftingBlocks()
	{

		// Recipes for Blocks//
		RecipeAdder.addRecipe(new ItemStack(Block.web), true, "s s", " s ", "s s", 's', new ItemStack(Item.silk));
		RecipeAdder.addRecipe(new ItemStack(Block.mycelium), true, "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomRed), 'd', new ItemStack(Block.dirt));
		RecipeAdder.addRecipe(new ItemStack(Block.mycelium), true, "ddd", "dmd", "ddd", 'm', new ItemStack(Block.mushroomBrown), 'd', new ItemStack(Block.dirt));
		// RecipeAdder.addShapelessRecipe(new ItemStack(Block.planks), new
		// ItemStack(Item.stick), "stickWood", new
		// ItemStack(Item.stick), "stickWood");
		RecipeAdder.addShapelessRecipe(new ItemStack(Block.wood), "plankWood", "plankWood", "plankWood", "plankWood");
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarBlock), "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar", "itemNetherStar");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.nerdPole, 16), true, "dsd", "sds", "dsd", 's', "stickWood", 'd', new ItemStack(Block.dirt));
		
	}

	public static void craftingItems()
	{
		// Recipes for Items//
		RecipeAdder.addRecipe(new ItemStack(Item.emerald), true, "ggg", "gdg", "ggg", 'g', "dyeGreen", 'd', "gemDiamond");
		if (!Config.disableDragonEgg)
		{
			RecipeAdder.addRecipe(new ItemStack(Block.dragonEgg), true, " o ", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 'h', new ItemStack(AdvancedCraft.enderHeart));
		}
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.enderHeart), true, "ses", "oho", "ooo", 'o', new ItemStack(Block.obsidian), 's', new ItemStack(Block.whiteStone));
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarNugget), true, "sss", "sss", "sss", 's', new ItemStack(AdvancedCraft.netherStarShard));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.netherStar), "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar", "nuggetNetherStar");
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.glowstone, 4), new ItemStack(Block.glowStone));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.snowball, 4), new ItemStack(Block.snow));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.clay, 4), new ItemStack(Block.blockClay));
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarShard, 9), "nuggetNetherStar");
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarNugget, 9), "itemNetherStar");
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.netherStar, 9), "blockNetherStar");
	}

	public static void craftingFood()
	{
		// Recipes for Food//

		if (!Config.disableAlternateCookie)
		{
			RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.sugarCookieDough, 8), true, "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
			RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.cookieDough, 8), true, "wcw", 'c', new ItemStack(Item.dyePowder, 1, 3), 'w', new ItemStack(Item.wheat));
		}
		else
		{
			RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.sugarCookie, 8), true, "wsw", 'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
		}
	}

	public static void craftingArmor()
	{

		// Recipes for Armor//
		RecipeAdder.addArmorRecipes("itemNetherStar", new ItemStack(AdvancedCraft.netherStarBoots), new ItemStack(AdvancedCraft.netherStarLeggings), new ItemStack(AdvancedCraft.netherStarChestplate), new ItemStack(AdvancedCraft.netherStarHelmet));
		//		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarHelmet), true, "nnn", "n n", "   ", 'n', "itemNetherStar");
		//		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarChestplate), true, "n n", "nnn", "nnn", 'n', "itemNetherStar");
		//		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarLeggings), true, "nnn", "n n", "n n", 'n', "itemNetherStar");
		//		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarBoots), true, "n n", "n n", 'n', "itemNetherStar");
	}

	public static void craftingTools()
	{
		// Recipes for Tools//
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarSword), true, " n ", " n ", " s ", 'n', "itemNetherStar", 's', "stickWood");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarShovel), true, " n ", " s ", " s ", 'n', "itemNetherStar", 's', "stickWood");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarPickaxe), true, "nnn", " s ", " s ", 'n', "itemNetherStar", 's', "stickWood");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarAxe), true, "nn ", "ns ", " s ", 'n', "itemNetherStar", 's', "stickWood");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.netherStarHoe), true, "nn ", " s ", " s ", 'n', "itemNetherStar", 's', "stickWood");
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), new ItemStack(Block.sponge));
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.Sponge), true, "yyy", "ysy", "yyy", 'y', "dyeYellow", 's', "cobblestone");
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.Sponge), "blockSponge");
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.weathermansCompass), true, " n ", "ncn", " n ", 'n', new ItemStack(AdvancedCraft.netherStarNugget), 'c', new ItemStack(Item.compass));
		RecipeAdder.addRecipe(new ItemStack(AdvancedCraft.advancedClock), true, " n ", "ncn", " n ", 'n', new ItemStack(AdvancedCraft.netherStarNugget), 'c', new ItemStack(Item.pocketSundial));
	}

	public static void craftingSuitOfArmor()
	{
		// Recipes for Suit of armor//
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_NetherStar), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_NetherStar.itemID));
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Diamond), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Diamond.itemID));
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Iron), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Iron.itemID));
		RecipeAdder.addShapelessRecipe(new ItemStack(AdvancedCraft.suitOfArmor_Gold), suitOfArmorBase.getData(AdvancedCraft.suitOfArmor_Gold.itemID));
	}

	public static void craftingEE()
	{
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.diamond), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.ingotGold), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.ingotGold, 4), new ItemStack(Item.diamond), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.ingotGold), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.ingotIron, 8), new ItemStack(Item.ingotGold), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.enderPearl), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.ingotIron, 4), new ItemStack(Item.enderPearl), new ItemStack(Item.rottenFlesh));
		RecipeAdder.addShapelessRecipe(new ItemStack(Item.blazeRod), new ItemStack(Item.blazePowder), new ItemStack(Item.blazePowder), new ItemStack(Item.rottenFlesh));
	}

	public static void craftingBC()
	{
		//Gears//
		//        RecipeAdder.addRecipe(new ItemStack(buildcraft.BuildCraftCore.stoneGearItem), true, "tst", "s s", "tst", 't', new ItemStack(Block.cobblestone), 's', "stickWood");
		//        RecipeAdder.addRecipe(new ItemStack(buildcraft.BuildCraftCore.ironGearItem), true, "isi", "sgs", "isi", 'i', new ItemStack(Item.ingotIron), 's', new ItemStack(Block.cobblestone), 'g', new ItemStack(buildcraft.BuildCraftCore.woodenGearItem));
		//        RecipeAdder.addRecipe(new ItemStack(buildcraft.BuildCraftCore.goldGearItem), true, "isi", "sgs", "isi", 's', new ItemStack(Item.ingotIron), 'i', new ItemStack(Item.ingotGold), 'g', new ItemStack(buildcraft.BuildCraftCore.stoneGearItem));
		//        RecipeAdder.addRecipe(new ItemStack(buildcraft.BuildCraftCore.diamondGearItem), true, "did", "igi", "did", 'd', new ItemStack(Item.diamond), 'i', new ItemStack(Item.ingotGold), 'g', new ItemStack(buildcraft.BuildCraftCore.ironGearItem));
		//        //Blocks//
		//        RecipeAdder.addRecipe(new ItemStack(buildcraft.BuildCraftBuilders.markerBlock), true, " l ", " r ", " s ", 'l', new ItemStack(Item.dyePowder, 1, 4), 'r', new ItemStack(Item.redstone), 's', "stickWood");
	}

	public static void smeltingAll()
	{
		// Food Smelting//
		GameRegistry.addSmelting(AdvancedCraft.sugarCookieDough.itemID, new ItemStack(AdvancedCraft.sugarCookie), 1.0f);
		GameRegistry.addSmelting(AdvancedCraft.cookieDough.itemID, new ItemStack(Item.cookie), 1.0f);
	}

}
