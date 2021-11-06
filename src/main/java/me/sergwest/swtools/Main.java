package me.sergwest.swtools;

import me.sergwest.swtools.proxy.CommonProxy;
import me.sergwest.swtools.util.refrence;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = refrence.MOD_ID, name = refrence.NAME, version = refrence.VERSION)
public class Main {
	@Instance
	public Main instance;
	
	@SidedProxy(clientSide = refrence.CLIENT_PROXY_CLASS, serverSide = refrence.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void Init (FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	@EventHandler
	public void PostInit (FMLPreInitializationEvent event) {
		
	}
}
