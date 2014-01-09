package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.CommonProxy;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blockPlacer extends Item {
	private int toblock = 0;
	private int toblockmeta = 0;

	public blockPlacer(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(Reference.ACTAB);
		this.setUnlocalizedName("block_Placer");

	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		float f = 1.0F;
		float f1 = par3EntityPlayer.prevRotationPitch + (par3EntityPlayer.rotationPitch - par3EntityPlayer.prevRotationPitch) * f;
		float f2 = par3EntityPlayer.prevRotationYaw + (par3EntityPlayer.rotationYaw - par3EntityPlayer.prevRotationYaw) * f;
		double d = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double) f;
		double d1 = (par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double) f + 1.6200000000000001D) - (double) par3EntityPlayer.yOffset;
		double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double) f;
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3d1 = vec3d.addVector((double) f7 * d3, (double) f8 * d3,
				(double) f9 * d3);
		MovingObjectPosition movingobjectposition = par2World
				.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
		if (movingobjectposition == null) {
			return par1ItemStack;
		}
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
			int i = movingobjectposition.blockX;
			int j = movingobjectposition.blockY;
			int k = movingobjectposition.blockZ;
			if (par3EntityPlayer.isSneaking()) {
				toblock = par2World.getBlockId(i, j, k);
				toblockmeta = par2World.getBlockMetadata(i, j, k);
			} else {
				// if (toblock > 0 && toblockmeta > 0)
				// {
				par2World.setBlock(i, j, k, toblock);
				par2World.setBlock(i, j, k, toblock, toblockmeta, 2);
				// }
			}
		}
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1registerIcon) {
		this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "tool/"));
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List list, boolean par4) {
		list.add("Creative Only");
		if (toblock > 0) {
			list.add(String.format("Contains: %d:%d", toblock, toblockmeta));
		}
		if (CommonProxy.shouldAddAdditionalInfo()) {
			list.add("Shift right click to set block");
			list.add("right click to place block");
		} else {
			list.add(CommonProxy.additionalInfoInstructions());
		}
	}
}