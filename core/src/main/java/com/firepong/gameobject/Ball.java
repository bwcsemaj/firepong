package com.firepong.gameobject;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.game.Constants;

import lombok.Getter;

public class Ball extends AbstractGameObject{

	// Attributes
	@Getter private Sprite sprite;

	// Start Constructors
	public Ball(World world, AssetManager assetManager, int x, int y){
		super(world, x, y);

		// Initialize Sprite
		// Texture ballTexture = assetManager.get("Ball.png", Texture.class);
		// sprite = new Sprite(ballTexture);
	}
	// End Constructors

	// Start Methods

	@Override
	protected void initBox2D(World world, int positionX, int positionY){

		// First we create a body definition
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to
		// StaticBody
		bodyDef.type = BodyType.DynamicBody;

		// Set our body's starting position in the world
		bodyDef.position.set(new Vector2(positionX, positionY));

		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(Constants.BALL_RADIUS);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit

		// Create our fixture and attach it to the body
		Fixture fixture = body.createFixture(fixtureDef);

		// Remember to dispose of any shapes after you're done with them!
		// BodyDef and FixtureDef don't need disposing, but shapes do.
		circle.dispose();

		setBody(body);
	}

	// End Methods
}
