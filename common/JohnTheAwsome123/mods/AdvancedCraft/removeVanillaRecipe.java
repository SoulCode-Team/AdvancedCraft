package JohnTheAwsome123.mods.AdvancedCraft;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class removeVanillaRecipe
{
    public static void remove(Item removeItem){
        Collection<Item> removeSet = new HashSet();
        Collections.addAll(removeSet,
                removeItem
                );
        Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();

        while (iterator.hasNext())
        {
                IRecipe recipe = iterator.next();
                if (recipe == null)
                    continue;
                ItemStack output = recipe.getRecipeOutput();
                if (output != null && output.getItem() != null && removeSet.contains(output.getItem()))
                    iterator.remove();
        }
    }
}
