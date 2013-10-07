package JohnTheAwsome123.mods.AdvancedCraft.util;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTTagable
{

    void readFromNBT(NBTTagCompound nbttagcompound);

    void writeToNBT(NBTTagCompound nbttagcompound);
}
