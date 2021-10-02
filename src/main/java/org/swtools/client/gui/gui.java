package org.swtools.client.gui;

import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11.*;
import org.swtools.client.gui.thems.rect_button;


public class gui {
	rect_button[] mainbutton;
	File modulsdir = new File("src/main/java/org/client/modules");
	int ctmoduls = modulsdir.list().length;
	
	public gui() {
		String[] listmod = modulsdir.list();
		for(int x = 0; x < ctmoduls; x++) {
			mainbutton[x] = new rect_button();
		}
	}
	public void open() {
		for(int x = 0; x < ctmoduls; x++) {
			getFilledArcVertexes(0,0,20,0,360,0);
		}
	}
	public static float[] getFilledArcVertexes(float x, float y, float r, double startingAngleDeg, double endAngleDeg, int slices) {
        int radius = (int) r;

        double arcAngleLength = (endAngleDeg - startingAngleDeg) / 360f;

        float[] vertexes = new float[slices*6+6];

        double initAngle = Math.PI / 180f * startingAngleDeg;
        float prevXA = (float) Math.sin(initAngle) * radius;
        float prevYA = (float) Math.cos(initAngle) * radius;

        for(int arcIndex = 0; arcIndex < slices+1; arcIndex++) {
            double angle = Math.PI * 2 * ((float)arcIndex) / ((float)slices);
            angle += Math.PI / 180f;
            angle *= arcAngleLength;
            int index = arcIndex * 6;
            float xa = (float) Math.sin(angle) * radius;
            float ya = (float) Math.cos(angle) * radius;
            vertexes[index] = x;
            vertexes[index+1] = y;
            vertexes[index+2] = x+prevXA;
            vertexes[index+3] = y+prevYA;
            vertexes[index+4] = x+xa;
            vertexes[index+5] = y+ya;
            prevXA = xa;
            prevYA = ya;
        }

        return vertexes;
    }
	public void settings() {
	}
}