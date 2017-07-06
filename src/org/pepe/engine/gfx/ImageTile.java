package org.pepe.engine.gfx;

public class ImageTile extends Image {

	int tWidth;
	int tHeight;
	
	public ImageTile(String path, int width, int height)
	{
		super(path);
		this.tWidth = width;
		this.tHeight = height;
	}

	public Image getTileImage(int tileX, int tileY)
	{
		int[] p = new int[tWidth * tHeight];
		
		for (int y = 0; y < tHeight; y++)
		{
			for(int x = 0; x < tWidth; x++)
			{
				p[x + y * tWidth] = this.getP()[(x + tileX * tWidth) + (y + tileY + tHeight) * this.getWidth()];
			}
		}
		
		return new Image(p, tWidth, tHeight);
	}
	
	public int getTileWidth() {
		return tWidth;
	}

	public void setTileWidth(int width) {
		this.tWidth = width;
	}

	public int getTileHeight() {
		return tHeight;
	}

	public void setTileHeight(int height) {
		this.tHeight = height;
	}
	
}
