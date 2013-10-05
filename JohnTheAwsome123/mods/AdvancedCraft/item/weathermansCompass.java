package JohnTheAwsome123.mods.AdvancedCraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class weathermansCompass extends Item
{

    private Icon itemIcon0;
    private Icon itemIcon1;
    private Icon itemIcon2;
    private Icon itemIcon3;

    public weathermansCompass(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
//        this.setUnlocalizedName("weathermansCompass");
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    
//    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
//    {
//        par3List.add(new ItemStack(par1, 1, 0));
//        par3List.add(new ItemStack(par1, 1, 1));
//        par3List.add(new ItemStack(par1, 1, 2));
//        par3List.add(new ItemStack(par1, 1, 3));
//    }
    
//    @Override
//    public String getUnlocalizedName(ItemStack par1ItemStack)
//    {
//        switch (par1ItemStack.getItemDamage()){
//            case 0: return "weathermans_Compass_Sun";
//            case 1: return "weathermans_Compass_Rain";
//            case 2: return "weathermans_Compass_Thunder";
//            case 3: return "weathermans_Compass_Lighting";
//            default: return "weathermans_Compass";
//        }
//    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.isSneaking()){
            this.setDamage(par1ItemStack, par1ItemStack.getItemDamage() < 3 ? par1ItemStack.getItemDamage() + 1 : 0);
        } // par1ItemStack.getItemDamage() >= 3 ? par1ItemStack.getItemDamage() + 1 : 0
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
    
    
    @Override
    public Icon getIconFromDamage(int par1)
    {
        switch (par1){
            case 0: return this.itemIcon0;
            case 1: return this.itemIcon1;
            case 2: return this.itemIcon2;
            case 3: return this.itemIcon3;
            default: return this.itemIcon;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("AdvancedCraft:Weathermans_Compass");
        this.itemIcon0 = par1registerIcon.registerIcon("AdvancedCraft:Weathermans_Compass_Sun");
        this.itemIcon1 = par1registerIcon.registerIcon("AdvancedCraft:Weathermans_Compass_Rain");
        this.itemIcon2 = par1registerIcon.registerIcon("AdvancedCraft:Weathermans_Compass_Thunder");
        this.itemIcon3 = par1registerIcon.registerIcon("AdvancedCraft:Weathermans_Compass_Lighting");
    }
}