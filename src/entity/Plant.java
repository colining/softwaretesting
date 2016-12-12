package entity;

import java.awt.Image;

public abstract class Plant {
	public Image plantImage;
	public Image bulletImage;
	public int offset;
	public int times;
	public boolean shot;
	public boolean issun;
	public int isVisible;
	//public boolean cdok;
	public abstract Image getPlantImage();
	public abstract Image getBulletImage();
	public abstract void doCollision(int bulletX,int bulletY,int zombieX,int zombieY);
	public abstract boolean getshot();
	public abstract void setshot(boolean a);
	public abstract boolean getissun();
	public abstract void setissun(boolean a);
}
