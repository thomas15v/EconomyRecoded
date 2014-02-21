package mod.thomas15v.economyrecoded.gui;

import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.inventory.WoodenSafeInventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class WoodenSafeGui extends GuiContainer {


	int xSize = 176;
	int ySize = 186;
	
	public WoodenSafeGui(InventoryPlayer player, SafeTileEntity entity) {
		super(new WoodenSafeInventory(player, entity));
		
	}
	
	public WoodenSafeGui(InventoryPlayer player, EntityPlayer entity) {
		super(new WoodenSafeInventory(player, entity));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int x = (width - xSize) /2;
	    int y = (height - ySize) /2;
		mc.renderEngine.bindTexture(new ResourceLocation(ModInfo.name.toLowerCase() + ":textures/gui/container/wooden_safe_gui.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    
	    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
			    
	}
	
	  @Override
      protected void drawGuiContainerForegroundLayer(int x, int y) {
          //draw text and stuff here
          //the parameters for drawString are: string, x, y, color
	    
       //   fontRenderer.drawString("Tiny", param1, param2, 4210752);
          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 7, 85, 4210752);
          fontRenderer.drawString("X:" + x + "  Y:" + y, 390, -170, 0xFFFFFF);
          fontRenderer.drawString("X:" + (x - 339) + "  Y:" + (y-181), 390, -160, 0xFFFFFF);
          WoodenSafeInventory inv = (WoodenSafeInventory) inventorySlots;
          fontRenderer.drawString("Money: " + inv.GetTotalMoney() + "$" , 6, 0, 4210752);
          
     } 
}
