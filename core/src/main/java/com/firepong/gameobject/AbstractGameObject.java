package com.firepong.gameobject;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractGameObject implements GameObjectDrawable{

	// Attributes
	@Getter @Setter private Body body;

	// Start Constructors

	public AbstractGameObject(World world, float x, float y){}

	// End Constructors

	// Start Methods
	// End Methods

}
