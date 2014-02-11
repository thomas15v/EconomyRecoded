package mod.thomas15v.economyrecoded.blocks;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShopBlock extends BlockContainer {
	public ShopBlock(int id) {
		super(id, Material.wood);
		setCreativeTab(EconomyRecoded.tab);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new ShopTileEntity();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(ModInfo.name + ":ShopBlock");
		super.registerIcons(icon);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		// TODO Auto-generated method stub
		return -1;
	}
	

	@Override
	public boolean onBlockActivated(World world, int x, int y,
			int z, EntityPlayer player, int par6, float par7,
			float par8, float par9) {
		player.openGui(EconomyRecoded.instance, 2, world, x, y, z);
		return true;
	}
	
}