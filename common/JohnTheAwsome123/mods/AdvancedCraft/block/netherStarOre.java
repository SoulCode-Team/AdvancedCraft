package JohnTheAwsome123.mods.AdvancedCraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class netherStarOre extends Block 
{
    Random rand = new Random();
        public netherStarOre(int id, Material par2material) 
        {
                super(id, par2material);
                this.setUnlocalizedName("netherStar_Ore");
                this.setCreativeTab(CreativeTabs.tabBlock);
                this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
                this.setHardness(4.0F);
                this.setLightValue(0.2F);
                this.setStepSound(Block.soundStoneFootstep);
        }
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1registerIcon){
            this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
        }
        public int idDropped(int par1, Random par2Random, int par3){
            return AdvancedCraft.netherStarShard.itemID;
        }
        
        public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
        {
            super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
            int j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
        
        
        
        
        
        public int quantityDropped(Random par1Random)
        {
            return (int) (par1Random.nextInt(5) * 1.3);
            //return this.blockID == Block.oreLapis.blockID ? 4 + par1Random.nextInt(5) : 1;
        }

        public int quantityDroppedWithBonus(int par1, Random par2Random)
        {
            if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
            {
                int j = par2Random.nextInt(par1 + 2) - 1;

                if (j < 0)
                {
                    j = 0;
                }

                return this.quantityDropped(par2Random) * (j + 1);
            }
            else
            {
                return this.quantityDropped(par2Random);
            }
        }
}