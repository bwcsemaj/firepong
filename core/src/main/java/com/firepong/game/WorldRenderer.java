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
	}

	// End Constructors

	// Start Methods
	private void init(){

	}

	public void render(){

	}

	public void resize(int width, int height){

	}

	@Override
	public void dispose(){
		// TODO Auto-generated method stub

	}

	// End Methods

}
