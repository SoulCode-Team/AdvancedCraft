package JohnTheAwsome123.mods.AdvancedCraft;

import JohnTheAwsome123.mods.AdvancedCraft.util.ACOreDict;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler
{
	public static AdvancedCraft AC;

	public static String[] dyeColorNames = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White"};

	public static void registerBlocks()
	{
		OreDictionary.registerOre("blockNetherStar", new ItemStack(AC.netherStarBlock));
		OreDictionary.registerOre("oreNetherStar", new ItemStack(AC.netherStarOre));

		//Vanilla//
//		OreDictionary.registerOre("blockSponge", new ItemStack(Block.sponge));
		if (!ACOreDict.addOreDictionary("sponge", Block.sponge)) dyeColorNames[12]= "CRASH YOU FOUL DEAMON!!!!";
	}
	public static void registerItems(){
		OreDictionary.registerOre("nuggetNetherStar", new ItemStack(AC.netherStarNugget));

		//Vanilla//
		OreDictionary.registerOre("itemNetherStar", new ItemStack(Item.netherStar));
		OreDictionary.registerOre("gemDiamond", new ItemStack(Item.diamond));
	}

	public static void registerDyes()
	{
		//Done in OreDictionary//
		for (int i = 0; i < ItemDye.dyeColorNames.length; i++) {
			OreDictionary.registerOre("dye" + dyeColorNames[i], new ItemStack(Item.dyePowder, 1, i));
		}
	}

	public static void registerAll(){
		registerBlocks();
		registerItems();
	}
}
