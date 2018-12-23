package com.firepong.driver.pong;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location: me.eperjesi.games.pong.Enemy
 * Description: //TODO: Write description
 */
public class Enemy extends Paddle{

	private Ball ball;

	public Enemy(float width_, float height_, Ball ball_){
		super(false, width_, height_);
		ball = ball_;
	}

	@Override
	public void processMovement(){
		if(ball.getY() < bodyLocal.getPosition().y && bodyLocal.getPosition().y - paddleHeight > 0){
			bodyLocal.setLinearVelocity(0f, -moveVelocity);
		} else if(ball.getY() > bodyLocal.getPosition().y && bodyLocal.getPosition().y + paddleHeight < height){
			bodyLocal.setLinearVelocity(0f, moveVelocity);
		} else{
			bodyLocal.setLinearVelocity(0f, 0f);
		}
	}

}