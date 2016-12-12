package entity;

import java.awt.Image;

import common.ConstantData;
import util.ImageUtil;

//�㶹��
public class SingleBulletPlant extends Plant {	//�ӵ�
    
	
    public SingleBulletPlant(){
    	shot = false;
    	plantImage = ImageUtil.loadImage("single_bullet_plant.gif");
    	bulletImage = ImageUtil.loadImage("bullet.gif");
    	offset = 0; 
    	times = 0;  //�ۼƻ��н�ʬ���ӵ���
    	//cdok = false;
    }
	public boolean getshot(){
		return shot;
	}
	public void setshot(boolean a){
		shot = a;
	}
	public Image getPlantImage(){
		//SeedCard d = ;
		
		return plantImage;
	}
	
	public Image getBulletImage(){
		return bulletImage;
	}
	//�жϲ��������
	public void doCollision(int bulletX,int bulletY,int zombieX,int zombieY){
		if(zombieX-bulletX>0&&zombieX-bulletX<10&&bulletY-zombieY<ConstantData.Normal_Zombie_HEIGHT){			
			System.out.println("Collision occure" + "\n");
			times++;		//����
		}
	}
	@Override
	public boolean getissun() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setissun(boolean a) {
		// TODO Auto-generated method stub
		issun  = a;
		//return false;
	}
	
}
