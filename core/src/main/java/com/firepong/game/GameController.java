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
			{Constants.VIEWPORT - Constants.CORNER_SIZE, Constants.CORNER_SIZE},
			{Constants.CORNER_SIZE, Constants.VIEWPORT - Constants.CORNER_SIZE},
			{Constants.VIEWPORT - Constants.CORNER_SIZE, Constants.VIEWPORT - Constants.CORNER_SIZE}};
		corners = new Corner[4];
		IntStream.range(0, 4).forEach(value -> {
			System.out.println(Arrays.toString(points[value]));
			Texture texture = new Texture("Square" + Integer.toString(value + 1) + ".png");
			Corner corner = new Corner(world, texture, assetManager, points[value][0], points[value][1]);
			corners[value] = corner;
		});

		// Wall POSITION X, POSITION Y : WIDTH, HEIGHT
		// NORTH VIEWPORT_WIDTH/2, 900: GOAL_BIG, GOAL_SMALL
		// SOUTH VIEWPORT_WIDTH/2, 0: GOAL_BIG, GOAL_SMALL
		// EAST 900, VIEWPORT_HEIGHT/2: GOAL_SMALL, GOAL_BIG
		// WEST 0, VIEWPORT_HEIGHT/2: GOAL_SMALL, GOAL_BIG

		// Ball

		// Paddles POSX, POXY : WIDTH, HEIGHT
		// NORTH VIEWPORT_WIDTH/2, 900 : PADDLE_BIG, PADDLE_SMALL
		// SOUTH VIEWPORT_WIDTH/2, 0 : PADDLE_BIG, PADDLE_SMALL
		// EAST 900, VIEWPORT_HEIGHT/2 : PADDLE_SMALL, PADDLE_BIG
		// WEST 0, VIEWPORT_HEIGHT/2 : PADDLE_SMALL, PADDLE_BIG
	}

	public void update(float deltaTime){
		world.step(deltaTime, 6, 2);
		// Arrays.asList(paddles).stream().forEach(paddle -> {
		// paddle.move(this);
		// });
	}
	// End Methods
}
