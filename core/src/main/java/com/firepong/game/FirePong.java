package com.firepong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import lombok.Getter;

public class FirePong extends ApplicationAdapter{

	private GameController gameController;
	private WorldRenderer worldRenderer;
	private AssetManager assetManager;
	@Getter private World world;// Box2D

	private OrthographicCamera camera;
	private SpriteBatch batch;

	private boolean gameActive = false;

	static final float BOX_STEP = 1 / 60f;
	static final int BOX_VELOCITY_ITERATIONS = 6;
	static final int BOX_POSITION_ITERATIONS = 2;

	@Override
	public void create(){

		// Assets
		initAssetManager();

		gameController = new GameController(assetManager);
		worldRenderer = new WorldRenderer(gameController);

		startGame();
	}

	private void startGame(){
		gameActive = true;

		// Create Game Controller / Objects
		gameController.init();

		// Move the ball
		// gameController.getBall().getBody().setLinearVelocity(new Vector2(1000, 100));

	}

	private void initAssetManager(){
		assetManager = new AssetManager();
		// assetManager.load("Ball.png", Texture.class);
		// assetManager.load("Square.png", Texture.class);
		// assetManager.load("Square1.png", Texture.class);
		// assetManager.load("Square2.png", Texture.class);
		// assetManager.load("Square3.png", Texture.class);
		// assetManager.load("Square4.png", Texture.class);
		assetManager.finishLoading();
	}

	@Override
	public void render(){

		if(!gameActive){
			startGame();
		}

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update game world by the time that has passed
		gameController.update(Gdx.graphics.getDeltaTime());

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
