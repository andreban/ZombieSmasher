package com.mobplug.zombiesmasher.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mobplug.zombiesmasher.game.entities.GameObject;
import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameObjectManager {
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private Vector2D oldPosition = new Vector2D();
	
	public void addObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public void update(long gameTime) {
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject obj = gameObjects.get(i);
			//save old position
			oldPosition.set(obj.getPosition());
			
			//update object
			obj.update(gameTime);			
					
			if (obj.isDestroyed()) {
				gameObjects.remove(i);
				continue;
			}
			
			//test collision!
			boolean collided = checkCollision(obj, gameObjects);
			
			//if collided, reset movement!
			if (collided) {
				obj.getPosition().set(oldPosition);
			}		
		}		
	}
	
	public boolean checkCollision(GameObject obj, Collection<GameObject> gameObjects) {
		boolean collided = false;
		//force testing collision for all objects
		for (GameObject other: gameObjects) {
			collided |= obj.collidesWith(other);
		}
		return collided;
	}
	
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}
}
