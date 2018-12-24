package com.firepong.gameobject.paddle;

import com.firepong.game.WorldController;

public interface Movable{

	public void move(WorldController controller);

	public float getMoveVelocity();
}
