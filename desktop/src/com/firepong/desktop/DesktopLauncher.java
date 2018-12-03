package com.firepong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.firepong.FirePong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.out.println("Hello World");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new FirePong(), config);
	}
}
