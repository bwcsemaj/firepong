package com.firepong.game;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
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
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH * Constants.PPM,
			Constants.VIEWPORT_HEIGHT * Constants.PPM);
		// camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		batch.setProjectionMatrix(camera.combined);
		// Set camera Position: X, Y, Z
		camera.update();

	}

	public void render(){
		batch.begin();
		worldController.update(Gdx.graphics.getDeltaTime());
		Arrays.asList(worldController.getCorners()).stream().forEach(corner -> {
			corner.draw(batch);
		});

		batch.end();
	}

	public void resize(int width, int height){

	}

	@Override
	public void dispose(){
		batch.dispose();
	}

	// End Methods

}
