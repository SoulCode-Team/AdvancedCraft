package JohnTheAwsome123.mods.AdvancedCraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class netherStarNugget extends Item
{

    public netherStarNugget(int par1)
    {
        super(par1);
        this.setMaxStackSize(64);
        this.setCreativeTab(Reference.ACTAB);
        this.setUnlocalizedName("netherStar_Nugget");
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
}
