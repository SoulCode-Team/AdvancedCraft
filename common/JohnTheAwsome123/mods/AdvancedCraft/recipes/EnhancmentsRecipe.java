package JohnTheAwsome123.mods.AdvancedCraft.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class EnhancmentsRecipe implements IRecipe
{
    public static Map<ItemStack, String> enhancments = new HashMap<ItemStack, String>();

    @Override
    public boolean matches(InventoryCrafting inventorycrafting, World world)
    {
        ItemStack[] ingredients = null;
        enhancments.put(new ItemStack(Item.flintAndSteel), "smelt");
        for (int i = 0; i < inventorycrafting.getSizeInventory(); i++)
        {
            if (inventorycrafting.getStackInSlot(i) == null) continue;

            ItemStack checkItem = inventorycrafting.getStackInSlot(i);
            if (checkItem.getItem() == null) continue;
            ingredients[ingredients.length + 1] = checkItem;

        }
        if (enhancments.containsKey(ingredients))return true;
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
    {
        return null;
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
