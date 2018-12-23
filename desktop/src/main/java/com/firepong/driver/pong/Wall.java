package com.firepong.driver.pong;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location: me.eperjesi.games.pong.Wall
 * Description: //TODO: Write description
 */
public class Wall extends BodyTemplate{

	private float x;
	private float y;
	private float width;
	private float height;
	private float wallHeight;

	public Wall(boolean bottom_, float width_, float height_){
		super();

		wallHeight = 2f;
		width = width_;
		height = height_;
		x = 0;

		if(bottom_){
			y = 0 - wallHeight / 2;
		} else{
			y = height + wallHeight / 2;
		}
	}

	@Override
	protected BodyDef getBodyDef(){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set(new Vector2(x, y));
		return bodyDef;
	}

	@Override
	protected void setShape(Body body_){
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width, wallHeight);
		body_.createFixture(shape, 1f);
		shape.dispose();
	}
}