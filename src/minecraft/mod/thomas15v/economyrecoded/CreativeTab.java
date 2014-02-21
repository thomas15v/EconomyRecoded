package mod.thomas15v.economyrecoded;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getTabIconItemIndex() {
		// TODO Auto-generated method stub
		return EconomyRecoded.instance.WoodenSafeBlock.blockID;
	}

}
