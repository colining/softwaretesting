package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ConstantData;
import common.PlantType;
import entity.Grave;
import entity.Plant;
import entity.SeedCard;
import entity.SingleBulletPlant;
import entity.SunFlowerPlant;
import entity.Zombie;
import entity.Grave;
import util.ImageUtil;


public class PlantsMap implements ConstantData {
	private Plant[][] plantsMap;
	private SeedCard[] cards;
	private int bulletX,bulletY;
	int tim=50;
	public int co = 0;
	//private AnimateZombie animaZombie;
	public List<AnimateZombie> animaZombieList;
	//public HashMap<Integer,AnimateZombie> animaZombieList_1;
		
	public PlantsMap() {
		plantsMap = new Plant[MAP_ROW][MAP_COL];
		
		//animaZombie = new AnimateZombie(740, 430);
		animaZombieList = new ArrayList<AnimateZombie>();
		for(int i =0 ;i<=15;i++){
			int seed = (int)(Math.random()*10000);
			seed = seed%5;
			seed = seed *100;
			System.out.println(seed);
			animaZombieList.add(new AnimateZombie(800 + i * 60, seed+30, 0));
		}
//		animaZombieList.add(new AnimateZombie(800, 30, 0));
//		animaZombieList.add(new AnimateZombie(800, 130, 0));
//		animaZombieList.add(new AnimateZombie(800, 230, 0));
//		animaZombieList.add(new AnimateZombie(800, 330, 0));
//		animaZombieList.add(new AnimateZombie(860, 330, 0));
//		animaZombieList.add(new AnimateZombie(860, 430, 0));
		
		bulletX=0;
		bulletY=0;	
	}
	
	public void updateLocation(AnimateZombie animaZombie) {
		animaZombie.updateLocation();
		if(animaZombie.posX>0&&flag[animaZombie.posX][animaZombie.posY]==1)
		{
            if(tim-->0){
			animaZombie.posX++;
			animaZombie.zombieList=new Zombie(ImageUtil.loadImage("ZombieAttack.gif"), (int) (0.5f * DEFAULT_FPS));
            }
            else
            {
            	animaZombie.posX-=10;
            	tim=100;
            	animaZombie.zombieList=new Zombie(ImageUtil.loadImage("Zombie.gif"), (int) (0.5f * DEFAULT_FPS));
            	flag[animaZombie.posX][animaZombie.posY]=0;
            	int a=(animaZombie.posY-30)/100;
            	int b = (animaZombie.posX+10-MAP_WEST_OFFSET)/MAP_RECT_WIDTH;
            	Plant p = plantsMap[a][b];
            	System.out.println( animaZombie.posX+"++" + animaZombie.posY);
            	p.isVisible = 1;
            	//plantsMap[a][b]=null;
            }
		}
	}
	
	/*public void updateLocation() {
		animaZombie.updateLocation();
	}*/
	//绘制所种植物
	public void drawPlant(Graphics g) {	
		co = 0;
		for (int i = 0; i < MAP_COL; ++i) {
			for (int j = 0; j < MAP_ROW; ++j) {
				int x = MAP_WEST_OFFSET + i * MAP_RECT_WIDTH;
				int y = MAP_TOP_OFFSET + j * MAP_RECT_HEIGHT;
				
				Plant p = plantsMap[j][i];
				int te = 0,gg,tt=0;
				te = j*100 + 30;
				if (p != null) {
					if(p.isVisible==1){
						 p = new Grave();
						 //plantsMap[j][i]=null;
						 //p = null;
						 flag[x][j*100+30]=0;
					}  
					else {
						p.isVisible = 0;
						flag[x][j*100+30]=1;
					}
					Image img = p.getPlantImage();
					Image bulletImg = p.getBulletImage();
					g.drawImage(img, x + 3, y + 3, null);
					if(p.offset<(MAP_WEST_OFFSET + MAP_COL * MAP_RECT_WIDTH)&&p.getshot()==true)//&&p.getshot()==false)
						p.offset = p.offset+10;
					else
						{
						p.setshot(true);
						p.offset = 0;
						}
					//System.out.println(bulletY);
						   //p.setshot(false);
					if(p.getissun()==false)
					g.drawImage(bulletImg,x + 55 + p.offset, y + 25, null);
					else co++;
					//g.drawImage(bulletImg,x + 55 + p.offset, y + 25, null);
					bulletX = x + 55 + p.offset;
					bulletY = y + 25;
					//当对应行的僵尸存在，且子弹与僵尸在Y方向距离小于一个僵尸高度，判断该僵尸已出现时是否被击中
					//if(animaZombieList.get(j)!=null){
					for(int t=0;t<=15;t++){
						if(animaZombieList.get(t)!=null){
						//System.out.println(j);
						int zombieY = animaZombieList.get(t).posY;
						int zombieX = animaZombieList.get(t).posX;
						System.out.println(zombieY);
						//bulletImg = null;
						if(bulletY-zombieY<ConstantData.Normal_Zombie_HEIGHT&&animaZombieList.get(t).isVisible==1&&animaZombieList.get(t).posY==te){
							//p.doCollision(bulletX, bulletY, zombieX, zombieY);
							gg = tt;
							if(p.getissun()==false)
							tt=animaZombieList.get(t).doCollision(bulletX, bulletY, zombieX, zombieY, t);
							if(gg<tt)
							{
								p.setshot(false);
							}
							//p.setshot(true);
							//g.drawImage(bulletImg,99999,99999, null);
							//bulletImg = null;
							//flag = 1;
							if(tt>6){
								animaZombieList.set(t, null); 
								//被子弹击中次数达到某个值，僵尸死亡
							}
							
						  }
						}
					}										
				}				
			}
		}	
	}
	//画出僵尸
	public void drawZombie(Graphics g,AnimateZombie animaZombie) {		
		animaZombie.draw(g);		    
	}

	//坐标是否在当前草坪范围内
	public boolean inTheMap(int posX, int posY) {
		if ((posX > MAP_WEST_OFFSET) 
				&& (posX < MAP_WEST_OFFSET + MAP_COL * MAP_RECT_WIDTH)
				&& (posY > MAP_TOP_OFFSET)
				&& (posY < MAP_TOP_OFFSET + MAP_ROW * MAP_RECT_HEIGHT)) {
			return true;
		}
		return false;
	}
	//将所选植物种入相应的草坪块中
	public int putPlantInMap(PlantType pt, int posX, int posY) {
		Plant p = null;
		int tem = 0;
		switch(pt) {
			case SunFlower:
				p = new SunFlowerPlant();
				break;
			case SingleBullet:
				p = new SingleBulletPlant();
				break;
		}
		//d.setcd();
		if (p != null) {
			int col = (posX - MAP_WEST_OFFSET) / MAP_RECT_WIDTH;   //得到列
			int row = (posY - MAP_TOP_OFFSET) / MAP_RECT_HEIGHT;   //得到行
			plantsMap[row][col] = p;
			
		}return tem;
	}
	public boolean isPutPlant(int posX,int posY){
		int col = (posX - MAP_WEST_OFFSET) / MAP_RECT_WIDTH;   //得到列
		int row = (posY - MAP_TOP_OFFSET) / MAP_RECT_HEIGHT;   //得到行
		if(plantsMap[row][col]==null) return true;
		else return false;
	}
}

