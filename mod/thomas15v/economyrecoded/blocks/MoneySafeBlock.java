package mod.thomas15v.economyrecoded.blocks;

import java.util.Random;

import mod.thomas15v.economyrecoded.EconomyRecoded;
import mod.thomas15v.economyrecoded.ModInfo;
import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoneySafeBlock extends BlockContainer{
	
	public MoneySafeBlock(int id, Material material){
		super(id, material);	
		setHardness(3F);
		setResistance(100F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName("Wooden Safe");
		setCreativeTab(EconomyRecoded.tab);
		
	}
	
	@SideOnly(Side.CLIENT)
	protected Icon topicon;
	@SideOnly(Side.CLIENT)
	protected Icon sideicon;
	@SideOnly(Side.CLIENT)
	protected Icon fronticon;
	

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		topicon = icon.registerIcon(ModInfo.name.toLowerCase() + ":wooden_safe_top");	
		sideicon = icon.registerIcon(ModInfo.name.toLowerCase() + ":wooden_safe_side");
		fronticon = icon.registerIcon(ModInfo.name.toLowerCase()+ ":wooden_safe_front_side");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int metadata) {
		if (side == 1 || side == 0) return topicon;
		else if (metadata == 2 && side == 2) return fronticon;
		else if (metadata == 3 && side == 5) return fronticon;
		else if (metadata == 0 && side == 3) return fronticon;
		else if (metadata == 1 && side == 4) return fronticon;
		else return sideicon;		
		
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(EconomyRecoded.instance, 0, world, x, y, z);		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new SafeTileEntity();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
		int whichDirectionFacing = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 0);
        
	}
	 @Override
     public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
             dropItems(world, x, y, z);
             super.breakBlock(world, x, y, z, par5, par6);
     }

     private void dropItems(World world, int x, int y, int z){
             Random rand = new Random();

             TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
             if (!(tileEntity instanceof IInventory)) {
                     return;
             }
             IInventory inventory = (IInventory) tileEntity;

             for (int i = 0; i < inventory.getSizeInventory(); i++) {
                     ItemStack item = inventory.getStackInSlot(i);

                     if (item != null && item.stackSize > 0) {
                             float rx = rand.nextFloat() * 0.8F + 0.1F;
                             float ry = rand.nextFloat() * 0.8F + 0.1F;
                             float rz = rand.nextFloat() * 0.8F + 0.1F;

                             EntityItem entityItem = new EntityItem(world,
                                             x + rx, y + ry, z + rz,
                                             new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                             if (item.hasTagCompound()) {
                                     entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                             }

                             float factor = 0.05F;
                             entityItem.motionX = rand.nextGaussian() * factor;
                             entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                             entityItem.motionZ = rand.nextGaussian() * factor;
                             world.spawnEntityInWorld(entityItem);
                             item.stackSize = 0;
                     }
             }
     }
}
