package JohnTheAwsome123.mods.AdvancedCraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class mobCurtain extends Block
{

    public mobCurtain(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setTickRandomly(true);
        this.setUnlocalizedName("mobCurtain");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundClothFootstep);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    protected mobCurtain(int par1)
    {
        this(par1, Material.grass);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity instanceof EntityLiving) {
//            if (par5Entity instanceof EntityPlayer){
         ((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 1));
//        }
        }
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
}
