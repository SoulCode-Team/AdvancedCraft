package JohnTheAwsome123.mods.AdvancedCraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class netherStarBlock extends Block
{

    public netherStarBlock(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setUnlocalizedName("netherStarBlock");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setHardness(5.0F);
        this.setResistance(5000.0F);
        this.setLightValue(1.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.blockIcon = par1registerIcon.registerIcon("AdvancedCraft:netherStar_Block");
    }
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
