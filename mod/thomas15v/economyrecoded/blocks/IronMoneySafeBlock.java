package mod.thomas15v.economyrecoded.blocks;

import mod.thomas15v.economyrecoded.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class IronMoneySafeBlock extends MoneySafeBlock {

	public IronMoneySafeBlock(int id, Material material) {
		super(id, material);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Iron Safe");
		
	}
	
	@Override
	public void registerIcons(IconRegister icon) {
		topicon = icon.registerIcon(ModInfo.name.toLowerCase() + ":iron_safe_top");	
		sideicon = icon.registerIcon(ModInfo.name.toLowerCase() + ":iron_safe_side");
		fronticon = icon.registerIcon(ModInfo.name.toLowerCase()+ ":iron_safe_front_side");
		
	}
}
