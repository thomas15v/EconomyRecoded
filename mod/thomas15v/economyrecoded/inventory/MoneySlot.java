package mod.thomas15v.economyrecoded.inventory;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class MoneySlot extends Slot {

	public MoneySlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public MoneySlot(Slot slot) {
		super(slot.inventory, slot.slotNumber, slot.xDisplayPosition, slot.yDisplayPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.itemID == EconomyRecoded.Coin.itemID;
	}

}
