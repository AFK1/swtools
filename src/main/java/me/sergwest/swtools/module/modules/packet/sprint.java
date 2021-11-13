package me.sergwest.swtools.module.modules.packet;

import org.lwjgl.input.Keyboard;

import me.sergwest.swtools.module.Category;
import me.sergwest.swtools.module.Module;

public class sprint extends Module {
	
	public sprint() {
		super("Sprint", "run on 'w'", Category.PACKET);
		this.setKey(Keyboard.KEY_C);
	}
}
