package ui;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import common.ConstantData;
import common.PlantType;
import entity.SeedCard;
import util.ImageUtil;

public class GamePlay extends JPanel implements MouseListener, MouseMotionListener, Runnable{	
	private static final long serialVersionUID = 1L;
	private PlantsBar plantBar;

	public PlantsMap getPlantMap() {
		return plantMap;
	}

	private PlantsMap plantMap;
	private Image grasslandImage;
	private Thread gameThread;
	private Graphics graphic;
	private Image gameImage=null;
	private long nowTime = 0;
    private long beginTime = 0;    
    int be; 
    private int mouseX;
    private int mouseY;
    private SeedCard[] cards;
   
	private PlantType selectedPlantType = null;
	
	public GamePlay(){
		//cards = new SeedCard[];
		super();		
		grasslandImage = ImageUtil.loadImage("background1.jpg");		
		plantBar = new PlantsBar();
		plantMap = new PlantsMap();
		selectedPlantType = PlantType.NONE;
		nowTime = System.currentTimeMillis();
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		gameThread = new Thread(this);
	}
	public void startGame(){
		gameThread.start();
	}
	public boolean doGameOver(){
		int j=0;
		for(int i=0;i<4;i++){		
    	    if(plantMap.animaZombieList.get(i)!=null&&plantMap.animaZombieList.get(i).isOffScreen()) {
    		     j=1;
    	    }
		}
		if(j==1){   return true;}
		else return false;
    	
    }
	public boolean doWin(){
		boolean j = true;
		for(int i =0 ;i<=15;i++){
			if(plantMap.animaZombieList.get(i)!=null){
				j = false;
				break;
			}
		}
		return j;
	}
	public void run(){	
		boolean tem;
		boolean te;
		while(true){
			if(be>=500){
				int yy = 0;
				for(int i=0;i<=15;i++){
					if(plantMap.animaZombieList.get(i)!=null)
						yy++;
				}
				plantBar.lights+=plantMap.co * 5+yy;
				be=0;
			}
			//����ֲ���б�״̬,�ݵ�״̬
			sceneUpdate();
			//��������,��ʾ����,��ʾֲ���б�,�ݵ�
			gameRender();
			paintScreen();
			tem = doGameOver();
			if(tem==true){
				Over();
			}
			te = doWin();
			if(te==true){
				Win();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
			}
			int j=20;
			while(j-->0){
				be++;
				sceneUpdate();
			}			
		}
		
	}
		public void Over(){
			JOptionPane.showMessageDialog(this, "��Ϸ��������ʧ���ˣ�"); 
			System.exit(0);
		}
		public void Win(){
			JOptionPane.showMessageDialog(this, "��ʬ���������ˣ���ʤ���ˣ�");
			System.exit(0);
		}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
	}
	
	//�������(λ�ñ仯�γɶ���Ч��)
	public void sceneUpdate(){
		plantBar.seedUpdate();
		//plantMap.updateLocation();
		//ʹ��ѭ������ÿ����ʬ��λ��
		//if(plantMap.animaZombieList.get(0)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(0));
		//if(plantMap.animaZombieList.get(1)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(1));
		//if(plantMap.animaZombieList.get(2)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(2));
		//if(plantMap.animaZombieList.get(3)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(3));
		for(int i=0;i<=15;i++)
		if(plantMap.animaZombieList.get(i)!=null)
			plantMap.updateLocation(plantMap.animaZombieList.get(i));


		//if(plantMap.animaZombieList.get(1)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(1));
	
	}
	
	//�������ϵ���Ϸ����
	public void gameRender(){
		if(gameImage == null){			
			gameImage = this.createImage(this.getWidth(),this.getHeight());  	//����panel��IMAGE����С������
			if(gameImage == null){
				System.out.println("gameImage is null");
		        return;
			}else{
				graphic = gameImage.getGraphics();                 //���һ��gameImage��Graphics�����ģ����ڻ�ͼ
			}			
			
		}
		//��ʾgameImage�ϵ�ͼ��
		graphic.drawImage(grasslandImage, 0, 0, getWidth(), getHeight(), ConstantData.LEFT_OFFSET, 0, ConstantData.LEFT_OFFSET + getWidth(), getHeight(), null);
		plantBar.draw(graphic);    //��ֲ���б�
		drawMoveImage(graphic);    //�������ƶ���ֲ��
		plantMap.drawPlant(graphic);
		beginTime = System.currentTimeMillis();
//		if(beginTime-nowTime>3000){			
//			if(plantMap.animaZombieList.get(0)!=null){
//				plantMap.drawZombie(graphic,plantMap.animaZombieList.get(0));
//				plantMap.animaZombieList.get(1).isVisible =1;
//			}			
//		}
//		if(beginTime-nowTime>3000){
//			if(plantMap.animaZombieList.get(1)!=null){
//				plantMap.drawZombie(graphic,plantMap.animaZombieList.get(1));
//				plantMap.animaZombieList.get(1).isVisible =1;
//			}
//		}
//		if(beginTime-nowTime>3000){
//			if(plantMap.animaZombieList.get(2)!=null){
//				plantMap.drawZombie(graphic,plantMap.animaZombieList.get(2));
//				plantMap.animaZombieList.get(2).isVisible =1;
//			}
//		}
//		if(beginTime-nowTime>3000){
//			if(plantMap.animaZombieList.get(3)!=null){
//				plantMap.drawZombie(graphic,plantMap.animaZombieList.get(3));
//				plantMap.animaZombieList.get(3).isVisible =1;
//			}
//		}
//		if(beginTime-nowTime>3000){
//			if(plantMap.animaZombieList.get(4)!=null){
//				plantMap.drawZombie(graphic,plantMap.animaZombieList.get(4));
//				plantMap.animaZombieList.get(4).isVisible =1;
//			}
//		}
		for(int i=0;i<=15;i++){
			if(beginTime-nowTime>3000){
				if(plantMap.animaZombieList.get(i)!=null){
					plantMap.drawZombie(graphic,plantMap.animaZombieList.get(i));
					plantMap.animaZombieList.get(i).isVisible =1;
				}
			}
		}
		//....�Ӵ��ӳٻ������н�ʬ����ѭ��
		
	}
	//������������ʾ����Ļ��
	public void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();           //���panel��Graphics�����ģ����ڻ�ͼ
			if(g!=null&&gameImage!=null){      
				g.drawImage(gameImage,0,0,null);   //����Ļ����ʾpanel��ͼ��
			}
		}catch(Exception e){
			System.out.println("Graphics error: " + e); 
		}		
	}
	
	private void drawMoveImage(Graphics g) {
		if (selectedPlantType != PlantType.NONE) {	
			int money = 0;
			int tem = 0;
			if(selectedPlantType == PlantType.SingleBullet){
				money = 100;
				tem = 1;
			}
			if(selectedPlantType == PlantType.SunFlower){
				money = 50;
				tem = 2;
			}
			if(plantBar.lights >= money && plantBar.getcd(tem) == 1){
			g.drawImage(selectedPlantType.getPlantImg(),mouseX-40 , mouseY -40, null);  //������ƶ���λ�û�����ѡֲ��
			}
			money  = 0;
		}
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	//��ֲ�������б������ڲ�ƺ���ƶ�ʱ�ĵ�������
	@Override
	public void mouseClicked(MouseEvent e) {
		int tem;
		int clickMouseX = e.getX();
		int clickMouseY = e.getY();		
		Point point = new Point(clickMouseX, clickMouseY);			
		//�ڲ�ƺ���ƶ���ѡֲ������뵥������Ӧ�ĸ�����
		if(selectedPlantType!=PlantType.NONE&&plantMap.inTheMap(clickMouseX, clickMouseY)&&plantMap.isPutPlant(clickMouseX, clickMouseY)){
			System.out.println(selectedPlantType);
			//System.out.println(plantBar.getcd(te));
			int money = 0;
			int te = 0;
			if(selectedPlantType == PlantType.SingleBullet){
				money = 100;
				te = 1;
			}
			if(selectedPlantType == PlantType.SunFlower){
				money = 50;
				te = 2;
			}
			//if(plantBar.getcd(te) == 1){
			if(plantBar.lights>=money)
			{
				tem = plantMap.putPlantInMap(selectedPlantType, clickMouseX, clickMouseY);
			
			//cards = new SeedCard[7];
			//SeedCard d = cards[tem];
			plantBar.setcd(te);
			plantBar.lights = plantBar.lights - money;
			}
			//System.out.println(d.recd());
			//d.reset();
			//System.out.println(d.recd());
		}
		selectedPlantType = plantBar.selectedPlant(point);   //����ֲ���б��е�ĳ��ֲ��
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
