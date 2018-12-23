package com.firepong.driver.pong;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location:
 * me.eperjesi.games.pong.BodyTemplate Description: //TODO: Write description
 */
public abstract class BodyTemplate{

	private float density;
	private float friction;
	private float restitution;
	protected Body bodyLocal;

	public BodyTemplate(){
		density = 1f;
		friction = 0f;
		restitution = 1f;
		bodyLocal = null;
	}

	public Body createBody(World world_){
		Body body = world_.createBody(getBodyDef());
		setShape(body);
		bodyLocal = body;
		return body;
	}

	protected FixtureDef getFixtureDef(Shape shape_){
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape_;
		fixtureDef.density = density;
		fixtureDef.friction = friction;
		fixtureDef.restitution = restitution;
		return fixtureDef;
	}

	protected abstract BodyDef getBodyDef();

	protected abstract void setShape(Body body_);
}