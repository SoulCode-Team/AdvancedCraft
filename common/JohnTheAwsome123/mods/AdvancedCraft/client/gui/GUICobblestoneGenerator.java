package JohnTheAwsome123.mods.AdvancedCraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import JohnTheAwsome123.mods.AdvancedCraft.block.container.ContainerCobblestoneGenerator;
import JohnTheAwsome123.mods.AdvancedCraft.block.tileentity.TileEntityCobblestoneGenerator;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;



public class GUICobblestoneGenerator extends GuiContainer
{
    TileEntityCobblestoneGenerator tileEntity;

    public GUICobblestoneGenerator(InventoryPlayer playerInv, TileEntityCobblestoneGenerator tileEntity)
    {
        super(new ContainerCobblestoneGenerator(playerInv, tileEntity));
        ySize = 232;
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {

        String containerName = tileEntity.getInvName();
        fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(ACTextures.GUI_COBBLESTONE_GENERATOR);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

}