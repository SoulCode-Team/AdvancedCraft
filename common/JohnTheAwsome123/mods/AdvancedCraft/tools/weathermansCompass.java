package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class weathermansCompass extends Item
{

	private Icon itemIcon0;
	private Icon itemIcon1;
	private Icon itemIcon2;
	private Icon itemIcon3;


	public weathermansCompass(int par1)
	{
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(Reference.ACTAB);
		this.setUnlocalizedName("weathermansCompass");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	/*    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }*/

	//    @Override
	//    public String getUnlocalizedName(ItemStack par1ItemStack)
	//    {
	//        switch (par1ItemStack.getItemDamage()){
	//            case 0: return "weathermans_Compass_Sun";
	//            case 1: return "weathermans_Compass_Rain";
	//            case 2: return "weathermans_Compass_Thunder";
	//            case 3: return "weathermans_Compass_Lighting";
	//            default: return "weathermans_Compass";
	//        }
	//    }

	//    @Override
	//    public EnumAction getItemUseAction(ItemStack par1ItemStack)
	//    {
	//        return EnumAction.bow;
	//    }
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par3EntityPlayer.isSneaking()){
			this.setDamage(par1ItemStack, par1ItemStack.getItemDamage() < 3 ? par1ItemStack.getItemDamage() + 1 : 0);
		}
		else{
			int t = (300 + (new Random()).nextInt(600)) * 20;

			WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
			WorldInfo worldinfo = worldserver.getWorldInfo();
			worldinfo.setRainTime(t);
			worldinfo.setThunderTime(t);

			switch (par1ItemStack.getItemDamage()){
			case 0:worldinfo.setRaining(false);
			worldinfo.setThundering(false);
			break;

			case 1:worldinfo.setRaining(true);
			worldinfo.setThundering(false);
			break;

			case 2:worldinfo.setRaining(true);
			worldinfo.setThundering(true);
			break;

			case 3:float f = 1.0F;
			float f1 = par3EntityPlayer.prevRotationPitch + (par3EntityPlayer.rotationPitch - par3EntityPlayer.prevRotationPitch) * f;
			float f2 = par3EntityPlayer.prevRotationYaw + (par3EntityPlayer.rotationYaw - par3EntityPlayer.prevRotationYaw) * f;
			double d = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)f;
			double d1 = (par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)par3EntityPlayer.yOffset;
			double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)f;
			Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
			float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
			float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
			float f5 = -MathHelper.cos(-f1 * 0.01745329F);
			float f6 = MathHelper.sin(-f1 * 0.01745329F);
			float f7 = f4 * f5;
			float f8 = f6;
			float f9 = f3 * f5;
			double d3 = 5000D;
			Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
			MovingObjectPosition movingobjectposition = par2World.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
			if (movingobjectposition == null)
			{
				return par1ItemStack;
			}
			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				par2World.spawnEntityInWorld(new EntityLightningBolt(par2World, i, j, k));
			}return par1ItemStack;


			default: ;
			}
		}

		return par1ItemStack;
	}


	@Override
	public Icon getIconFromDamage(int par1)
	{
		switch (par1){
		case 0: return this.itemIcon0;
		case 1: return this.itemIcon1;
		case 2: return this.itemIcon2;
		case 3: return this.itemIcon3;
		default: return this.itemIcon0;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1registerIcon){
		//        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass");
		this.itemIcon0 = par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass_Sun");
		this.itemIcon1 = par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass_Rain");
		this.itemIcon2 = par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass_Thunder");
		this.itemIcon3 = par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass_Lighting");
	}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List list, boolean par4)
	{
		switch (par1ItemStack.getItemDamage())
		{
		case 0: list.add("Sun");
		break;
		case 1: list.add("Rain");
		break;
		case 2: list.add("Thunder Storm");
		break;
		case 3: list.add("Lighting");
		break;
		//          default: list.add("");
		}
		list.add("Shift right click to change mode");
	}
}