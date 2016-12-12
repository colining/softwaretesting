package entity;

import java.awt.Image;
import util.ImageUtil;

//œÚ»’ø˚¿‡
public class SunFlowerPlant extends Plant {

    public SunFlowerPlant(){
    	plantImage = ImageUtil.loadImage("sun_flower1.gif");
    }
	
	public Image getPlantImage(){		
		return plantImage;
		
	}
	
	public Image getBulletImage(){
		return null;
	}
	
	public void doCollision(int bulletX,int bulletY,int zombieX,int zombieY){}

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
		// TODO Auto-generated method stub
		issun = a;	
	}
	
}
