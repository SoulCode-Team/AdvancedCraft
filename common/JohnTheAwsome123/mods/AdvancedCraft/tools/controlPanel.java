package JohnTheAwsome123.mods.AdvancedCraft.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.block.tileentity.TileEntityCobblestoneGenerator;
import JohnTheAwsome123.mods.AdvancedCraft.block.tileentity.TileEntityRemoteInterface;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class controlPanel extends Item {
	
	private int[] startLocation = {0, 0, 0};
	private int[] FarLocation = {0, 0, 0};
	private boolean RemoteFlag = false;
	
	public controlPanel(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(Reference.ACTAB);
		this.setUnlocalizedName("control_Panel");
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1registerIcon){
		this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "tool/"));
	}
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		int blockid = world.getBlockId(x, y, z);
		if (te instanceof TileEntityCobblestoneGenerator)
		{
			
		}
		
		if (te instanceof TileEntityRemoteInterface)
		{
			this.startLocation[0] = x;
			this.startLocation[1] = y;
			this.startLocation[2] = z;
			player.sendChatToPlayer(new ChatMessageComponent().addText("Remote Interface Set"));
//			player.sendChatToPlayer(new ChatMessageComponent().addText("Now Right-Click Remote located block"));
			this.RemoteFlag = true;
		}
		else
		{
			if (this.RemoteFlag)
			{
				if (world.getBlockTileEntity(x, y, z) != null)
				{
					this.FarLocation[0] = x;
					this.FarLocation[1] = y;
					this.FarLocation[2] = z;
					TileEntityRemoteInterface RIte = (TileEntityRemoteInterface) world.getBlockTileEntity(this.startLocation[0], this.startLocation[1], this.startLocation[2]);
					if (RIte.inputFarCoords(this.FarLocation, player)){
						player.sendChatToPlayer(new ChatMessageComponent().addText("Link Established"));
					}
					else
					{
						player.sendChatToPlayer(new ChatMessageComponent().addText("Distance too great"));
					}
				}
			}
		}
		
		return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY,hitZ);
	}
}
