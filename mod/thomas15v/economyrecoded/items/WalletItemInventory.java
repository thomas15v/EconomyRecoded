package mod.thomas15v.economyrecoded.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class WalletItemInventory implements IInventory {
	
	ItemStack[] inv;
	EntityPlayer player;
		
	public WalletItemInventory(EntityPlayer player) {
		inv = new ItemStack[9 * 3];
		this.player = player;
		if (player.getHeldItem().stackTagCompound == null) player.getHeldItem().setTagCompound(new NBTTagCompound());
		readFromNBT();
		
	}
	
	public void readFromNBT() {
		
        NBTTagList tagList = player.getHeldItem().stackTagCompound.getTagList("Inventory");
        for (int i = 0; i < tagList.tagCount(); i++) {
                NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                byte slot = tag.getByte("Slot");
                if (slot >= 0 && slot < inv.length) {
                        inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                }
        }
	}

		public void writeToNBT() {
                        
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
                ItemStack stack = inv[i];
                if (stack != null) {
                        NBTTagCompound tag = new NBTTagCompound();
                        tag.setByte("Slot", (byte) i);
                        stack.writeToNBT(tag);
                        itemList.appendTag(tag);
                }
        }
        player.getHeldItem().stackTagCompound.setTag("Inventory", itemList);   
}
	
	
	
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		 ItemStack stack = getStackInSlot(slot);
         if (stack != null) {
                 if (stack.stackSize <= amt) {
                         setInventorySlotContents(slot, null);
                 } else {
                         stack = stack.splitStack(amt);
                         if (stack.stackSize == 0) {
                                 setInventorySlotContents(slot, null);
                         }
                 }
         }
         return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		 ItemStack stack = getStackInSlot(slot);
         if (stack != null) {
                 setInventorySlotContents(slot, null);
         }
         return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
        }             
	}

	@Override
	public String getInvName() {
		return "economyrecoded.SafeTileEntity";
	}

	@Override
	public boolean isInvNameLocalized() {
		
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return false;
	}
	

	@Override
	public void onInventoryChanged() {
		
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		writeToNBT();
	}

}
