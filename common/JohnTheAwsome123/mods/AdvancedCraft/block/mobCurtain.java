package JohnTheAwsome123.mods.AdvancedCraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class mobCurtain extends Block
{

    public mobCurtain(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setTickRandomly(true);
        this.setUnlocalizedName("mobCurtain");
        this.setCreativeTab(Reference.ACTAB);
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
//         ((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 1));
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
