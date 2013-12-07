package JohnTheAwsome123.mods.AdvancedCraft.item;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.constants.ACTextures;
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
        this.setUnlocalizedName("ender_Heart");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
}
