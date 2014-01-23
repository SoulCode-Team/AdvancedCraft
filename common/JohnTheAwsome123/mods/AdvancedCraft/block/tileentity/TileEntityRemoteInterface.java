package JohnTheAwsome123.mods.AdvancedCraft.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.Config;

public class TileEntityRemoteInterface extends TileEntity implements IInventory, ISidedInventory/*, IFluidHandler*/ {
	private ItemStack[] ItemStacks;
	public int xFarCoord;
	public int yFarCoord;
	public int zFarCoord;
	private int[] FarCoords= {0, 0, 0};

	private int validDistance = Config.validDistance;


	public TileEntityRemoteInterface() {
	}

	@Override
	public int getSizeInventory() {
		IInventory inventory = getInventory();
		int returnData = 0;

		if (inventory != null){
			returnData = inventory.getSizeInventory();
		}

		return returnData;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		IInventory inventory = getInventory();
		ItemStack returnData = null;

		if (inventory != null){
			returnData = inventory.getStackInSlot(i);
		}

		return returnData;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		IInventory inventory = getInventory();
		ItemStack returnData = null;

		if (inventory != null){
			returnData = inventory.decrStackSize(i, j);
		}

		return returnData;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		IInventory inventory = getInventory();

		if (inventory != null){
			inventory.setInventorySlotContents(i, itemstack);
		}
	}

	@Override
	public String getInvName() {
		IInventory inventory = getInventory();
		String returnData = null;

		if (inventory != null){
			returnData = inventory.getInvName();
		}

		return returnData;
	}

	@Override
	public boolean isInvNameLocalized() {
		IInventory inventory = getInventory();
		boolean returnData = false;

		if (inventory != null){
			returnData = inventory.isInvNameLocalized();
		}

		return returnData;
	}

	@Override
	public int getInventoryStackLimit() {
		IInventory inventory = getInventory();
		int returnData = 0;

		if (inventory != null){
			returnData = inventory.getInventoryStackLimit();
		}

		return returnData;
	}

	@Override
	public void onInventoryChanged() {
		IInventory inventory = getInventory();

		if (inventory != null){
			inventory.onInventoryChanged();
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		IInventory inventory = getInventory();
		boolean returnData = false;

		if (inventory != null){
			returnData = inventory.isUseableByPlayer(entityplayer);
		}

		return returnData;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		IInventory inventory = getInventory();
		boolean returnData = false;

		if (inventory != null){
			returnData = inventory.isItemValidForSlot(i, itemstack);
		}

		return returnData;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		IInventory inventory = getInventory();
		int[] returnData = null;

		if (inventory != null){
			if (inventory instanceof ISidedInventory){
				returnData = ((ISidedInventory) inventory).getAccessibleSlotsFromSide(var1);
			}
		}

		return returnData;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		IInventory inventory = getInventory();
		boolean returnData = false;

		if (inventory != null){
			if (inventory instanceof ISidedInventory){
				returnData = ((ISidedInventory) inventory).canInsertItem(i, itemstack, j);
			}
		}

		return returnData;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		IInventory inventory = getInventory();
		boolean returnData = false;

		if (inventory != null){
			if (inventory instanceof ISidedInventory){
				returnData = ((ISidedInventory) inventory).canExtractItem(i, itemstack, j);
			}
		}

		return returnData;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Coords");
		this.FarCoords = par1NBTTagCompound.getIntArray("FarCoords");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setIntArray("FarCoords", FarCoords);
	}

	//Custom Functions//

	private IInventory getInventory (){
		return getContainer(IInventory.class);
	}

	private <T> T getContainer(Class<T> type) {
		World world = getWorldObj();
		int x = getFarLocation("x");
		int y = getFarLocation("y");
		int z = getFarLocation("z");

		if (world != null) {
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null || type.isInstance(te)){
				return (T) te;
			}
		}
		return null;
	}

	private int getFarLocation(String axis){
		int Loc = 0;
		switch (axis) {
		case "x": Loc = this.FarCoords[0];
		break;
		case "y": Loc = this.FarCoords[1];
		break;
		case "z": Loc = this.FarCoords[2];
		break;
		}
		return Loc;
	}
	private void SetFarLocation(int x, int y, int z){
		this.FarCoords[0] = x;
		this.FarCoords[1] = y;
		this.FarCoords[2] = z;
	}

	public boolean inputFarCoords(int x, int y, int z, EntityPlayer player){
		if(validDistance >= this.getDistance(x, y, z)){
			this.SetFarLocation(x, y, z);
			return true;
		}
		
		
		return false;
	}
	
	public boolean inputFarCoords(int[] Coords, EntityPlayer player){
		int x = Coords[0];
		int y = Coords[1];
		int z = Coords[2];
		return this.inputFarCoords(x, y, z, player);
	}
	
	public double getDistance(double x, double y, double z)
    {
        double d3 = this.xCoord - x;
        double d4 = this.yCoord - y;
        double d5 = this.zCoord - z;
        return (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
    }

}
