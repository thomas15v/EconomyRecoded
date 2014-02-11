package mod.thomas15v.economyrecoded.inventory;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.items.Coin;
import mod.thomas15v.economyrecoded.items.WalletItemInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class WoodenSafeInventory extends Container {

	
	int numRows = 3;
	WalletItemInventory inventory;
	
	public WoodenSafeInventory (InventoryPlayer inventoryPlayer, SafeTileEntity te){
         

         //the Slot constructor takes the IInventory and the slot number in that it binds to
        
         //and the x-y coordinates it resides on-screen
         for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 9; j++) {
                	 	int slot =  j + i * 9;
                        addSlotToContainer(new MoneySlot(te, slot , 8 + j * 18, 26 + i * 18));
                 }
         }

         //commonly used vanilla code that adds the player's inventory
         bindPlayerInventory(inventoryPlayer);
	}
	
	public WoodenSafeInventory (InventoryPlayer inventoryPlayer, EntityPlayer player){
		WalletItemInventory walletItemInventory = new WalletItemInventory(player);
		inventory = walletItemInventory;
		
		 for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 9; j++) {
                     addSlotToContainer(new MoneySlot(walletItemInventory, j + i * 9 , 8 + j * 18, 26 + i * 18));
             }
     }
		
		bindPlayerInventory(inventoryPlayer);
	}
	

	 @Override
	 public boolean canInteractWith(EntityPlayer player) {	
	         return true;
	 }
	
	
	 protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
	         for (int i = 0; i < 3; i++) {
	                 for (int j = 0; j < 9; j++) {
	                         addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 94 + i * 18));
	                         
	                 }
	         }
	
	         for (int i = 0; i < 9; i++) {
	                 addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 152));
	         }
	 }
	
 	@Override
 	public ItemStack transferStackInSlot(EntityPlayer player, int slotnummer) {
 		ItemStack itemstack = null;
 		Slot slot = (Slot) this.inventorySlots.get(slotnummer);

         if (slot != null && slot.getHasStack())
         {
             ItemStack itemstack1 = slot.getStack();
             itemstack = itemstack1.copy();
             
             if (itemstack.itemID == EconomyRecoded.Coin.itemID){
	             if (slotnummer < this.numRows * 9)
	             {
	                 if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
	                 {
	                     return null;
	                 }
	             }
	             else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
	             {
	                 return null;
	             }
	             
	
	             if (itemstack1.stackSize == 0)
	             {
	                 slot.putStack((ItemStack)null);
	             }
	             else
	             {
	                 slot.onSlotChanged();
	             }
             }else{
            	 return null;
             }
         }
		
         return itemstack;
	 }
 	
 	@Override
 	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
 		if (inventory != null) inventory.closeChest();
 	}
 
 	@Override
 	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
 		try{
 			InventoryPlayer inventoryplayer = par4EntityPlayer.inventory;
 			Slot slot = (Slot) inventorySlots.get(par1);
 			if (slot.getStack() != null && slot.getStack().itemID == EconomyRecoded.Wallet.itemID) return null;
 			
 		}catch (ArrayIndexOutOfBoundsException e){
 			
 		}catch (Exception e) {
 			e.printStackTrace(System.out);
 		}
 		return super.slotClick(par1, par2, par3, par4EntityPlayer);
 	}
 	
 	public int GetTotalMoney(){
 		int TotalMoney = 0;
 		 for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < 9; j++) {
            	if (this.getSlot(j + i * 9).getHasStack()){
            		ItemStack stack = this.getSlot(j + i * 9).getStack();
                	TotalMoney += Coin.GetItemWorth(stack.getItemDamage()) * stack.stackSize; 	 
            	}
            	
             }
 		 }
 		 return TotalMoney;
     }
}
