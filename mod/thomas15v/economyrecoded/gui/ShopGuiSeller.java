package mod.thomas15v.economyrecoded.gui;

import org.lwjgl.opengl.GL11;

import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.inventory.ShopInventorySeller;
import mod.thomas15v.economyrecoded.inventory.Shopinventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class ShopGuiSeller extends GuiContainer {
	int xSize = 236;
	int ySize = 209;
	
	public ShopGuiSeller(InventoryPlayer player, ShopTileEntity entity) {
		super(new ShopInventorySeller(player, entity));
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int x = (width - xSize) /2;
	    int y = (height - ySize) /2;
		mc.renderEngine.bindTexture(new ResourceLocation(ModInfo.name.toLowerCase() + ":" + "textures/gui/container/shop_gui_seller.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
}
