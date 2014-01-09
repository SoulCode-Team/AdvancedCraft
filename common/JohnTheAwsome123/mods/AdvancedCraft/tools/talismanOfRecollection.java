package JohnTheAwsome123.mods.AdvancedCraft.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class talismanOfRecollection extends Item
{
    // public static Map<Integer, Integer> fuelTickTime = new HashMap<Integer,
    // Integer>();
    // public static Object[][] fuelData =
    // {{Item.redstone.itemID},{20},{Item.glowstone.itemID},{30}};
    // public static int[] fuelIDs ;

    public static final int redstoneTime = 20;
    public static final int glowstoneTime = 30;
    public double[] playerLocation; 
    
    public int timeInTick = 0;

    public talismanOfRecollection(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(Reference.ACTAB);
        this.setUnlocalizedName("talismanOfRecollection");
        // this.setFuelTickTime(Item.redstone.itemID, 20);
        // this.setFuelTickTime(Item.glowstone.itemID, 30);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon)
    {
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }

    /*
     * public static void setFuelTickTime(int itemID, int length) {
     * fuelTickTime.put(itemID, length); // fuelData += {{itemID},{length}};
     * 
     * }
     * 
     * public static Integer getFuelTickTime(int itemID) { return
     * fuelTickTime.get(itemID); }
     * 
     * public static Integer getFuelID(int fuelTime) {
     * 
     * // for (int i=0; i <= fuelTickTime.size(); i++){ // return
     * fuelTickTime.get(fuelTime); // } // return key; int tmp = 0; for
     * (java.util.Map.Entry<Integer, Integer> entry : fuelTickTime.entrySet()) {
     * if (fuelTime == entry.getValue()) { tmp = entry.getKey(); } else{ tmp =
     * 0; } } return tmp;
     * 
     * }
     */

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.isSneaking())
        {
            // for (Object[] fuelID, Object[] fuelTime : fuelData){}
            for (int i = 0; i <= 2/* fuelTickTime.size() */; ++i)
            {
                System.out.println("i:" + String.valueOf(i));
                System.out.println("fuel ID:" + String.valueOf(i));
                // if (par3EntityPlayer.inventory.hasItem(getFuelID(i)))
                // {
                // this.timeInTick += getFuelTickTime(i);
                // }
                if (par3EntityPlayer.inventory.hasItem(Item.redstone.itemID))
                {
                    this.timeInTick += redstoneTime;
                }
                if (par3EntityPlayer.inventory.hasItem(Item.glowstone.itemID))
                {
                    this.timeInTick += glowstoneTime;
                }

            }
            // this.timeInTick = 30;
        }
        else
        {
            this.playerLocation[0] = par3EntityPlayer.posX;
            this.playerLocation[1] = par3EntityPlayer.posY;
            this.playerLocation[2] = par3EntityPlayer.posZ;
            
            this.playerLocation[3] = Minecraft.getMinecraft().thePlayer.motionX;
            this.playerLocation[4] = Minecraft.getMinecraft().thePlayer.motionY;
            this.playerLocation[5] = Minecraft.getMinecraft().thePlayer.motionZ;
            
            this.playerLocation[6] = Minecraft.getMinecraft().thePlayer.cameraPitch;
            this.playerLocation[7] = Minecraft.getMinecraft().thePlayer.cameraYaw;
            
            Minecraft.getMinecraft().thePlayer.addChatMessage(String.valueOf(playerLocation));
        }
        return par1ItemStack;

    }
}
