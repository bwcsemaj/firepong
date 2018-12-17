package com.firepong.game;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.gameobject.Ball;
import com.firepong.gameobject.Corner;
import com.firepong.gameobject.Paddle;

import lombok.Getter;

public class WorldController{

	// Attributes
	private World world;// Box2D
	private AssetManager assetManager;

	@Getter private Corner[] corners;
	@Getter private Ball ball;
	@Getter private Paddle[] paddles;

	// Start Constructors
	public WorldController(AssetManager assetManager){
		this.assetManager = assetManager;

		// Initialize
		init();

	}
	// End Constructors

	// Start Methods
	private void init(){
		world = new World(new Vector2(0, 0), true);

		// Initialize game objects
		initGameObjects();
	}

	private void initGameObjects(){

		// Corners
		int[][] points = new int[][] {{0, 0}, {Constants.VIEWPORT_WIDTH - Constants.CORNER_SIZE, 0},
			{0, Constants.VIEWPORT_HEIGHT - Constants.CORNER_SIZE},
			{Constants.VIEWPORT_WIDTH - Constants.CORNER_SIZE,
				Constants.VIEWPORT_HEIGHT - Constants.CORNER_SIZE}};
		corners = new Corner[4];
		IntStream.range(0, 4).forEach(value -> {
			System.out.println(Arrays.toString(points[value]));

			Corner corner = new Corner(world, assetManager, points[value][0], points[value][1]);
			corners[value] = corner;
		});

		// Paddle

		// Ball
	}

	public void update(float deltaTime){
		world.step(deltaTime, 6, 2);
	}
	// End Methods
}
