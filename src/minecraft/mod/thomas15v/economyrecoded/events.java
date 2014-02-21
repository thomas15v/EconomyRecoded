package mod.thomas15v.economyrecoded;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

public class events {

	/*@ForgeSubscribe
	public void PlayerDropItemEvent(PlayerDropsEvent event){
		for (EntityItem drop : event.drops){
			if (drop.getEntityItem().itemID == EconomyRecoded.Coin.itemID){
				event.entityPlayer.inventory.addItemStackToInventory(drop.getEntityItem());
				drop.setDead();
				
			}
		}
		//event.setCanceled(true);
	}*/
}
