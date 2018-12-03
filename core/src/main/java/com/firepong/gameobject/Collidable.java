package com.firepong.gameobject;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public interface Collidable<S extends Shape2D>{

	public void collidable(Rectangle rectangle);

	public void collidable(Circle circle);

	public void collidable(S shape);

	public S getShape();

}
