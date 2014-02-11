package mod.thomas15v.economyrecoded.client;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import mod.thomas15v.economyrecoded.CommonProxy;
import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.render.RenderShop;
import mod.thomas15v.economyrecoded.render.RenderShopBlockItem;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(ShopTileEntity.class, new RenderShop());
		MinecraftForgeClient.registerItemRenderer(EconomyRecoded.Shop.blockID, new RenderShopBlockItem());		
	}

}
