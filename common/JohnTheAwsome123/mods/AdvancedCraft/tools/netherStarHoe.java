package JohnTheAwsome123.mods.AdvancedCraft.tools;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class netherStarHoe extends ItemHoe
{

    public netherStarHoe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setUnlocalizedName("netherStar_Hoe");
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "tool/"));
    }
}
