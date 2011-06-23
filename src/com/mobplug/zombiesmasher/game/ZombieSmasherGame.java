package com.mobplug.zombiesmasher.game;

import java.util.Collection;
import java.util.Random;

import android.graphics.PointF;

import com.mobplug.games.framework.BaseGame;
import com.mobplug.zombiesmasher.game.entities.Bullet;
import com.mobplug.zombiesmasher.game.entities.GameObject;
import com.mobplug.zombiesmasher.game.entities.Human;
import com.mobplug.zombiesmasher.game.entities.Player;

public class ZombieSmasherGame extends BaseGame {
	private static final long serialVersionUID = 1L;
	private GameObjectManager gameObjectManager = new GameObjectManager();	
	private InputManager inputManager;
	private Player player = new Player();	
	
	public ZombieSmasherGame(InputManager inputManager) {
		super();
		this.inputManager = inputManager;		
		init();
	}

	protected void init() {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {			
			GameObject obj = new Human(random.nextBoolean(), 0L);
			obj.getPosition().set((float)(Math.random() * 300), (float)(Math.random() * 300));
			obj.setCollistionRadius(10f);
			gameObjectManager.addObject(obj);			
		}

	}
	
	@Override
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(long gameTime) {				
		if (inputManager.isFirePressed()) {
			PointF point = inputManager.getFirePoint();
			Bullet bullet = player.fire(gameTime, point.x, point.y);
			inputManager.setFirePresset(false);
			gameObjectManager.addObject(bullet);
		}
		
		gameObjectManager.update(gameTime);
		
		// TODO check for game over
	}
	
	public Collection<GameObject> getGameObjects() {
		return gameObjectManager.getGameObjects();
	}

}
