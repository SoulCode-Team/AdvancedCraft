package JohnTheAwsome123.mods.AdvancedCraft.block;

import java.util.Random;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class nerdPole extends Block
{
    public nerdPole(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setUnlocalizedName("nerdPole");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setHardness(2.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public nerdPole(int par1)
    {
        this(par1, Material.rock);
    }
    public boolean isClearAbove(World par1World, int par2, int par3, int par4)
    {
        return par1World.isAirBlock(par2, par3 + 1, par4);
    }
    
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return !(par1World.isAirBlock(par2, par3 - 1, par4));
    }
    
/*    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (this.canPlaceBlockAt(par1World, par2, par3, par4)){
            par1World.setBlock(par2, par3, par4, this.blockID);
            par5EntityPlayer.inventory.consumeInventoryItem(this.blockID);
            return true;
        }
        else{
            return false;
        }
    }*/
    
/*    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        if (this.isClearAbove(par1World, par2, par3, par4)){
            if (par5EntityPlayer.inventory.currentItem == this.blockID)
            {
                par1World.setBlock(par2, par3, par4, this.blockID);
                par5EntityPlayer.inventory.consumeInventoryItem(this.blockID);
            }
        }
    }*/
    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return !par1World.isAirBlock(par2, par3 -1 , par4);
    }
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.canBlockStay( par1World,  par2,  par3,  par4)){
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!this.canBlockStay( par1World,  par2,  par3,  par4)){
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
}
