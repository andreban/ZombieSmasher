package com.mobplug.zombiesmasher.game;

import com.mobplug.games.framework.BaseGame;

public class ZombieSmasherGame extends BaseGame {
	private static final long serialVersionUID = 1L;
	private GameObjectManager gameObjectManager = new GameObjectManager();
	
	@Override
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(long gameTime) {		
		// TODO read controls
		
		// TODO update player
		
		gameObjectManager.update(gameTime);
		
		// TODO check for game over
	}

}