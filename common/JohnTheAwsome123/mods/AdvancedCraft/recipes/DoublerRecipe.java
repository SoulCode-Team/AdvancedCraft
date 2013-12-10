package JohnTheAwsome123.mods.AdvancedCraft.recipes;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.Config;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;

/**
 * AdvancedCraft
 * 
 * DoublerRecipe
 * 
 * @author JohnTheAwsome123
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */
public class DoublerRecipe implements IRecipe
{

    @Override
    public boolean matches(InventoryCrafting inventorycrafting, World world)
    {
        ItemStack doubledItem = null;
        int countDoubler = 0;
        int countItem = 0;

        
        for (int i = 0; i < inventorycrafting.getSizeInventory(); i++)
        {
            if (inventorycrafting.getStackInSlot(i) == null) continue;

            ItemStack checkItem = inventorycrafting.getStackInSlot(i);
            if (checkItem.getItem() == null) continue;

            if (checkItem.getItem() == AdvancedCraft.Doubler)
            {
                countDoubler += 1;

            }
            
            if (checkItem.getItem() != AdvancedCraft.Doubler && checkItem.getItem() != null)
            {
                doubledItem = checkItem;
                countItem += 1;
            }
            

        }

        if (doubledItem != null && countDoubler > 0 && countItem == 1)
        {
            return true;
        }
        return false;

    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
    {
        ItemStack doubledItem = null;
        int countDoubler = 0;

        for (int i = 0; i < inventorycrafting.getSizeInventory(); i++)
        {
            if (inventorycrafting.getStackInSlot(i) == null) continue;

            ItemStack checkItem = inventorycrafting.getStackInSlot(i);
            if (checkItem.getItem() == null) continue;

            if (checkItem.getItem() != AdvancedCraft.Doubler)
            {
                doubledItem = checkItem;
            }

            if (checkItem.getItem() == AdvancedCraft.Doubler)
            {
                countDoubler += 1;

            }

        }
        
        ItemStack returnItem = doubledItem.copy();
        returnItem.stackSize = countDoubler +1;
        if (!AdvancedCraft.config.disableAdvancedDoubler){
          return returnItem;  
        }
        else{
            return new ItemStack(returnItem.getItem(), returnItem.stackSize, returnItem.getItemDamage());
        }
        
    }

    @Override
    public int getRecipeSize()
    {
        return 0;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return null;
    }

}
