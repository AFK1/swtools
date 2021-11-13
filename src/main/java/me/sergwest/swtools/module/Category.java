package me.sergwest.swtools.module;

public enum Category {
	PACKET("Packet"), RENDER("Render"), FUN("Fun");

	private String name;
	private int moduleIndex;

	Category(String name) {
		this.name = name;
	}
}
