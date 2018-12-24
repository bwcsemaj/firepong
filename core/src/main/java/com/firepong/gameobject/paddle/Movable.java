package com.firepong.gameobject.paddle;

import com.firepong.game.GameController;

public interface Movable{

	public void move(GameController controller);

	public float getMoveVelocity();
}
