package com.firepong.gameobject.paddle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.game.CardinalDirection;
import com.firepong.game.Constants;
import com.firepong.gameobject.AbstractGameObject;

import lombok.Getter;

public abstract class Paddle extends AbstractGameObject implements Movable{

	// Attributes
	@Getter private Sprite sprite;
	@Getter final private CardinalDirection direction;
	@Getter private final float moveVelocity = 200;

	// Start Constructors
	public Paddle(World world, CardinalDirection direction, Texture texture, int positionX, int positionY){
		super(world, positionX, positionY);

		this.direction = direction;

		// Initialize Sprite
		sprite = new Sprite(texture);
	}
	// End Constructors

	// Start Methods

	@Override
	protected void initBox2D(World world, int positionX, int positionY){

		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to
		// StaticBody
		bodyDef.type = BodyType.KinematicBody;

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);
		body.getPosition().set(new Vector2(positionX, positionY));

		// Create shape of paddle
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
		fixtureDef.friction = 0f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit

		// Create our fixture and attach it to the body
		Fixture fixture = body.createFixture(fixtureDef);

		// Dispose shapes
		shape.dispose();

		setBody(body);
	}

	// End Methods
}