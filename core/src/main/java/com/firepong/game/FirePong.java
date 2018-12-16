package com.firepong.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class FirePong extends ApplicationAdapter{

	private WorldController worldController;
	private WorldRenderer worldRenderer;

	@Override
	public void create(){

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Initialize
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);

	}

	@Override
	public void render(){

		// Update game world by the time that has passed
		worldController.update(Gdx.graphics.getDeltaTime());

		// Clear the screen
		Gdx.gl.glClearColor(255, 255, 255, 255);

		// Clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Render game world to Screen
		worldRenderer.render();
	}

	@Override
	public void resize(int width, int height){
		worldRenderer.resize(width, height);
	}

	@Override
	public void dispose(){
		worldRenderer.dispose();
	}
}
