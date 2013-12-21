package JohnTheAwsome123.mods.AdvancedCraft;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class CommonTickHandler implements ITickHandler
{
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        playerTick((EntityPlayer) tickData[0]);
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.PLAYER);
    }

    @Override
    public String getLabel()
    {
        return null;
    }
    boolean flag = false;
    public void playerTick(EntityPlayer player)
    {
        // 1 for helm, 2 for chest, 3 for legs, 4 for boots
        if (player.inventory.hasItemStack(new ItemStack(AdvancedCraft.netherStarOmniTool)))
        {
            for (ItemStack stack : player.inventory.armorInventory)
            {
                if (stack != null)
                {
                    if (stack.itemID == AdvancedCraft.netherStarOmniTool.itemID)
                    {
                        int L = 0;
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack) > 0)
                        {
                            L = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack);
                            int tick = 100 - 20 * L;
                            int tickdown = 0;
                            if (!flag) tickdown = tick;
                            flag = true;
                            tickdown--;
                            if (tickdown <= 0)
                            {
                                stack.setItemDamage(stack.getItemDamage() - 1);
                            }
                        }
                    }
                }
            }
        }

        if (player.getCurrentItemOrArmor(1) != null)
        {
            if (player.getCurrentItemOrArmor(1).itemID == AdvancedCraft.netherStarBoots.itemID)
            {
                Minecraft.getMinecraft().thePlayer.stepHeight = 1.0F;
            }
        }
        else
        {
            // if (player.getCurrentItemOrArmor(1).itemID ==
            // AdvancedCraft.netherStarBoots.itemID)
            {
                Minecraft.getMinecraft().thePlayer.stepHeight = 0.5F;
            }
        }
        if (player.getCurrentItemOrArmor(3) != null)
        {
            if (player.getCurrentItemOrArmor(3).itemID == AdvancedCraft.netherStarHelmet.itemID)
            {
//                if (!Minecraft.getMinecraft().thePlayer.getActivePotionEffects().contains(Potion.nightVision))
                {
//                    Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 0, false));
                }
                if (!Minecraft.getMinecraft().theWorld.isRemote)
                Minecraft.getMinecraft().thePlayer.curePotionEffects(new ItemStack(Item.bucketMilk));
            }
        }
        if (player.getCurrentItemOrArmor(0) != null)
        {
        }
    }
}