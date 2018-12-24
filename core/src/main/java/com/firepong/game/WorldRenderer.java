package com.firepong.game;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable{

	// Attributes

	// Start Constructors
	public WorldRenderer(WorldController worldController){
		this.worldController = worldController;
		init();
	}

	// End Constructors

	// Start Methods
	private void init(){

	}

	public void render(){
		debugRenderer.render(worldController.getWorld(), camera.combined);
		// batch.setProjectionMatrix(camera.combined, debugRenderer);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
