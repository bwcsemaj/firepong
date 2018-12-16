package com.firepong.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable{

	// Attributes
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;

	// Start Constructors
	public WorldRenderer(WorldController worldController){
		this.worldController = worldController;
		init();
	}

	// End Constructors

	// Start Methods
	private void init(){
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

		// Set camera Position: X, Y, Z
		camera.position.set(Constants.VIEWPORT_WIDTH / 2, Constants.VIEWPORT_HEIGHT / 2, 0);
		camera.update();

	}

	public void render(){

	}

	public void resize(int width, int height){
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.update();
	}

	@Override
	public void dispose(){
		batch.dispose();
	}

	// End Methods

}
