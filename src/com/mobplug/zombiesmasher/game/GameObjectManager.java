package com.mobplug.zombiesmasher.game;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mobplug.zombiesmasher.game.entities.GameObject;

public class GameObjectManager {
	private Set<GameObject> gameObjects = new HashSet<GameObject>();
	
	public void addObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public void update(long gameTime) {
		for (GameObject obj: gameObjects) {
			//TODO Preview the Object update
			obj.update(gameTime);			
			
			boolean collided = checkCollision(obj, gameObjects);
			if (collided) {
				//TODO Revert to original position!
			}		
		}
		
		//Remove Destroyed Objects!
		Iterator<GameObject> it = gameObjects.iterator();
		while (it.hasNext()) {
			GameObject obj = it.next();
			if (obj.isDestroyed()) it.remove();
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
