package entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by asus on 2016/12/5.
 */
public class ZombieTest {
    @Test
    public void doCollision() throws Exception {

        Zombie zombie = new Zombie();
        //白盒
        assertTrue(zombie.doCollision(100,200,110,70)==0);
       assertTrue(zombie.doCollision(100,200,105,80)==1);
        //黑盒
        assertTrue(zombie.doCollision(80,200,100,80)==0); //x差值<0
        assertTrue(zombie.doCollision(200,200,100,80)==0);  //大于10
       assertTrue(zombie.doCollision(100,200,105,80)==1);  //全部正确
        assertTrue(zombie.doCollision(100,200,105,20)==0);  //y差值大于130
        assertTrue(zombie.doCollision(80,200,100,20)==0);   // x<0,y>0
        assertTrue(zombie.doCollision(200,200,100,20)==0);

    }

}