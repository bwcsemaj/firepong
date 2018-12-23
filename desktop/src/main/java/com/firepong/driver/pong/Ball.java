package com.firepong.driver.pong;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;

/**
 * Author: Robert Eperjesi Date: 3/22/2015 Project: pong Location: me.eperjesi.games.pong.Ball
 * Description: //TODO: Write description
 */
public class Ball extends BodyTemplate{

	private float width;
	private float height;
	private float radius;

	public Ball(float width_, float height_){
		super();

		width = width_;
		height = height_;
		radius = 5f;
	}

	@Override
	protected BodyDef getBodyDef(){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(new Vector2(width / 2, height / 2));
		return bodyDef;
	}

	@Override
	protected void setShape(Body body_){
		CircleShape shape = new CircleShape();
		shape.setRadius(radius);
		body_.createFixture(getFixtureDef(shape));
		shape.dispose();
	}

	public void startPush(){
		if(bodyLocal != null){
			bodyLocal.setLinearVelocity(-1000f, 300f);
		}
	}

	public float getY(){
		return bodyLocal.getPosition().y;
	}

	// 0 if nothing
	// 1 if player won
	// 2 if enemy won
	public int checkWin(){
		if(bodyLocal.getPosition().x > width){
			return 2;
		} else if(bodyLocal.getPosition().x < 0){
			return 1;
		} else{
			return 0;
		}
	}

}