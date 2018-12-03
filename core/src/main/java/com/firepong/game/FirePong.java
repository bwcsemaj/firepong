package com.firepong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;

public class FirePong extends ApplicationAdapter{
	SpriteBatch batch;
	Texture img;

	@Override
	public void create(){
		batch = new SpriteBatch();
		// img = new Texture("badlogic.jpg");
		Intersector.overlaps(null, null);
	}

	@Override
	public void render(){
		System.out.println("HELLO");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		// grehagaergeragreabatch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose(){
		batch.dispose();
		img.dispose();
	}
}
