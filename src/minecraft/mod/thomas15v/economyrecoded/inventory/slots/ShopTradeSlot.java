package mod.thomas15v.economyrecoded.inventory.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ShopTradeSlot extends Slot {

	public ShopTradeSlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		// TODO Auto-generated method stub
		return false;
	}

}
