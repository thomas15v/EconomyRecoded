package mod.thomas15v.economyrecoded.items;

import java.util.List;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Coin extends Item {
	private Icon DollarCent;
	private Icon Dollar;
	
	public Coin(int id) {
		super(id);
		setCreativeTab(EconomyRecoded.tab);
		setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IconRegister icon) {
		DollarCent = icon.registerIcon(ModInfo.name.toLowerCase() + ":dollarcent");
		Dollar = icon.registerIcon(ModInfo.name.toLowerCase() + ":dollar");
		super.registerIcons(icon);
	}
	
	@Override
	public Icon getIconFromDamage(int itemid) {
		// TODO Auto-generated method stub
		switch (itemid) {
		case 0: return DollarCent;
		case 1: return Dollar;

		default: return null;
		}
	}

	
	@Override
	public void getSubItems(int par1, CreativeTabs tab,	List subitems) {
		for (int i = 1; i < 2; i++) subitems.add(new ItemStack(this, 1, i));
		super.getSubItems(par1, tab, subitems);
	}
	
	@Override
	public String getItemDisplayName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0: return "1 Cent";
		case 1: return stack.stackSize + "$";

		default: return null;
		}
	}
	
	public static int GetItemWorth(int Metadata){
		switch (Metadata) {
		case 0: return 0;
		case 1: return 1;
		default: return 0;
		}
		
	}
}
