package com.firepong.game;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.firepong.gameobject.Ball;
import com.firepong.gameobject.Corner;
import com.firepong.gameobject.paddle.Paddle;

import lombok.Getter;

public class FirePong extends ApplicationAdapter{

	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private AssetManager assetManager;
	@Getter private World world;// Box2D
	@Getter private Corner[] corners;
	@Getter private Ball ball;
	@Getter private Paddle[] paddles;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);

	private boolean gameActive = false;

	static final float BOX_STEP = 1 / 60f;
	static final int BOX_VELOCITY_ITERATIONS = 6;
	static final int BOX_POSITION_ITERATIONS = 2;

	@Override
	public void create(){

		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.viewportHeight = 1000;
		camera.viewportWidth = 1000;
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
		camera.update();

		startGame();
	}

	private void startGame(){
		gameActive = true;

		world = new World(new Vector2(0, 0), true);

		// Corners
		int[][] points = new int[][] {{0, 0}, {Constants.VIEWPORT_WIDTH - Constants.CORNER_SIZE, 0},
			{0, Constants.VIEWPORT_HEIGHT - Constants.CORNER_SIZE},
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

	private void initAssetManager(){
		assetManager = new AssetManager();
		assetManager.load("Ball.png", Texture.class);
		assetManager.load("Square.png", Texture.class);
		assetManager.load("Square1.png", Texture.class);
		assetManager.load("Square2.png", Texture.class);
		assetManager.load("Square3.png", Texture.class);
		assetManager.load("Square4.png", Texture.class);
		assetManager.finishLoading();
	}

	@Override
	public void render(){

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update game world by the time that has passed
		worldController.update(Gdx.graphics.getDeltaTime());

		// Render game world to Screen
		worldRenderer.render();
	}

	@Override
	public void resize(int width, int height){
		worldRenderer.resize(width, height);
	}

	@Override
	public void dispose(){
		worldRenderer.dispose();
	}
}
