package me.sergwest.swtools.module;

public class Module {
	
	public String name, description;
	public boolean toggle;
	private int key;
	private Category category;

	public Module(String name, String description, Category category) {
		super();
		this.name = name;
		this.description = name;
		this.key = 0;
		this.category = category;
		this.toggle = false;
	}
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
