package com.firepong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirePong extends ApplicationAdapter{
	SpriteBatch spriteBatch;
	Texture img;

	OrthographicCamera camera;

	@Override
	public void create(){

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, height / width);
		spriteBatch = new SpriteBatch();

		// img = new Texture("badlogic.jpg");

	}

	@Override
	public void render(){
		System.out.println("HELLO");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		// grehagaergeragreabatch.draw(img, 0, 0);
		spriteBatch.end();
	}

	@Override
	public void dispose(){
		spriteBatch.dispose();
		img.dispose();
	}
}
