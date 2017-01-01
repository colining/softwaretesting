package ui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import util.ImageUtil;
import common.ConstantData;
import entity.Zombie;

public class AnimateZombie implements ConstantData  {			//僵尸的动画
	public Zombie zombieList=null;
	private int currentZombie;
	private int counter;	//像素位置
	private static final int FPS_PER_PIXEL = 10;	//
	public int posX,posY;
	public int isVisible;
	private int hp = 0;
	
	
	public AnimateZombie(int x,int y,int visible){		//
		zombieList = new Zombie(ImageUtil.loadImage("Zombie.gif"), (int) (0.5f * DEFAULT_FPS));
		currentZombie = 0;
		counter = 0;
		posX = x;
		posY = y;
		isVisible = visible;
		
	}
	public int doCollision(int bulletX,int bulletY,int zombieX,int zombieY,int a){
		//int gg = 0;
		//if(zombieX-bulletX>0&&zombieX-bulletX<10){//&&bulletY-zombieY<ConstantData.Normal_Zombie_HEIGHT){
			if (bulletX>zombieX){
		hp = hp + 1;
			//System.out.println(hp);
			return hp;
		}
		return 0;
	}
	
	//设置移动距离,改变其位置
	public void updateLocation(){		//不知道怎么测
		if(isOffScreen()){
			return;
		}
		counter++;
		if(counter>FPS_PER_PIXEL){
			posX-=1;
			counter = 0;
		}
	}
	
	//画出图像
	public void draw(Graphics g){
		if(isOffScreen()){
			return;
		}
		g.drawImage(zombieList.img, posX, posY, null);
	}
	
	
	//是否已移出屏幕
	public boolean isOffScreen(){
		if(posX+Normal_Zombie_WIDTH<0){
			return true;
		}
		return false ;
	}
}
