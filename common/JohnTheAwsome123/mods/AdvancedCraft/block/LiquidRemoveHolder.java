package JohnTheAwsome123.mods.AdvancedCraft.block;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.fluids.FluidRegistry;
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
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class LiquidRemoveHolder extends Block
{
    private Map<String, Integer> fluidIDList = FluidRegistry.getRegisteredFluidIDs();
    public Fluid[] omitedFluids = {FluidRegistry.lookupFluidForBlock(Block.waterStill),FluidRegistry.lookupFluidForBlock(Block.waterMoving)};
    private int[] openSides = { 0, 0, 0, 0, 0, 0 };

    public LiquidRemoveHolder(int par1)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName("LiquidRemove_Holder");
        this.setHardness(0.1F);
        this.setStepSound(Block.soundSnowFootstep);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int sum(int[] in)
    {
        int total = 0;
        for (int num : in)
        {
            total = num + total;
        }
        return total;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon)
    {
        this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {

        for (Fluid omited : omitedFluids)
        {
            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2 + 1, par3, par4)]) != omited) openSides[0] = 1;
//            else openSides[0] = 0;

            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2 - 1, par3, par4)]) != omited) openSides[1] = 1;
//            else openSides[1] = 0;

            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2, par3 + 1, par4)]) != omited) openSides[2] = 1;
//            else openSides[2] = 0;

            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)]) != omited) openSides[3] = 1;
//            else openSides[3] = 0;

            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2, par3, par4 + 1)]) != omited) openSides[4] = 1;
//            else openSides[4] = 0;

            if (FluidRegistry.lookupFluidForBlock(Block.blocksList[par1World.getBlockId(par2, par3, par4 - 1)]) != omited) openSides[5] = 1;
//            else openSides[5] = 0;
        }
        if (sum(openSides) == 6)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        /*        int i = 0;
        i++;
        if (i >= 60)
        {
            i = 0;
            par1World.setBlockToAir(par2, par3, par4);
        }

        if (par1World.isAirBlock(par2 + 1, par3, par4) && par1World.isAirBlock(par2 - 1, par3, par4) && par1World.isAirBlock(par2, par3 + 1, par4) && par1World.isAirBlock(par2, par3 - 1, par4) && par1World.isAirBlock(par2, par3, par4 + 1) && par1World.isAirBlock(par2, par3, par4 - 1))
        {
            par1World.setBlockToAir(par2, par3, par4);
        }

        if (par1World.isAirBlock(par2 - 1, par3, par4) && par1World.isAirBlock(par2, par3 + 1, par4) && par1World.isAirBlock(par2, par3 - 1, par4) && par1World.isAirBlock(par2, par3, par4 + 1) && par1World.isAirBlock(par2, par3, par4 - 1))
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        if (par1World.isAirBlock(par2 - 1, par3, par4))
        {
            par1World.setBlockToAir(par2, par3, par4);
        }*/
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        // int i = 0;
        // i++;
        // if (i >= 20)
        // {
        // i = 0;
        // par1World.setBlockToAir(par2, par3, par4);
        // }

//        if (par1World.isAirBlock(par2 + 1, par3, par4) && par1World.isAirBlock(par2 - 1, par3, par4) && par1World.isAirBlock(par2, par3 + 1, par4) && par1World.isAirBlock(par2, par3 - 1, par4) && par1World.isAirBlock(par2, par3, par4 + 1) && par1World.isAirBlock(par2, par3, par4 - 1))
//        {
//            par1World.setBlockToAir(par2, par3, par4);
//        }
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
}
