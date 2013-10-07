package JohnTheAwsome123.mods.AdvancedCraft.item;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class enderShard extends Item {

	public enderShard(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
		this.setUnlocalizedName("Ender Shard");
	}

}
