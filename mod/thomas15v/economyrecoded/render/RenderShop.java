package mod.thomas15v.economyrecoded.render;

import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.models.ShopModel;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderShop extends TileEntitySpecialRenderer {

	private ShopModel shopmodel;
	private RenderItem itemrender;
	public RenderShop() {
		this.shopmodel = new ShopModel();
		itemrender = new RenderItem();
		itemrender.setRenderManager(RenderManager.instance);
	}
	
	

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		ShopTileEntity shoptile = (ShopTileEntity) tile;
		
		this.bindTexture(new ResourceLocation(ModInfo.name.toLowerCase(), "textures/models/shop.png"));
		GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        shopmodel.render(0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        
        float[][] Itemlocations = {{0.2F, 0.7F, 0.57F} ,{0.5F, 0.7F, 0.57F}, {0.8F, 0.7F, 0.57F}, {0.2F, 0.35F, 0.9F} ,{0.5F, 0.35F, 0.9F}, {0.8F, 0.35F, 0.9F}};
        
        
        
        for (int i = 0; i < Itemlocations.length; i++){
        	GL11.glPushMatrix();
            GL11.glTranslatef((float)x , (float) y, (float) z);
            GL11.glTranslatef(Itemlocations[i][0], Itemlocations[i][1], Itemlocations[i][2]);
            //GL11.glTranslatef(0.8F, 0.35F, 0.9F);
            //GL11.glTranslatef(0.5F, 0.35F, 0.9F);
            float timeD = (float) (360.0 * (double) (System.currentTimeMillis() & 0x3FFFL) / (double) 0x3FFFL);
            GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(0.70F, 0.70F, 0.70F);
            shoptile.testje.hoverStart = 0f;
            itemrender.doRender(shoptile.testje, 0, 0, 0, 0, 0);
            GL11.glPopMatrix();
        }
        
        
        
	}

}
