package JohnTheAwsome123.mods.AdvancedCraft.item;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class enderHeart extends Item
{

    public enderHeart(int par1)
    {
        super(par1);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("enderHeart");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:Ender_Heart");
    }
}
