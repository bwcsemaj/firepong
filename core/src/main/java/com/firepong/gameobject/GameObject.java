package com.firepong.gameobject;

import java.util.Optional;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject{

	// Attributes
	private final Vector2 position;

	// Start Constructors

	public GameObject(){

	}

	// End Constructors

	// Start Methods
	public Optional<String> calculateTemp(){
		return Optional.empty();
	}
	// End Methods

}
