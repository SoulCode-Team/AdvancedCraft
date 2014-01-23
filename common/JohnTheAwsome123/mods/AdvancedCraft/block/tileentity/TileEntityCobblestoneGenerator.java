package JohnTheAwsome123.mods.AdvancedCraft.block.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCobblestoneGenerator extends TileEntity implements ISidedInventory
{
    private String inventoryName;
    private int timeUntilNextGen;
    
    
    private ItemStack[] cobbleItemStacks = new ItemStack[1];
    
    @Override
    public int getSizeInventory()
    {
        return this.cobbleItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int par1)
    {
        return this.cobbleItemStacks[par1];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.cobbleItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.cobbleItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.cobbleItemStacks[par1];
                this.cobbleItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.cobbleItemStacks[par1].splitStack(par2);

                if (this.cobbleItemStacks[par1].stackSize == 0)
                {
                    this.cobbleItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.cobbleItemStacks[par1] != null)
        {
            ItemStack itemstack = this.cobbleItemStacks[par1];
            this.cobbleItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.cobbleItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName()
    {
        return this.isInvNameLocalized() ? this.inventoryName : "container.CobblestoneGenerator";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return this.inventoryName != null && this.inventoryName.length() > 0;
    }
    
    public void setInventoryName(String par1Str)
    {
        this.inventoryName = par1Str;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest(){}
    
    @Override
    public void closeChest(){}


    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return (itemstack.itemID == Block.cobblestone.blockID);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return new int[]{0};
    }

    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return false;
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3)
    {
        return par3 != 0 || par1 != 1;
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.cobbleItemStacks = new ItemStack[this.getSizeInventory()];

        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.inventoryName = par1NBTTagCompound.getString("CustomName");
        }

        this.timeUntilNextGen = par1NBTTagCompound.getInteger("timeUntilNextGen");

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.cobbleItemStacks.length)
            {
                this.cobbleItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.cobbleItemStacks.length; ++i)
        {
            if (this.cobbleItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.cobbleItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
        par1NBTTagCompound.setInteger("timeUntilNextGen", this.timeUntilNextGen);

        if (this.isInvNameLocalized())
        {
            par1NBTTagCompound.setString("CustomName", this.inventoryName);
        }
    }
    
}
