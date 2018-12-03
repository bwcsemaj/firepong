package com.firepong.gameobject;

import java.util.List;

import com.badlogic.gdx.math.Shape2D;

public class CollisionManager{

	// Attributes
	private static CollisionManager instance;

	private List<Collidable> collidables;

	private void CheckCollisions(){
		for(int i = 0; i < collidables.size(); i++){
			for(int j = 0; j < collidables.size(); j++){
				collidables.get(j).getShape()collide(collidables.get(j));
			}
		}
	}

	// Start Constructors
	private CollisionManager(){}

	// End Constructors

	// Start Methods
	public static CollisionManager getInstance(){
		if(instance == null){
			instance = new CollisionManager();
		}

		return instance;
	}

	public <S extends Shape2D> void register(Collidable<S> collidable){

	}
	// End Methods

}
