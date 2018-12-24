package com.firepong.gameobject.paddle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.game.CardinalDirection;
import com.firepong.game.GameController;

public class PlayerPaddle extends Paddle{

	// Attributes

	// Start Constructors
	public PlayerPaddle(World world, CardinalDirection cardinalDirection, Texture texture, int positionX,
		int positionY, int width, int height){
		super(world, cardinalDirection, texture, positionX, positionY, width, height);
	}
	// End Constructors

	// Start Methods
	@Override
	public void move(GameController controller){

	}
	// End Methods
}
