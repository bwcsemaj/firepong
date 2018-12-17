package com.firepong.gameobject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.firepong.game.Constants;

public interface GameObjectDrawable{

	public default void draw(SpriteBatch batch){

		// Local
		Body body = getBody();
		Sprite sprite = getSprite();

		// First we position and rotate the sprite correctly
		float posX = body.getPosition().x * Constants.PPM;
		float posY = body.getPosition().y * Constants.PPM;
		sprite.setPosition(posX, posY);

		// Then we simply draw it as a normal sprite.
		sprite.draw(batch);
	}

	public Sprite getSprite();

	public Body getBody();

}
