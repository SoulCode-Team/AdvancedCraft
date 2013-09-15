package JohnTheAwsome123.mods.AdvancedCraft.armor;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class netherStarHelmet extends ItemArmor
{

    public netherStarHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        setUnlocalizedName("netherStarHelmet");
        setCreativeTab(CreativeTabs.tabCombat);
        setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:netherStar_Helmet");
    }
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer){
    return "AdvancedCraft:textures/models/armor/netherStar_layer_1.png";
    }
}