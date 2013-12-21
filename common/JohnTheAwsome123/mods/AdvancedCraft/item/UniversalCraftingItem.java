package JohnTheAwsome123.mods.AdvancedCraft.item;

import java.util.List;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UniversalCraftingItem extends Item
{
    private static String[] itemNames = { "netherStar_Shard", "ender_Heart", "netherStar_Nugget" };

//     public UniversalCraftingItem(int par1)
//     {
//         this.UniversalCraftingItem(par1, 0);
//     }

    public UniversalCraftingItem(int par1, int damage)
    {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(64);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return itemNames[par1ItemStack.getItemDamage()];
    }

    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < 1/*itemNames.length*/; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon)
    {
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
}
