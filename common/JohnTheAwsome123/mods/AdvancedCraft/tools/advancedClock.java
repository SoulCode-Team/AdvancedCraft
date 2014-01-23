package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import JohnTheAwsome123.mods.AdvancedCraft.CommonProxy;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class advancedClock extends Item
{
	private Icon itemIcon0, itemIcon1, itemIcon2, itemIcon3;
	private static final int modes = 4;

	public advancedClock(int par1)
	{
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(Reference.ACTAB);
		this.setUnlocalizedName("advancedClock");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		int i = 0;
		if (par3EntityPlayer.isSneaking())
		{
			this.setDamage(par1ItemStack, par1ItemStack.getItemDamage() < modes - 1 ? par1ItemStack.getItemDamage() + 1 : 0);
		}
		else
		{
			int t = (300 + (new Random()).nextInt(600)) * 20;

			switch (par1ItemStack.getItemDamage())
			{
			case 1:
				for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
				{
					WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
					i = (int) worldserver.getWorldTime();
					if (worldserver.getWorldTime() >= 12500)
					{
						i = 0;
					}
					else
					{
						i = 12500;
					}
					worldserver.setWorldTime(i);
					System.out.println("setting time to " + i + " in " + worldserver.getWorldInfo());
				}
				break;

			case 2:
				for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
				{
					WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
					worldserver.setWorldTime(worldserver.getWorldTime() + (long) 500);
				}
				break;
				
			case 3:
				for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
				{
					WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
					worldserver.setWorldTime(worldserver.getWorldTime() - (long) 500);
				}
				break;

			default:;
			}
		}

		return par1ItemStack;
	}

	@Override
	public Icon getIconFromDamage(int par1)
	{
		switch (par1)
		{
		case 0:
			return this.itemIcon;
		case 1:
			return this.itemIcon1;
		case 2:
			return this.itemIcon2;
		case 3:
			return this.itemIcon3;
		default:
			return this.itemIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1registerIcon)
	{
		this.itemIcon = par1registerIcon.registerIcon("clock");
		// this.itemIcon0 = (Icon)setTextureName("clock");
		this.itemIcon1 = par1registerIcon.registerIcon("AdvancedCraft:tool/advancedClock_night-day");
		this.itemIcon2 = par1registerIcon.registerIcon("AdvancedCraft:tool/advancedClock_forward");
		this.itemIcon3 = par1registerIcon.registerIcon("AdvancedCraft:tool/advancedClock_reverse");
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List list, boolean par4)
	{
		switch (par1ItemStack.getItemDamage())
		{
		case 0:
			list.add("Default");
			break;
		case 1:
			list.add("Night/Day");
			break;
		case 2:
			list.add("Fast Forward");
			break;
		case 3:
			list.add("Rewind");
			break;
			// default: list.add("");
		}
		list.add("Shift right click to change mode");
	}
}
