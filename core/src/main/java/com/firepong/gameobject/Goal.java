package com.firepong.gameobject;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.gameobject.paddle.Paddle;

import lombok.Getter;
import lombok.Setter;

public class Goal{

	// Attributes
	@Getter @Setter Body body;// box2d physics object
	Vector2 position;// pixel position
	int width;// in pixels
	int height;// in pixels
	Paddle paddle;// player paddle this goal corresponds to

	// Start Constructors
	public Goal(int xpos, int ypos, int width, int height, Paddle paddle, World world){

		this.position = new Vector2(xpos, ypos);
		this.width = width;
		this.height = height;
		this.paddle = paddle;

		initBox2D(world, (int) this.position.x, (int) this.position.y);

	}

	// End Constructors

	// Start Methods

	protected void initBox2D(World world, int positionX, int positionY){

		BodyDef bodyDef = new BodyDef();

		bodyDef.position.set(new Vector2(this.position.x, this.position.y));
		bodyDef.type = BodyType.StaticBody;

		Body body = world.createBody(bodyDef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(this.width, this.height);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
		fixtureDef.friction = 0f;
		fixtureDef.restitution = 0f;

		Fixture fixture = body.createFixture(fixtureDef);

		shape.dispose();

		setBody(body);

	}

	// End Methods

}
