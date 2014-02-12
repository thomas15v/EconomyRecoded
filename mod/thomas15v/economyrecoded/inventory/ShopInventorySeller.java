package mod.thomas15v.economyrecoded.inventory;

import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.inventory.slots.ShopTradeSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShopInventorySeller extends Container {

	public ShopInventorySeller(InventoryPlayer inventory, ShopTileEntity blockTileEntity) {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
           	 	addSlotToContainer(new ShopTradeSlot(blockTileEntity, j + i * 3, -7 + j * 70, 1 + i * 32));
            }
		}
		
		for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
           	 	addSlotToContainer(new ShopTradeSlot(blockTileEntity, j + i * 3, 160 + j * 18, 109 + i * 18));
            }
		}
		
        bindPlayerInventory(inventory);
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, -22 + j * 18, 105 + i * 18));
                }
        }

        for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(inventoryPlayer, i, -22 + i * 18, 163));
        }
	}
	
	

}
