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
        //白盒
        //Point a = new Point(404,20);
        //Point a = new Point(100,20);
//        Point a = new Point(0,0);
//        assertTrue(plantsBar.selectedPlant(a)!=PlantType.NONE);
//        assertTrue(plantsBar.selectedPlant(a)==PlantType.NONE);
        //黑盒
        //第一种等价类，即不满足第一个if条件，
       //Point b = new Point(1,1);
        //Point b = new Point(1000,1000);
        //assertTrue(plantsBar.selectedPlant(b)==PlantType.NONE);
        //第二种等价类，满足第一个if条件；
        //Point b = new Point(200,10);
        //assertTrue(plantsBar.selectedPlant(a)!=PlantType.NONE);
        //第三种等价类，满足某种植物类型
        //Point singlebullet = new Point(94,10);
        Point singlebullet = new Point(95,10);
        assertTrue(plantsBar.selectedPlant(singlebullet)==PlantType.SingleBullet);
        //Point sunflower = new Point(146,10);
        Point sunflower = new Point(147,10);
        assertTrue(plantsBar.selectedPlant(sunflower)==PlantType.SunFlower);
        //Point cherry = new Point(198,10);
        Point cherry = new Point(199,10);
        assertTrue(plantsBar.selectedPlant(cherry)==PlantType.Cherry);
        //此处省略一些。
        Point eat = new Point(406,10);
       // Point eat = new Point(407,10);
        assertTrue(plantsBar.selectedPlant(eat)==PlantType.Eat);
        //Point doublebulet = new Point(459,10);
       // assertTrue(plantsBar.selectedPlant(doublebulet)==PlantType.DoubBullet);






    }




}