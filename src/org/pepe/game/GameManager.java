package org.pepe.game;

import org.pepe.engine.AbstractGame;
import org.pepe.engine.GameContainer;
import org.pepe.engine.Renderer;
import org.pepe.engine.gfx.Image;
import org.pepe.engine.gfx.Light;


public class GameManager extends AbstractGame {
	
	public GameManager()
	{
	}
	
	@Override
	public void update(GameContainer gc, float dt) 
	{
	
	}

	@Override
	public void render(GameContainer gc, Renderer r) 
	{

	}

	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.setDrawFPS(true);
		gc.start();
	}
	
}
