package JohnTheAwsome123.mods.AdvancedCraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;

public class nerdPole extends Block
{
    public nerdPole(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setUnlocalizedName("nerdPole");
        this.setCreativeTab(Reference.ACTAB);
        this.setHardness(2.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public nerdPole(int par1)
    {
        this(par1, Material.rock);
    }

    public void registerIcons(IconRegister par1registerIcon)
    {
        this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }

    public boolean isThisBlock(World par1World, int par2, int par3, int par4)
    {
        return (par1World.getBlockId(par2, par3 - 1, par4) == this.blockID);
    }

    public boolean isClearAbove(World par1World, int par2, int par3, int par4)
    {
        return par1World.isAirBlock(par2, par3 + 1, par4);
    }

    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return !(par1World.isAirBlock(par2, par3 - 1, par4));
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par5EntityPlayer.inventory.currentItem == this.blockID)
        {
            boolean cont;
            int i = 0;

            cont = true;
            while (cont == true)
            {

                // if (this.isThisBlock(par1World, par2, par3 + i, par4))
                // {
                // // i -= 1;
                // if (!this.isClearAbove(par1World, par2, par3 + i, par4))
                // continue;
                // }

                if (this.isThisBlock(par1World, par2, par3 + i, par4))
                {
                    // i -= 1;
                    // if (!this.isClearAbove(par1World, par2, par3 + i, par4))
                    // continue;
                }
                else if (this.isClearAbove(par1World, par2, par3 + i, par4))
                {
                    par1World.setBlock(par2, par3 + i, par4, this.blockID);
                    if (!par5EntityPlayer.capabilities.isCreativeMode) par5EntityPlayer.inventory.consumeInventoryItem(this.blockID);
                    cont = false;

                    return true;
                }
                else cont = false;
                ++i;
            }
        }
        return false;

    }

    /*
     * public void onBlockClicked(World par1World, int par2, int par3, int par4,
     * EntityPlayer par5EntityPlayer) { if (this.isClearAbove(par1World, par2,
     * par3, par4)){ if (par5EntityPlayer.inventory.currentItem == this.blockID)
     * { par1World.setBlock(par2, par3, par4, this.blockID);
     * par5EntityPlayer.inventory.consumeInventoryItem(this.blockID); } } }
     */
    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return !par1World.isAirBlock(par2, par3 - 1, par4);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
}
