package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import common.ConstantData;
import common.PlantType;
import util.ImageUtil;

public class SeedCard implements ConstantData {
	
	private float percent;
	private static Image allSeed = ImageUtil.loadImage("allseeds.png");
	private static Image allSeedDark = ImageUtil.loadImage("allseeds_dark.png");
	
	private Point pos;				//����ֲ����             ע������
	private Point coord;			// ֲ�￨�����Ͻǵĵ㣬ע������
	//private boolean cdok = false;
	private PlantType plantType;
	private int[] cdok={0,0,0,0,0,0,0,0,0};
	
	public PlantType getPlantType() {
		return plantType;
	}

	private int freezingSeconds;			//ֲ��ˢ��ʱ��
	private int count;
	//private boolean cdok = false;
	
	public SeedCard(Point pos, Point coord) {
		this.pos = pos;
		this.coord = coord;
		plantType = seedMap[coord.y][coord.x];   //�õ���Ӧ��ֲ�����Ͷ���   
		percent = .5f;       //����ֲ���б�ˢ�µĽ���
		initFreezingTime(plantType);   //����ÿ��ֲ�ﲻ����ʱ��
		count = 0;
	}

	public int recd(){
		return count;
	}
	public int getcd(int i){
		return cdok[i];
	}
	public boolean mouseIn(int x, int y) {
		if ((x > pos.x) && (x < pos.x + CARD_WIDTH) && (y > pos.y) && (y < pos.y + CARD_HEIGHT) ) {
			return true;
		}
		System.out.print("lalalla");
		return false;
	}
	
	//����ֲ�ﶳ��ʱ��
	private void initFreezingTime(PlantType plantType) {
		freezingSeconds = 300;    //freezingSecondsԽ����ˢ��Խ��
		switch (plantType) {
		case SunFlower:
			freezingSeconds = 5;
			cdok[0] = 0;
			break;
		case SingleBullet:
			freezingSeconds = 10;
			cdok[1] = 0;
			break;
		case Cherry:
			freezingSeconds = 300;
			cdok[2] = 0;
			break;
		case SmallStone:
			freezingSeconds = 200;
			cdok[3] = 0;
			break;
		case Mine:
			freezingSeconds = 100;
			cdok[4] = 0;
			break;
		case ColdBullet:
			freezingSeconds = 150;
			cdok[5] = 0;
			break;
		case Eat:
			freezingSeconds = 300;
			cdok[6] = 0;
			break;
		case DoubBullet:
			freezingSeconds = 500;
			cdok[7] = 0;
			break;
		}
		
	}
	public void reset(int a) {
		count = 0;
		cdok[a] = 0;
	}
	
	//�����ӳ٣�����Ŀ���Դͼ����ʼ����Y�ĵ�����
	public void seedUpdate(int i) {
		if(cdok[i]==0)				//����·��һ������
		++count;
		percent = ((float)count) / (freezingSeconds * DEFAULT_FPS);
		//System.out.println("percent: "+percent); 
		if (count >= freezingSeconds * DEFAULT_FPS) {		//�������ͼƬȫ���Ϳ�����
			cdok[i] = 1;
			System.out.println(i);
			//count = 0;
		}
	}
	//public int topH=0;
	public void draw(Graphics g) {
		int picX = CARD_WIDTH * coord.x + CARD_GAP_W * coord.x;     //�õ�Դͼ����ʼ����X
		int picY = CARD_HEIGHT * coord.y + CARD_GAP_H * coord.y;    //�õ�Դͼ����ʼ����Y
		int topH = (int) (CARD_HEIGHT * percent);
		/*if(topH<CARD_HEIGHT)
		topH+=1;
		else
			topH=0;*/
		//System.out.println("topH: "+topH); 
		g.drawImage(allSeed,
	pos.x, pos.y, pos.x + CARD_WIDTH, pos.y + topH,
	picX, picY, picX + CARD_WIDTH, picY + topH, null);
		/*System.out.println("seed: "+ pos.x + " " + pos.y+ " " + (pos.x + CARD_WIDTH)+ " " + (pos.y + topH)+ " " +
				picX+ " " +picY+ " " + (picX + CARD_WIDTH)+ " " + (picY + topH)+"        "+percent);*/
		g.drawImage(allSeedDark,
	pos.x, pos.y + topH, pos.x + CARD_WIDTH, pos.y + CARD_HEIGHT,
	picX, picY + topH, picX+ CARD_WIDTH, picY + CARD_HEIGHT, null);
}
	
	
}
