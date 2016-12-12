package entity;

import java.awt.Image;

import util.ImageUtil;

public class Grave extends Plant{

	@Override
	public Image getPlantImage() {
		plantImage = ImageUtil.loadImage("mubei.png");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getBulletImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doCollision(int bulletX, int bulletY, int zombieX, int zombieY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getshot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setshot(boolean a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getissun() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setissun(boolean a) {
		issun = a;
		// TODO Auto-generated method stub
		
	}

}
