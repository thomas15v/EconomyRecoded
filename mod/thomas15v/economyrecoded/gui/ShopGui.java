package mod.thomas15v.economyrecoded.gui;

import org.lwjgl.opengl.GL11;

import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.inventory.Shopinventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ShopGui extends GuiContainer {
	
	int xSize = 226;
	int ySize = 209;
	
	protected String Texture = "textures/gui/container/shop_gui_buyer.png";

	
	public ShopGui(InventoryPlayer player, ShopTileEntity entity) {
		
		super(new Shopinventory(player, entity));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int x = (width - xSize) /2;
	    int y = (height - ySize) /2;
		mc.renderEngine.bindTexture(new ResourceLocation(ModInfo.name.toLowerCase() + ":" + Texture));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}
	 @Override
     protected void drawGuiContainerForegroundLayer(int x, int y) {
		 fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 7, 85, 4210752);
       //fontRenderer.drawString("X:" + x + "  Y:" + y, 0, 0, 0xFFFFFF);
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
            	 itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.swordDiamond), -10 + j * 70, -5 + i * 32);
            	 fontRenderer.drawString("99999$", -20 + j * 70, 15 + i * 32, 4210752);
            	 
             }
          }
         
	 }
	 
	 
}
