package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler
{
    public static AdvancedCraft AC;

    public static void registerBlocks()
    {
        OreDictionary.registerOre("blockNetherStar", new ItemStack(AC.netherStarBlock));
        OreDictionary.registerOre("oreNetherStar", new ItemStack(AC.netherStarOre));
    }
    public static void registerItems(){
        OreDictionary.registerOre("nuggetNetherStar", new ItemStack(AC.netherStarNugget));
    }
    public static void registerAll(){
        registerBlocks();
        registerItems();
    }
}
