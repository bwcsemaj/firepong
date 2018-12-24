package com.firepong.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable{

	// Attributes
	private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);
	private GameController gameController;
	private OrthographicCamera camera;

	// Start Constructors
	public WorldRenderer(GameController gameController){
		this.gameController = gameController;
		init();
	}

	// End Constructors

	// Start Methods
	private void init(){
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.viewportHeight = 1000;
		camera.viewportWidth = 1000;
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
		camera.update();
	}

	public void render(){
		debugRenderer.render(gameController.getWorld(), camera.combined);
	}

	public void resize(int width, int height){

	}

	@Override
	public void dispose(){}

	// End Methods

}
