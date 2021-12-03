package me.sergwest.swtools.module;

/**
 * Modules category.
 * Seperates modules in columns.
 */
public enum Category {
	PACKET("Packet"), RENDER("Render"), FUN("Fun");

	// Category name.
	private String name;
	// Module unique index.
	private int moduleIndex;

	// TODO[KseandI]: Add list of modules.

	// Constructor with name.
	Category(String name) {
		this.name = name;
	}
}
