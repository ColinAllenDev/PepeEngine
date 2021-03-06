package org.pepe.engine;

import org.pepe.engine.gfx.Color;

public class GameContainer implements Runnable {

	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Input input;
	private AbstractGame game;
	
	private boolean running = false;
	private final double UPDATE_CAP = 1.0 / 60.0;
	
	private int width = 640, height = 480;
	private float scale = 2f;
	private String title = "Pepe Engine v1.0";
	
	boolean drawFPS = false; 
	
	public GameContainer(AbstractGame game)
	{
		this.game = game;
	}

	public void start()
	{
		window = new Window(this);
		thread = new Thread(this);
		renderer = new Renderer(this);
		input = new Input(this);
		thread.run();
	}
	public void stop()
	{
		
	}
	
	public void run()
	{
		running = true;
		
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unproccessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while (running)
		{
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unproccessedTime += passedTime;
			frameTime += passedTime;
			
			while (unproccessedTime >= UPDATE_CAP)
			{
				unproccessedTime -= UPDATE_CAP;
				render = true;
				
				game.update(this, (float) UPDATE_CAP);

				input.update();
				
				if (frameTime >= 1.0)
				{
					frameTime = 0;
					fps = frames;
					frames = 0;
				}
			}
			
			if (render)
			{
				renderer.clear();
				game.render(this, renderer);
				renderer.process();
				if (drawFPS) renderer.drawText("FPS: " + fps, 0, 0, Color.WHITE);
				window.update();
				frames++;
			}
			else 
			{
				try 
				{
					Thread.sleep(1);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
		dispose();
	}
	
	public void dispose()
	{
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDrawFPS(boolean value)
	{
		this.drawFPS = value;
	}
	
	public Window getWindow() {
		return window;
	}

	public Input getInput() {
		return input;
	}
	
}
