package JohnTheAwsome123.mods.AdvancedCraft.util;

import java.util.ArrayList;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**addOreDictionary
 * @mod AdvancedCraft
 * 
 * @author JohnTheAwsome123
 */
public class ACOreDict {
	public static boolean addOreDictionary(String name, Item itm){ return addOreDictionary(name, new ItemStack(itm));}
	public static boolean addOreDictionary(String name, Block blck){ return addOreDictionary(name, new ItemStack(blck));}

	/**
	 * checks for existing entries and adds parameters to it if no match is found
	 * @param name
	 * @param stack
	 * @return true if match not found and entry added
	 */
	public static boolean addOreDictionary(String name, ItemStack stack){
		if (!checkName(name))
		{
			OreDictionary.registerOre(name, stack);
			ACLogger.Log(Level.FINEST, "Regisering Ore " + stack.getDisplayName() + " as " + name);
			return true;
		}
		return false;
	}
	
	public static boolean checkName(String name)
	{
		return OreDictionary.getOreName(OreDictionary.getOreID(name)) != "Unknown";
	}
	
}
