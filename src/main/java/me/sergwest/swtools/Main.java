package me.sergwest.swtools;

import org.lwjgl.input.Keyboard;

import me.sergwest.swtools.gui.Hud;
import me.sergwest.swtools.module.Module;
import me.sergwest.swtools.module.ModuleManager;
import me.sergwest.swtools.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	
	public static ModuleManager moduleManager;
	public static Hud hud;
	
    public static final String MODID = "examplemod";
    public static final String NAME = "SWTools";
    public static final String VERSION = "585";
    public static final String CLIENT_PROXY = "me.sergwest.swtools.proxy.ClientProxy";
    public static final String COMMON_PROXY = "me.sergwest.swtools.proxy.CommonProxy";
    
    @Instance
    public Main instance;
    
    @SidedProxy(clientSide = Main.CLIENT_PROXY, serverSide = Main.COMMON_PROXY)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(new Hud());
    	moduleManager = new ModuleManager();
    	hud = new Hud();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
    
    @SubscribeEvent
    public void key(KeyInputEvent e) {
    	if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
    		return;
    try {
    	if(Keyboard.isCreated()) {
    		if(Keyboard.getEventKeyState()) {
    			int keyCode = Keyboard.getEventKey();
    			if(keyCode<= 0)
    				return;
    			for(Module m : moduleManager.modules) {
    				if(m.getKey() == keyCode) {
    					m.Toggle();
    				}
    			}
    		}
    	}
    	} catch (Exception q) { q.printStackTrace(); } 
    }
}
