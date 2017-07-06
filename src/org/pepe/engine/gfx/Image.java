package org.pepe.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	private int width, height;
	private int[] p;
	private boolean alpha = false;
	private int lightBlock = Light.NONE;
	
	public Image(String path)
	{
		BufferedImage image = null;
		
		try 
		{
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		p = image.getRGB(0, 0, width, height, null, 0, width);
		
		image.flush();
	}
	
	public Image(int[] p, int w, int h)
	{
		this.p = p;
		this.width = w;
		this.height = h;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		this.width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		this.height = h;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public boolean isAlpha() {
		return alpha;
	}

	public void setAlpha(boolean alpha) {
		this.alpha = alpha;
	}

	public int getLightBlock() {
		return lightBlock;
	}

	public void setLightBlock(int lightBlock) {
		this.lightBlock = lightBlock;
	}
	
}
