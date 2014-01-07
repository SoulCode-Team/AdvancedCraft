package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.CommonProxy;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sponge extends Item
{

    public Sponge(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setUnlocalizedName("Sponge");
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon)
    {
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "tool/"));
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (par3EntityPlayer.isSneaking())
        {
            this.setDamage(par1ItemStack, par1ItemStack.getItemDamage() < 1 ? par1ItemStack.getItemDamage() + 1 : 0);
        }

        if (movingobjectposition != null)
        {
            FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                {
                    return par1ItemStack;
                }

                if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                {
                    return par1ItemStack;
                }

                if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
                {
                    switch (par1ItemStack.getItemDamage())
                    {
                        case 0:
                            par2World.setBlockToAir(i, j, k);
                            break;
                        case 1:
                            par2World.setBlock(i, j, k, AdvancedCraft.LiquidRemove_Holder.blockID);
                            break;
                    }
                }

                if (par2World.getBlockMaterial(i, j, k) == Material.lava && par2World.getBlockMetadata(i, j, k) == 0)
                {
                    switch (par1ItemStack.getItemDamage())
                    {
                        case 0:
                            par2World.setBlockToAir(i, j, k);
                            break;
                        case 1:
                            par2World.setBlock(i, j, k, AdvancedCraft.LiquidRemove_Holder.blockID);
                            break;
                    }
                }
            }

        }
        return par1ItemStack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Soaks up a lot of fluid.");
        switch (stack.getItemDamage())
        {
            case 0:
                list.add("Mode: Air");
                break;
            case 1:
                list.add("Mode: Replace");
                break;
        }
        if (CommonProxy.shouldAddAdditionalInfo())
        {
            list.add("Air mode replaces the fluid with air");
            list.add("Replace mode replaces the fluid with a place holder block");
        }
        else
        {
            list.add(CommonProxy.additionalInfoInstructions());
        }
    }
}
