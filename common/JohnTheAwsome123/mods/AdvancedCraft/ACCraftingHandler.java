package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.ICraftingHandler;

public class ACCraftingHandler implements ICraftingHandler
{

    @Override
    public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
    {
//        for(int i=0; i < craftMatrix.getSizeInventory(); i++)
//        {           
//            if(craftMatrix.getStackInSlot(i) != null)
//            {
//                ItemStack j = craftMatrix.getStackInSlot(i);
//                if(j.getItem() != null && j.getItem() == Item.itemsList[AdvancedCraft.Doubler.itemID])
//                {
//                    ItemStack k = new ItemStack(Item.itemsList[AdvancedCraft.Doubler.itemID], 2, (j.getItemDamage() + 1));
//                    craftMatrix.setInventorySlotContents(i, k);
//                }
//            }  
//        }
    }

    @Override
    public void onSmelting(EntityPlayer player, ItemStack item)
    {
        // TODO Auto-generated method stub

    }

}
