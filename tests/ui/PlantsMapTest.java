package ui;

import common.ConstantData;
import common.PlantType;
import entity.Plant;
import entity.SeedCard;
import entity.SunFlowerPlant;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by asus on 2016/12/5.
 */
public class PlantsMapTest  implements ConstantData {
    PlantsMap plantsMap = new PlantsMap();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void updateLocation() throws Exception {     //´ý²â
    //AnimateZombie animateZombie = new AnimateZombie(100,50,1);
//        flag[animateZombie.posX][animateZombie.posY]=1;
//        plantsMap.setTim(2);
//        plantsMap.updateLocation(animateZombie);
//        assertTrue(101==animateZombie.posX);
//        plantsMap.setTim(0);
//        plantsMap.updateLocation(animateZombie);
//       assertTrue(-10==animateZombie.posX);
        //ºÚºÐ
//        AnimateZombie animateZombie = new AnimateZombie(1,50,1);
//        flag[animateZombie.posX][animateZombie.posY]=1;
//        plantsMap.setTim(1);
           // plantsMap.setTim(0);
//        plantsMap.updateLocation(animateZombie);
//        assertTrue(2==animateZombie.posX);

        AnimateZombie animateZombie1 = new AnimateZombie(0,50,1);
        flag[animateZombie1.posX][animateZombie1.posY]=1;
        plantsMap.setTim(1);
        plantsMap.updateLocation(animateZombie1);
        assertTrue(-10==animateZombie1.posX);


//        AnimateZombie animateZombie2 = new AnimateZombie(0,50,1);
//        flag[animateZombie2.posX][animateZombie2.posY]=1;



    }

//    @Test
//    public void drawPlant() throws Exception {
//
//    }


    @Test
    public void inTheMap() throws Exception {   //32~761 82~572
        assertTrue(plantsMap.inTheMap(200,200));
        assertFalse(plantsMap.inTheMap(20,20));
        //
        assertFalse(plantsMap.inTheMap(32,200));
        assertTrue(plantsMap.inTheMap(33,200));
        assertFalse(plantsMap.inTheMap(761,200));
        assertTrue(plantsMap.inTheMap(760,200));

        assertFalse(plantsMap.inTheMap(33,82));
        assertTrue(plantsMap.inTheMap(33,83));
        assertFalse(plantsMap.inTheMap(33,572));
        assertTrue(plantsMap.inTheMap(33,571));



    }

    @Test
    public void putPlantInMap() throws Exception {

    }

    @Test
    public void isPutPlant() throws Exception {
       Plant p = new SunFlowerPlant();
       Plant a[][] = new Plant[5][9];
       a[1][1]=p;
        plantsMap.setPlantsMap(a);
        assertFalse(plantsMap.isPutPlant(113,180));
        assertTrue(plantsMap.isPutPlant(194,278));
    }

}