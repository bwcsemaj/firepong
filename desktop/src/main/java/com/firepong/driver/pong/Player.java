package com.firepong.driver.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location: me.eperjesi.games.pong.Player
 * Description: //TODO: Write description
 */
public class Player extends Paddle{

	public Player(float width_, float height_){
		super(true, width_, height_);
	}

	@Override
	public void processMovement(){
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && bodyLocal.getPosition().y - paddleHeight > 0){
			bodyLocal.setLinearVelocity(0f, -moveVelocity);
		} else if(Gdx.input.isKeyPressed(Input.Keys.UP) && bodyLocal.getPosition().y + paddleHeight < height){
			bodyLocal.setLinearVelocity(0f, moveVelocity);
		} else{
			bodyLocal.setLinearVelocity(0f, 0f);
		}
	}
}