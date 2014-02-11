package mod.thomas15v.economyrecoded.gui;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.inventory.Shopinventory;
import mod.thomas15v.economyrecoded.inventory.WoodenSafeInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.Hopper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0: return new WoodenSafeInventory(player.inventory, (SafeTileEntity) world.getBlockTileEntity(x, y, z));
		case 1: return new WoodenSafeInventory(player.inventory, player);
		case 2: return new Shopinventory(player.inventory, (ShopTileEntity) world.getBlockTileEntity(x, y, z));
		default:return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		switch (ID) {
		case 0: return new WoodenSafeGui(player.inventory, (SafeTileEntity) world.getBlockTileEntity(x, y, z));
		case 1:	return new WoodenSafeGui(player.inventory, player); // TODO fix this man
		case 2: return new ShopGui(player.inventory, (ShopTileEntity)world.getBlockTileEntity(x, y, z));
		default:return null;
		}
	}	

}
