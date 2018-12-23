package com.firepong.driver.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Pong extends ApplicationAdapter{

	private World world;
	private Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;

	private Ball ball;
	private Player player;
	private Enemy enemy;

	private boolean gameActive;

	static final float BOX_STEP = 1 / 60f;
	static final int BOX_VELOCITY_ITERATIONS = 6;
	static final int BOX_POSITION_ITERATIONS = 2;

	@Override
	public void create(){
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.viewportHeight = 320;
		camera.viewportWidth = 480;
		camera.position.set(camera.viewportWidth * 0.5f, camera.viewportHeight * 0.5f, 0f);
		camera.update();

		startGame();
	}

	@Override
	public void render(){
		if(!gameActive){
			startGame();
		}

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		debugRenderer.render(world, camera.combined);
		world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
		player.processMovement();
		enemy.processMovement();
		if(ball.checkWin() != 0){
			if(ball.checkWin() == 1){
				System.out.println("Player Wins!");
				gameActive = false;
			} else{
				System.out.println("Computer Wins!");
				gameActive = false;
			}
		}
	}

	private void startGame(){
		gameActive = true;

		world = new World(new Vector2(0, 0), true);

		new Wall(true, camera.viewportWidth, camera.viewportHeight).createBody(world);
		new Wall(false, camera.viewportWidth, camera.viewportHeight).createBody(world);

		ball = new Ball(camera.viewportWidth, camera.viewportHeight);
		ball.createBody(world);
		ball.startPush();

		player = new Player(camera.viewportWidth, camera.viewportHeight);
		player.createBody(world);

		enemy = new Enemy(camera.viewportWidth, camera.viewportHeight, ball);
		enemy.createBody(world);
	}
}