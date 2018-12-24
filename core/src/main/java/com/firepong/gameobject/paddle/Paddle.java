package com.firepong.gameobject.paddle;

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
import com.firepong.game.GameController;
import com.firepong.gameobject.AbstractGameObject;

import lombok.Getter;

public class Paddle extends AbstractGameObject implements Movable{

	// Attributes
	@Getter private Sprite sprite;
	@Getter final private CardinalDirection direction;
	// @Getter private final float moveVelocity = 200;
	@Getter private final int width;
	@Getter private final int height;

	// Start Constructors
	public Paddle(World world, CardinalDirection direction, int positionX, int positionY, int width,
		int height){
		super(world, positionX, positionY);
		this.width = width;
		this.height = height;
		this.direction = direction;

		initBox2D(world, positionX, positionY);

		// Initialize Sprite
		// sprite = new Sprite(texture);
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
		bodyDef.position.set(positionX, positionY);
		bodyDef.linearVelocity.set(new Vector2(0, 0));

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		// Create shape of paddle
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width, height);

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

	@Override
	public void move(GameController controller){
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public float getMoveVelocity(){
		// TODO Auto-generated method stub
		return 0;
	}

	// End Methods
}