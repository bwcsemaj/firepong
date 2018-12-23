package com.firepong.driver.pong;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location: me.eperjesi.games.pong.Paddle
 * Description: //TODO: Write description
 */
public abstract class Paddle extends BodyTemplate{

	protected float width;
	protected float height;
	private float x;
	private float y;
	protected float paddleWidth;
	protected float paddleHeight;
	protected float moveVelocity;

	public Paddle(boolean player_, float width_, float height_){
		super();

		width = width_;
		height = height_;

		if(player_){
			x = width - (2 * paddleWidth) - 8;
		} else{
			x = 8;
		}
		y = height / 2;

		paddleWidth = 5f;
		paddleHeight = height / 8;

		moveVelocity = 200f;
	}

	@Override
	protected BodyDef getBodyDef(){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.KinematicBody;
		bodyDef.position.set(new Vector2(x, y));
		return bodyDef;
	}

	@Override
	protected void setShape(Body body_){
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(paddleWidth, paddleHeight);
		body_.createFixture(getFixtureDef(shape));
		shape.dispose();
	}

	public abstract void processMovement();
}