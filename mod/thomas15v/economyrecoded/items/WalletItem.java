package mod.thomas15v.economyrecoded.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack par1ItemStack,	EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("KAKAK");
		super.addInformation(par1ItemStack, par2EntityPlayer, list, par4);
	}
	
}
