package com.mobplug.zombiesmasher.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mobplug.zombiesmasher.game.entities.GameObject;
import com.mobplug.zombiesmasher.game.math2d.Vector2D;

public class GameObjectManager {
	public static final float BOARD_WIDTH = 1280f;
	public static final float BOARD_HEIGHT = 800f;
//	public static final int NUM_COLUMNS = 1280 / 32;
//	public static final int NUM_ROWS = 800 / 32;
	public static final float RATIO = BOARD_WIDTH / BOARD_HEIGHT;
	
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private Vector2D oldPosition = new Vector2D();
	
//	private List[][] objectsGrid = new List[NUM_COLUMNS][NUM_ROWS];
//	public GameObjectManager() {
//		for (int i = 0; i < NUM_COLUMNS; i++) {
//			for (int j = 0; j < NUM_ROWS; j++) {
//				objectsGrid[i][j] = new ArrayList<GameObject>();
//			}
//		}
//	}
	
	public void addObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
//	@SuppressWarnings("unchecked")
	public void update(long gameTime) {
//		for (int i = 0; i < NUM_COLUMNS; i++) {
//			for (int j = 0; j < NUM_ROWS; j++) {
//				objectsGrid[i][j].clear();
//			}
//		}
//		
//		for (int i = 0; i < gameObjects.size(); i++) {
//			GameObject obj = gameObjects.get(i);			
//			int column = (int)obj.getPosition().getX() / 32;
//			int row  = (int)obj.getPosition().getY() / 32;
//			objectsGrid[column][row].add(obj);			
//		}
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject obj = gameObjects.get(i);
			//save old position
			oldPosition.set(obj.getPosition());
			
			//update object
			obj.update(gameObjects, gameTime);			
					
			if (obj.isDestroyed()) {
				gameObjects.remove(i);
				continue;
			}
			
			//test collision!
			boolean collided = checkCollision(obj, gameObjects) || checkWallCollision(obj);
			
			//if collided, reset movement!
			if (collided) {
				obj.getPosition().set(oldPosition);
			}		
		}		
	}
	
	public boolean checkCollision(GameObject obj, Collection<GameObject> gameObjects) {
		boolean collided = false;
//		int objcol = (int)(obj.getPosition().getX() / 32);
//		int objrow = (int)(obj.getPosition().getY() / 32);
//		int startcol = objcol == 0 ? 0 : objcol - 1;
//		int startrow = objrow == 0 ? 0 : objrow - 1;
//		int endcol = objcol == NUM_COLUMNS - 1 ? objcol : objcol + 1;
//		int endrow = objrow == NUM_ROWS - 1 ? objrow : objrow + 1;
//		for (int i = startcol; i <= endcol; i++) {
//			for (int j = startrow; j <= endrow; j++) {
//				for (Object o: objectsGrid[i][j]) {
//					GameObject other = (GameObject)o;
//					collided = obj.collidesWith(other);
//				}
//			}
//		}
		//force testing collision for all objects
		for (GameObject other: gameObjects) {
			collided |= obj.collidesWith(other);
		}
		return collided;
	}
	
	public boolean checkWallCollision(GameObject obj) {
		if (obj.getPosition().getX() - obj.getCollisionRadius() < 0.0f
				|| obj.getPosition().getX() + obj.getCollisionRadius() > BOARD_WIDTH
				|| obj.getPosition().getY() - obj.getCollisionRadius() < 0.0f
				|| obj.getPosition().getY() + obj.getCollisionRadius()> BOARD_HEIGHT) {
			return true;
		}
		return false;
	}
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}
}
