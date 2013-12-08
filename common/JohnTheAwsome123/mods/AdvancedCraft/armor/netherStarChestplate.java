package JohnTheAwsome123.mods.AdvancedCraft.armor;

/**
 * AdvancedCraft
 * 
 * Nether Star Chestplate
 * @category Item
 * @category Armor
 * @author JohnTheAwsome123
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class netherStarChestplate extends ItemArmor
{
    public netherStarChestplate(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setUnlocalizedName("netherStar_Chestplate");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "armor/"));
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer){
        return ACTextures.RESOURCE_CONTEXT + ":textures/models/armor/netherStar_layer_1.png";
    }

}
