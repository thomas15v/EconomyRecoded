package mod.thomas15v.economyrecoded;

import java.util.logging.Logger;

import mod.thomas15v.economyrecoded.TileEntity.SafeTileEntity;
import mod.thomas15v.economyrecoded.TileEntity.ShopTileEntity;
import mod.thomas15v.economyrecoded.blocks.IronMoneySafeBlock;
import mod.thomas15v.economyrecoded.blocks.MoneySafeBlock;
import mod.thomas15v.economyrecoded.blocks.ShopBlock;
import mod.thomas15v.economyrecoded.gui.GuiHandler;
import mod.thomas15v.economyrecoded.items.Coin;
import mod.thomas15v.economyrecoded.items.WalletItem;
import mod.thomas15v.economyrecoded.render.RenderShop;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=ModInfo.modid , name=ModInfo.name, version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class EconomyRecoded {
	
	
		public static CreativeTabs tab = new CreativeTab("EconomyRecoded");
		public static Block WoodenSafeBlock ;
		public static Item Wallet;
		public static Item Coin;
		public static Block IronSafeBlock;
		public static ShopBlock Shop;
		
		
		public static Object econ = null;
		public static Boolean EconmySetup = false;
		
		public static Logger logger;
		
        // The instance of your mod that Forge uses.
        @Instance(ModInfo.modid) 
        public static EconomyRecoded instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide=ModInfo.clientSide, serverSide=ModInfo.serverSide)
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
               logger = event.getModLog();            
        }
        
        @EventHandler 
        public void load(FMLInitializationEvent event) {
        	Wallet = new WalletItem(501);
            Coin = new Coin(502);
            IronSafeBlock = new IronMoneySafeBlock(503, Material.iron);
            Shop = new ShopBlock(504);
            WoodenSafeBlock = new MoneySafeBlock(500, Material.wood);
        	
        		
            proxy.registerRenderers();
            
            GameRegistry.registerBlock(Shop, "Shop");
            LanguageRegistry.addName(Shop, "Shop");
            GameRegistry.registerTileEntity(ShopTileEntity.class, "ShopTileEntity");
            
            GameRegistry.registerTileEntity(SafeTileEntity.class, "SafeTileEntity");
            
            GameRegistry.registerBlock(WoodenSafeBlock, "Wooden Safe");
            GameRegistry.addShapedRecipe(new ItemStack(WoodenSafeBlock, 1), "ILL", "W L", "ILL",'I', Item.ingotIron, 'L' , Block.wood, 'W', Block.planks);
            LanguageRegistry.addName(WoodenSafeBlock, "Wooden Safe");
            
            GameRegistry.registerBlock(IronSafeBlock, "Iron Safe");
            LanguageRegistry.addName(IronSafeBlock, "Iron Safe");
                            
            GameRegistry.registerItem(Wallet, "Wallet" ,ModInfo.modid);
            LanguageRegistry.addName(Wallet, "Wallet");
            GameRegistry.addShapedRecipe(new ItemStack(Wallet, 1), "XYX","XYX","XXX", 'X', Item.leather);
            
            GameRegistry.registerItem(Coin, "coin", ModInfo.modid);
            LanguageRegistry.addName(new ItemStack(Coin, 1, 0), "1 Cent");
            LanguageRegistry.addName(new ItemStack(Coin, 1, 1), "1 $");
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.EconomyRecoded","EconomyRecoded");   
          
            NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());        
            
            MinecraftForge.EVENT_BUS.register(new events());
        }
               
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {

        }
        
        @EventHandler
        public void LivingDeathEvent(){
        	
        }
}