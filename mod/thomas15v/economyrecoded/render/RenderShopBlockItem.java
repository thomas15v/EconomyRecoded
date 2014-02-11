package mod.thomas15v.economyrecoded.render;

import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.models.ShopModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderShopBlockItem implements IItemRenderer {
	
	private ShopModel model = new ShopModel();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		//TileEntityRenderer.instance.renderTileEntityAt(new ShopTileEntity(),  0.0D, 0.0D, 0.0D, 0.0F);
	}

}
