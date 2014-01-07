package JohnTheAwsome123.mods.AdvancedCraft.armor;

/**
 * AdvancedCraft
 * 
 * Nether Star Helmet
 * @category Item
 * @category Armor
 * @author JohnTheAwsome123
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class netherStarHelmet extends ItemArmor
{

    public netherStarHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setUnlocalizedName("netherStar_Helmet");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "armor/"));
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
    	int layer = slot == 2 ? 2 : 1;
    	return ACTextures.RESOURCE_CONTEXT + ":textures/models/armor/netherStar_layer_" + layer + ".png";
    }
}