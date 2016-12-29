package common;

import java.awt.Image;


import util.ImageUtil;

public enum PlantType {
	NONE(null),
	SunFlower(ImageUtil.loadImage("sun_flower1.gif")),    //������PlantType�Ĺ��췽������ʱmoveImg��sun_flower1.png
	SingleBullet(ImageUtil.loadImage("single_bullet_plant.gif")),//������PlantType�Ĺ��췽������ʱmoveImg��single_bullet_plant.png
	Cherry(null),
	SmallStone(null),
	Mine(null),
	ColdBullet(null),
	Eat(null),
	DoubBullet(null);
	public int l;
	private Image plantImg;


	PlantType(Image plantImg) {
		this.plantImg = plantImg;
	}
	public Image getPlantImg() {
		return plantImg;
	}
	public int rel(){
		return l;
	}
	public void setl(int r){
		l = r;
	}

	
	
	
}
