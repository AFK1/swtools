package me.sergwest.swtools.module;

import java.util.ArrayList;
import java.util.List;

import me.sergwest.swtools.Main;
import me.sergwest.swtools.module.modules.packet.Sprint;

/**
 * Module manager.
 * Controls all modules.
 */
public class ModuleManager {

	// List of modules.
	public ArrayList<Module> modules;

	// Constructor.
	public ModuleManager() {
		// Array init.
		modules = new ArrayList<>();
		// Add sprint module
		this.modules.add(new Sprint());
		//Fun
		
	}

	/**
	 * Get module by name.
	 * @implNote case insensitive.
	 */
	public Module getModule (String name) {
		// Go through all modules
		for(Module m : this.modules) {
			// Find with name equals to required.
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}

	// Property
	public ArrayList<Module> getModuleList(){
		return this.modules;
	}

	// Get list of modules by category instance.
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<>();
		
		for(Module m : Main.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}
}
