package JohnTheAwsome123.mods.AdvancedCraft.food;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sugarCookie extends ItemFood
{
    public sugarCookie(int par1, int hungerFill, float saturation, boolean wolvesFood)
    {
        super(par1, hungerFill, saturation, wolvesFood);
        this.setCreativeTab(Reference.ACTAB);
        this.setUnlocalizedName("sugarCookie");
        this.setMaxStackSize(13);
        this.setAlwaysEdible();
    }
    public sugarCookie(int par1, int hungerFill, boolean wolvesFood)
    {
        this(par1, hungerFill, 0.6F, wolvesFood);

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "food/"));
    }
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par2World.isRemote)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2400, 0, false));
            super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        }
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    list.add("Warm and delicious");
    }
}
