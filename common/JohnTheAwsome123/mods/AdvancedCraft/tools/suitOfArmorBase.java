package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import JohnTheAwsome123.mods.AdvancedCraft.armor.*;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class suitOfArmorBase extends Item
{
    public static Map<Integer, ItemStack[]> data = new HashMap<Integer, ItemStack[]>();
    
    public ItemStack toolStack[];
    /**
     ** Constuctor. Params: int-item id, ItemStack[]-array of armor and sword(boots, leggings, chestplate, helmet, sword)
     */
    public suitOfArmorBase(int par1, ItemStack[] toolItemStack)
    {
        super(par1);
        this.setUnlocalizedName("suitOfArmor");
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setMaxStackSize(1);
        this.setData(this.itemID, toolItemStack);
    }
    public static void setData(int itemID, ItemStack[] stack){
        data.put(itemID, stack);
    }
    
    public static ItemStack[] getData(int itemID){
        return data.get(itemID);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "armor/suit/"));
//        System.out.println("texture:" + this.getUnlocalizedName(new ItemStack(Item.itemsList[this.itemID])));
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        toolStack = getData(par1ItemStack.itemID);
        
        for (int i=0; i<4; i++){
            ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor(i);
            
            toolStack[i].stackSize = 1;
            if (itemstack1 == null)
            {
                par3EntityPlayer.setCurrentItemOrArmor(i + 1, toolStack[i]);
            }
            else{
                par3EntityPlayer.inventory.addItemStackToInventory(toolStack[i]);
            }
        }
        
        return toolStack[4];
    }
}
