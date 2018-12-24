package com.firepong.game;

import com.badlogic.gdx.assets.AssetManager;

public class WorldController{

	// Attributes

	// Start Constructors
	public WorldController(AssetManager assetManager){
		this.assetManager = assetManager;

		// Initialize
		init();

	}
	// End Constructors

	// Start Methods
	private void init(){

		// Initialize game objects
		initGameObjects();
	}

	private void initGameObjects(){

		// Paddle

		// Ball
	}

	public void update(float deltaTime){
		world.step(deltaTime, 6, 2);
	}
	// End Methods
}
