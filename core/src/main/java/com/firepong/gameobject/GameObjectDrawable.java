package com.firepong.gameobject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public interface GameObjectDrawable{

	public default void draw(SpriteBatch batch){

		// Local
		Body body = getBody();
		Sprite sprite = getSprite();

		// First we position and rotate the sprite correctly
		float posX = body.getPosition().x;
		float posY = body.getPosition().y;
		sprite.setPosition(posX, posY);

		// Then we simply draw it as a normal sprite.
		sprite.draw(batch);
	}

	public Sprite getSprite();

	public Body getBody();

}
