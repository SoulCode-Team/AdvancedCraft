package JohnTheAwsome123.mods.AdvancedCraft.tools;

import java.util.List;
import java.util.Random;

import JohnTheAwsome123.mods.AdvancedCraft.AdvancedCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class advancedClock extends Item
{
    private Icon itemIcon0;
    private Icon itemIcon1;
    private Icon itemIcon2;
    
    
    public advancedClock(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(AdvancedCraft.tabAdvancedCraft);
        this.setUnlocalizedName("advancedClock");
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.isSneaking()){
            this.setDamage(par1ItemStack, par1ItemStack.getItemDamage() < 2 ? par1ItemStack.getItemDamage() + 1 : 0);
        }
        else{
        int t = (300 + (new Random()).nextInt(600)) * 20;
        
        
        switch (par1ItemStack.getItemDamage()){
            case 1:
                for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
                {
                     WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
                    worldserver.setWorldTime(worldserver.getWorldTime() + (long)6000);
                }
                   break;
                   
            case 2:
                for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
                {
                     WorldServer worldserver = MinecraftServer.getServer().worldServers[j];
                    worldserver.setWorldTime(worldserver.getWorldTime() + (long)500);
                }
                   break;

                   
            default: ;
        }
        }

        return par1ItemStack;
    }
    
    
    @Override
    public Icon getIconFromDamage(int par1)
    {
        switch (par1){
            case 0: return this.itemIcon;
            case 1: return this.itemIcon1;
            case 2: return this.itemIcon2;
            default: return this.itemIcon;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon("clock");
//        this.itemIcon0 = (Icon)setTextureName("clock");
        this.itemIcon1 = par1registerIcon.registerIcon("AdvancedCraft:tool/advancedClock_night-day");
        this.itemIcon2 = par1registerIcon.registerIcon("AdvancedCraft:tool/advancedClock_faster");
    }
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List list, boolean par4)
    {
        switch (par1ItemStack.getItemDamage()){
          case 0: list.add("None");
                  break;
          case 1: list.add("Night/Day");
                  break;
          case 2: list.add("Time Skip");
                  break;
//          default: list.add("");
      }
    }
}
