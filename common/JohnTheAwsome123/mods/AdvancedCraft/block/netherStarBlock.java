package JohnTheAwsome123.mods.AdvancedCraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class netherStarBlock extends Block
{

    public netherStarBlock(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setUnlocalizedName("netherStar_Block");
        this.setCreativeTab(Reference.ACTAB);
        this.setHardness(5.0F);
        this.setResistance(5000.0F);
        this.setLightValue(1.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
//    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
//        if (par5Entity instanceof EntityPlayer) {
//         ((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.heal.getId(), 20, 1));
//        }
//       }
}
