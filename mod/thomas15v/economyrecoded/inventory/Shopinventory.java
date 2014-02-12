package mod.thomas15v.economyrecoded.inventory;

import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.inventory.slots.ShopTradeSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Shopinventory extends Container {

	public Shopinventory(InventoryPlayer inventoryPlayer, ShopTileEntity te) {

        //the Slot constructor takes the IInventory and the slot number in that it binds to
       
        //and the x-y coordinates it resides on-screen
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
               	 	addSlotToContainer(new ShopTradeSlot(te, j + i * 3, 24 + j * 70, 1 + i * 32));
                } 
        }

        //commonly used vanilla code that adds the player's inventory
        bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, -17 + j * 18, 105 + i * 18));
                }
        }

        for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(inventoryPlayer, i, -17 + i * 18, 163));
        }
}
	
	@Override
 	public ItemStack transferStackInSlot(EntityPlayer player, int slotnummer) {
 		return null;
 	}

}
