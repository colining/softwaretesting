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
			//更新植物列表状态,草地状态
			sceneUpdate();
			//创建画布,显示画布,显示植物列表,草地
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
			JOptionPane.showMessageDialog(this, "游戏结束，您失败了！"); 
			System.exit(0);
		}
		public void Win(){
			JOptionPane.showMessageDialog(this, "僵尸都被消灭了，您胜利了！");
			System.exit(0);
		}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
	}
	
	//画面更新(位置变化形成动画效果)
	public void sceneUpdate(){
		plantBar.seedUpdate();
		//plantMap.updateLocation();
		//使用循环更新每个僵尸的位置
		//if(plantMap.animaZombieList.get(0)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(0));
		//if(plantMap.animaZombieList.get(1)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(1));
		//if(plantMap.animaZombieList.get(2)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(2));
		//if(plantMap.animaZombieList.get(3)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(3));
		for(int i=0;i<=15;i++)
		if(plantMap.animaZombieList.get(i)!=null)
			plantMap.updateLocation(plantMap.animaZombieList.get(i));


		//if(plantMap.animaZombieList.get(1)!=null)plantMap.updateLocation(plantMap.animaZombieList.get(1));
	
	}
	
	//画界面上的游戏内容
	public void gameRender(){
		if(gameImage == null){			
			gameImage = this.createImage(this.getWidth(),this.getHeight());  	//创建panel中IMAGE对象（小画布）
			if(gameImage == null){
				System.out.println("gameImage is null");
		        return;
			}else{
				graphic = gameImage.getGraphics();                 //获得一个gameImage的Graphics上下文，用于画图
			}			
			
		}
		//显示gameImage上的图像
		graphic.drawImage(grasslandImage, 0, 0, getWidth(), getHeight(), ConstantData.LEFT_OFFSET, 0, ConstantData.LEFT_OFFSET + getWidth(), getHeight(), null);
		plantBar.draw(graphic);    //画植物列表
		drawMoveImage(graphic);    //绘制所移动的植物
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
		//....加大延迟画出所有僵尸，用循环
		
	}
	//将界面内容显示于屏幕上
	public void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();           //获得panel的Graphics上下文，用于画图
			if(g!=null&&gameImage!=null){      
				g.drawImage(gameImage,0,0,null);   //在屏幕上显示panel的图像
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
			g.drawImage(selectedPlantType.getPlantImg(),mouseX-40 , mouseY -40, null);  //在鼠标移动的位置绘制所选植物
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
	
	//在植物种子列表单击和在草坪中移动时的单击处理
	@Override
	public void mouseClicked(MouseEvent e) {
		int tem;
		int clickMouseX = e.getX();
		int clickMouseY = e.getY();		
		Point point = new Point(clickMouseX, clickMouseY);			
		//在草坪中移动已选植物，并种入单击所对应的格子中
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
		selectedPlantType = plantBar.selectedPlant(point);   //单击植物列表中的某种植物
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
