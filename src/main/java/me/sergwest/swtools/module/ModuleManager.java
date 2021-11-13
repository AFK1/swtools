package me.sergwest.swtools.module;

import java.util.ArrayList;
import java.util.List;

import me.sergwest.swtools.Main;
import me.sergwest.swtools.module.modules.packet.sprint;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		//Packet
		this.modules.add(new sprint());
		//Fun
		
	}
	
	public Module getModule (String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList(){
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Main.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}
}
