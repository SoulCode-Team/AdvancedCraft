package JohnTheAwsome123.mods.AdvancedCraft.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ACTextures {
	public static String FormatUnlocalized(Item item) {
		return item.getUnlocalizedName().substring(5);
	}

	public static String FormatUnlocalized(Block block) {
		return block.getUnlocalizedName().substring(5);
	}

	public static String GetTextureNameFull(Item item) {
		return ACTextures.GetTextureNameFull(item, "");
	}

	public static String GetTextureNameFull(Block block) {
		return ACTextures.GetTextureNameFull(block, "");
	}

	public static String GetTextureNameFull(Item item, String subFolders) {
		return ACTextures.RESOURCE_CONTEXT + ":" + subFolders
				+ ACTextures.FormatUnlocalized(item);
	}

	public static String GetTextureNameFull(Block block, String subFolders) {
		return ACTextures.RESOURCE_CONTEXT + ":" + subFolders
				+ ACTextures.FormatUnlocalized(block);
	}

	// public static final String RESOURCE_CONTEXT = "AdvancedCraft";
	public static final String RESOURCE_CONTEXT = Reference.MOD_ID;

	// Guis //
	public static final ResourceLocation GUI_COBBLESTONE_GENERATOR = new ResourceLocation(
			RESOURCE_CONTEXT, "textures/guis/cobblestone_generator.png");

	// Models //
	// public static final ResourceLocation MODEL_ROCKET = new
	// ResourceLocation(RESOURCE_CONTEXT, "textures/entities/fuselage.png");
	// public static final ResourceLocation MODEL_COM_SATELLITE=new
	// ResourceLocation(RESOURCE_CONTEXT,"textures/entities/comSatelliteBase.png");

}
