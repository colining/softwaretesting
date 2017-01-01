package ui;

import common.PlantType;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by asus on 2016/12/5.
 */
public class PlantsBarTest {


    PlantsBar plantsBar;
    @Before
    public void setUp() throws Exception {
        plantsBar= new PlantsBar();
    }


    @Test
    public void selectedPlant() throws Exception {
        //�׺�
        //Point a = new Point(404,20);
        //Point a = new Point(100,20);
//        Point a = new Point(0,0);
//        assertTrue(plantsBar.selectedPlant(a)!=PlantType.NONE);
//        assertTrue(plantsBar.selectedPlant(a)==PlantType.NONE);
        //�ں�
        //��һ�ֵȼ��࣬���������һ��if������
       //Point b = new Point(1,1);
        //Point b = new Point(1000,1000);
        //assertTrue(plantsBar.selectedPlant(b)==PlantType.NONE);
        //�ڶ��ֵȼ��࣬�����һ��if������
        //Point b = new Point(200,10);
        //assertTrue(plantsBar.selectedPlant(a)!=PlantType.NONE);
        //�����ֵȼ��࣬����ĳ��ֲ������
        //Point singlebullet = new Point(94,10);
        Point singlebullet = new Point(95,10);
        assertTrue(plantsBar.selectedPlant(singlebullet)==PlantType.SingleBullet);
        //Point sunflower = new Point(146,10);
        Point sunflower = new Point(147,10);
        assertTrue(plantsBar.selectedPlant(sunflower)==PlantType.SunFlower);
        //Point cherry = new Point(198,10);
        Point cherry = new Point(199,10);
        assertTrue(plantsBar.selectedPlant(cherry)==PlantType.Cherry);
        //�˴�ʡ��һЩ��
        Point eat = new Point(406,10);
       // Point eat = new Point(407,10);
        assertTrue(plantsBar.selectedPlant(eat)==PlantType.Eat);
        //Point doublebulet = new Point(459,10);
       // assertTrue(plantsBar.selectedPlant(doublebulet)==PlantType.DoubBullet);






    }




}