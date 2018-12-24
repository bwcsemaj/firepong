package com.firepong.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.gameobject.Ball;
import com.firepong.gameobject.Corner;
import com.firepong.gameobject.Goal;
import com.firepong.gameobject.paddle.Paddle;

import lombok.Getter;

public class GameController{

	// Attributes
	private AssetManager assetManager;
	@Getter private World world;
	@Getter private Map<CardinalDirection, Goal> directionToGoal;
	@Getter private Map<CardinalDirection, Paddle> directionToPaddle;

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

		// Paddles POSX, POXY : WIDTH, HEIGHT
		// NORTH VIEWPORT_WIDTH/2, 900 : PADDLE_BIG, PADDLE_SMALL
		directionToPaddle = new HashMap<>();
		for(CardinalDirection direction : CardinalDirection.values()){
			Paddle paddle = null;
			switch(direction){
				case EAST:
					new Paddle(world, CardinalDirection.EAST,
						Constants.VIEWPORT - Constants.PADDLE_SMALL - Constants.PADDLE_PADDING,
						(Constants.VIEWPORT / 2), Constants.PADDLE_SMALL, Constants.PADDLE_BIG);
					break;
				case NORTH:
					paddle = new Paddle(world, CardinalDirection.NORTH, (Constants.VIEWPORT / 2),
						Constants.VIEWPORT - Constants.PADDLE_SMALL - Constants.PADDLE_PADDING,
						Constants.PADDLE_BIG, Constants.PADDLE_SMALL);
					break;
				case SOUTH:// SOUTH VIEWPORT_WIDTH/2, 0 : PADDLE_BIG, PADDLE_SMALL
					paddle = new Paddle(world, CardinalDirection.SOUTH, (Constants.VIEWPORT / 2),
						Constants.PADDLE_PADDING + Constants.PADDLE_SMALL, Constants.PADDLE_BIG,
						Constants.PADDLE_SMALL);
					break;
				case WEST:// WEST 0, VIEWPORT_HEIGHT/2 : PADDLE_SMALL, PADDLE_BIG
					paddle =
						new Paddle(world, CardinalDirection.WEST, Constants.PADDLE_SMALL + Constants.PADDLE_PADDING,
							(Constants.VIEWPORT / 2), Constants.PADDLE_SMALL, Constants.PADDLE_BIG);
					break;
				default:
					break;
			}
			directionToPaddle.put(direction, paddle);
		}

		// Wall POSITION X, POSITION Y : WIDTH, HEIGHT
		directionToGoal = new HashMap<>();
		for(CardinalDirection direction : CardinalDirection.values()){
			Goal goal = null;
			Paddle paddle = directionToPaddle.get(direction);
			switch(direction){
				case EAST:
					goal = new Goal(Constants.VIEWPORT, Constants.CORNER_SIZE * 2, Constants.GOAL_SMALL,
						Constants.GOAL_BIG, paddle, world);
					break;
				case NORTH:
					goal = new Goal(Constants.CORNER_SIZE * 2, Constants.VIEWPORT, Constants.GOAL_BIG,
						Constants.GOAL_SMALL, paddle, world);
					break;
				case SOUTH:
					goal = new Goal(Constants.CORNER_SIZE * 2, 0, Constants.GOAL_BIG, Constants.GOAL_SMALL, paddle,
						world);
					break;
				case WEST:
					goal = new Goal(0, Constants.CORNER_SIZE * 2, Constants.GOAL_SMALL, Constants.GOAL_BIG, paddle,
						world);
					break;
				default:
					break;
			}
			directionToGoal.put(direction, goal);
		}

		// Ball
		ball = new Ball(world, assetManager, Constants.VIEWPORT / 2, Constants.VIEWPORT / 2);

	}

	public void update(float deltaTime){
		world.step(deltaTime, 6, 2);
		// Arrays.asList(paddles).stream().forEach(paddle -> {
		// paddle.move(this);
		// });
	}
	// End Methods
}
