package JohnTheAwsome123.mods.AdvancedCraft.block;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class cobblestoneGenerator extends Block
{

    public cobblestoneGenerator(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setUnlocalizedName("cobblestoneGenerator");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setHardness(5.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public cobblestoneGenerator(int par1)
    {
        this(par1, Material.rock);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.blockIcon = par1registerIcon.registerIcon("AdvancedCraft:cobblestoneGenerator");
    }

}
