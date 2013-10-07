package JohnTheAwsome123.mods.AdvancedCraft.tools;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class netherStarSword extends ItemSword
{

    public netherStarSword(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        setUnlocalizedName("netherStarSword");
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:tool/netherStar_Sword");
    }
}
