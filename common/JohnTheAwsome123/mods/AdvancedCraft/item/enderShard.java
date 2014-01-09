package JohnTheAwsome123.mods.AdvancedCraft.item;

import net.minecraft.item.Item;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;

public class enderShard extends Item {

	public enderShard(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(Reference.ACTAB);
		this.setUnlocalizedName("Ender Shard");
	}

}
