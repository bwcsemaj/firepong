package com.firepong.game;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class WorldRenderer implements Disposable{

	// Attributes
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);
	private Stage stage;
	private FitViewport viewport;

	// Start Constructors
	public WorldRenderer(WorldController worldController){
		this.worldController = worldController;
		init();
	}

	// End Constructors

	// Start Methods
	private void init(){
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH * Constants.PPM,
			Constants.VIEWPORT_HEIGHT * Constants.PPM);
		viewport = new FitViewport(800, 480, camera);
		// Stage
		stage = new Stage(viewport, batch);
		stage.setDebugAll(true);

		// camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		batch.setProjectionMatrix(camera.combined);
		// Set camera Position: X, Y, Z
		camera.update();

	}

	public void render(){
		stage.draw();
		debugRenderer.render(worldController.getWorld(), camera.combined);
		// batch.setProjectionMatrix(camera.combined, debugRenderer);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		worldController.update(Gdx.graphics.getDeltaTime());
		Arrays.asList(worldController.getCorners()).stream().forEach(corner -> {
			corner.draw(batch);
		});

		batch.end();
	}

	public void resize(int width, int height){
		viewport.update(width, height);
	}

	@Override
	public void dispose(){
		batch.dispose();
	}

	// End Methods

}
