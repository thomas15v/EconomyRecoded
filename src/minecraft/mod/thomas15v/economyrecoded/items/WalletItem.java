package mod.thomas15v.economyrecoded.items;

import java.util.List;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.World;

public class WalletItem extends Item {
	
	ItemStack inv[];


	public WalletItem(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(EconomyRecoded.tab);
		setUnlocalizedName("Wallet");
		setTextureName(ModInfo.name.toLowerCase() + ":wallet");
		
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (itemstack.stackTagCompound == null) itemstack.setTagCompound(new NBTTagCompound());
		if (itemstack.stackTagCompound.getString("WhoMadedit") == "") itemstack.stackTagCompound.setString("WhoMadedit", player.username);
		player.openGui(EconomyRecoded.instance, 1, world, 0, 0, 0);
		return itemstack;
	}
	
	@Override
	public void addInformation(ItemStack itemstack,	EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add(GetTotalMoney(readFromNBT(itemstack))+ "$");
		super.addInformation(itemstack, par2EntityPlayer, list, par4);
	}
	
	public ItemStack[] readFromNBT(ItemStack item) {
		ItemStack[] inv = new ItemStack[9 * 3];
		if (item.stackTagCompound != null){
	        NBTTagList tagList = item.stackTagCompound.getTagList("Inventory");
	        for (int i = 0; i < tagList.tagCount(); i++) {
	                NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
	                byte slot = tag.getByte("Slot");
	                if (slot >= 0 && slot < inv.length) {
	                        inv[slot] = ItemStack.loadItemStackFromNBT(tag);
	                }
	        }
		}
        return inv;
	}
	
	public int GetTotalMoney(ItemStack[] stacklist){
 		int TotalMoney = 0;
 		 for (ItemStack item : stacklist){
 			 if (item != null) TotalMoney += Coin.GetItemWorth(item.getItemDamage()) * item.stackSize; 	  
 		 }    	
 		 return TotalMoney;
     }
}
