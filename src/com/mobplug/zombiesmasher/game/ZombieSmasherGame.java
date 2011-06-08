package com.mobplug.zombiesmasher.game;

import java.util.Collection;

import com.mobplug.games.framework.BaseGame;
import com.mobplug.zombiesmasher.game.entities.GameObject;

public class ZombieSmasherGame extends BaseGame {
	private static final long serialVersionUID = 1L;
	private GameObjectManager gameObjectManager = new GameObjectManager();	
	private InputManager inputManager;
	
	public ZombieSmasherGame(InputManager inputManager) {
		super();
		this.inputManager = inputManager;		
		init();
	}

	@Override
	protected void init() {
		super.init();
		GameObject obj = new GameObject();
		obj.getPosition().set(100f, 100f);
		obj.setCollistionRadius(10f);
		gameObjectManager.addObject(obj);
	}
	
	@Override
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(long gameTime) {		
		// TODO read controls
		
		if (inputManager.isFirePressed()) {

		}
		
		gameObjectManager.update(gameTime);
		
		// TODO check for game over
	}
	
	public Collection<GameObject> getGameObjects() {
		return gameObjectManager.getGameObjects();
	}

}
