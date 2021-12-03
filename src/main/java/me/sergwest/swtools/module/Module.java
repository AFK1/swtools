package me.sergwest.swtools.module;

// Cheat module.
public class Module {

	// Module short name.
	public String name;
	// Module description.
	public String description;
	// Module state variable.
	public boolean toggle;
	// Module activation key code.
	private int key;
	// Module category.
	private Category category;

	// Constructor.
	public Module(String name, String description, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.key = 0;
		this.category = category;
		this.toggle = false;
	}

	// Some properties.
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public Category getCategory() {
		return this.category;
	}
	public boolean getToggle() {
		return this.toggle;
	}
	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}
	public void Toggle() {
		this.toggle = !this.toggle;
	}
	public int getKey() {
		return this.key;
	}
	public void setKey(int key) {
		this.key = key;
	}
}
