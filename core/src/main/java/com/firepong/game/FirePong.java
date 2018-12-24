package com.firepong.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class FirePong extends ApplicationAdapter{

	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private AssetManager assetManager;

	@Override
	public void create(){

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Initialize Assets
		initAssetManager();

		// Initialize
		worldController = new WorldController(assetManager);
		worldRenderer = new WorldRenderer(worldController);
		Gdx.graphics.setWindowedMode(1000, 1000);

	}

	private void initAssetManager(){
		assetManager = new AssetManager();
		assetManager.load("Ball.png", Texture.class);
		assetManager.load("Square.png", Texture.class);
		assetManager.load("Square1.png", Texture.class);
		assetManager.load("Square2.png", Texture.class);
		assetManager.load("Square3.png", Texture.class);
		assetManager.load("Square4.png", Texture.class);
		assetManager.finishLoading();
	}

	@Override
	public void render(){

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update game world by the time that has passed
		worldController.update(Gdx.graphics.getDeltaTime());

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
