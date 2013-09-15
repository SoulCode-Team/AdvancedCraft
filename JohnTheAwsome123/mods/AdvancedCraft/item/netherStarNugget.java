package JohnTheAwsome123.mods.AdvancedCraft.item;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class netherStarNugget extends Item
{

    public netherStarNugget(int par1)
    {
        super(par1);
        this.setMaxStackSize(64);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setUnlocalizedName("netherStarNugget");
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:netherStar_Nugget");
    }
}
