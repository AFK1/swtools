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

    // Static manager for cheat modules.
	public static ModuleManager moduleManager;
    // Static hud object for cheat UI.
	public static Hud hud;

    // Mod id in load list.
    public static final String MODID = "swtools";
    // Name of the mod.
    public static final String NAME = "SWTools";
    // Vesrion.
    public static final String VERSION = "585";

    // TODO[KseandI]: What is it?
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

    // On key event?
    @SubscribeEvent
    public void key(KeyInputEvent e) {
        // If minecraft or player doesn't exist.
    	if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
    		return;

        try {
            // If keyboard "exists"?
            if(Keyboard.isCreated()) {
                // If key state isn't None.
                if(Keyboard.getEventKeyState()) {
                    // Get keycode.
                    int keyCode = Keyboard.getEventKey();
                    // If keyCode isn't in keycodes table.
                    if(keyCode<= 0)
                        return;
                    // Go through every module.
                    for(Module m : moduleManager.modules) {
                        // If module activaton key equals current keycode.
                        if(m.getKey() == keyCode) {
                            // Enable module.
                            m.Toggle();
                        }
                    }
                }
            }
        } catch (Exception q) { q.printStackTrace(); }
    }
}
