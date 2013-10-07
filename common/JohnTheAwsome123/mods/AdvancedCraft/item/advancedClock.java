package JohnTheAwsome123.mods.AdvancedCraft.item;

import java.util.List;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class advancedClock extends Item
{
    public advancedClock(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setUnlocalizedName("advancedClock");
        this.setTextureName("clock");
    }
    
//    @SideOnly(Side.CLIENT)
//    public void registerIcons(IconRegister par1registerIcon){
//        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:advancedClock");
//    }
}
