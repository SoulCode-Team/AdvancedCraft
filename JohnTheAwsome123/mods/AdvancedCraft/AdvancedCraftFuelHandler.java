package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class AdvancedCraftFuelHandler implements IFuelHandler
{

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        int fuelID = fuel.itemID;
        if(fuelID == AdvancedCraft.netherStarShard.itemID){
            return 1600;
        }else{
            return 0;
        }
    }

}
