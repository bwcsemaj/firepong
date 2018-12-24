package com.firepong.driver;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.firepong.game.FirePong;

public class FirePongDriver{

	public static void main(String[] arg){
		System.out.println("Hello World");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1000;
		config.width = 1000;
		new LwjglApplication(new FirePong(), config);
	}

}
