package entity;

import java.awt.Image;

import common.ConstantData;

public class Zombie {					//½©Ê¬
	public Image img;
	//public int fps;
	private int hp;
	public Zombie(Image img, int fps) {			//½©Ê¬Í¼Æ¬³õÊ¼»¯
			super();
			this.img = img;
			//this.fps = fps;
	}

	public Zombie() {
	}

	public int doCollision(int bulletX,int bulletY,int zombieX,int zombieY){		//Åö×²
		if(zombieX-bulletX>0&&zombieX-bulletX<10&&bulletY-zombieY<ConstantData.Normal_Zombie_HEIGHT){//130
			System.out.println("Collision occure" + "\n");
			System.out.println(hp+"hp");
			hp=hp+1;
			return 1;
		}
		return 0;
	}
		
	
}
