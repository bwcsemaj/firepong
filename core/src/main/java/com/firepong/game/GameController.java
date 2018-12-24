package com.firepong.game;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.gameobject.Ball;
import com.firepong.gameobject.Corner;
import com.firepong.gameobject.paddle.Paddle;

import lombok.Getter;

public class GameController{

	// Attributes
	private AssetManager assetManager;
	@Getter private World world;

	@Getter private Corner[] corners;
	@Getter private Ball ball;
	@Getter private Paddle[] paddles;

	// Start Constructors
	public GameController(AssetManager assetManager){
		this.assetManager = assetManager;

		// Initialize
		init();

	}
	// End Constructors

	// Start Methods
	public void init(){

		// Initialize game objects
		initGameObjects();
	}

	private void initGameObjects(){
		world = new World(new Vector2(0, 0), true);

		// Corners
		int[][] points = new int[][] {{Constants.CORNER_SIZE, Constants.CORNER_SIZE},
			{Constants.VIEWPORT_WIDTH - Constants.CORNER_SIZE, Constants.CORNER_SIZE},
			{Constants.CORNER_SIZE, Constants.VIEWPORT_HEIGHT - Constants.CORNER_SIZE},
			{Constants.VIEWPORT_WIDTH - Constants.CORNER_SIZE,
				Constants.VIEWPORT_HEIGHT - Constants.CORNER_SIZE}};
		corners = new Corner[4];
		IntStream.range(0, 4).forEach(value -> {
			System.out.println(Arrays.toString(points[value]));
			Texture texture = new Texture("Square" + Integer.toString(value + 1) + ".png");
			Corner corner = new Corner(world, texture, assetManager, points[value][0], points[value][1]);
			corners[value] = corner;
		});

		// Wall

		// Ball

		// Paddles
	}

	public void update(float deltaTime){
		world.step(deltaTime, 6, 2);
		// Arrays.asList(paddles).stream().forEach(paddle -> {
		// paddle.move(this);
		// });
	}
	// End Methods
}
