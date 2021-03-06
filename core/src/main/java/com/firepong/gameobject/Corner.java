package com.firepong.gameobject;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.game.Constants;

import lombok.Getter;

public class Corner extends AbstractGameObject{

	// Attributes
	@Getter private Sprite sprite;

	// Start Constructors
	public Corner(World world, Texture texture, AssetManager assetManager, float x, float y){
		super(world, x, y);

		// Initialize Sprite
		sprite = new Sprite(texture);

		initBox2D(world, x, y);

	}
	// End Constructors

	// Start Methods

	private void initBox2D(World world, float positionX, float positionY){

		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to
		// StaticBody
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(positionX, positionY);

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		// Create shape of paddle
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(Constants.CORNER_SIZE, Constants.CORNER_SIZE);

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