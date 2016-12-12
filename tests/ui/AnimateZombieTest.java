package ui;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by asus on 2016/12/5.
 */
public class AnimateZombieTest {
    AnimateZombie animateZombie;
    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void updateLocation() throws Exception {

    }

    @Test
    public void isOffScreen() throws Exception {
        animateZombie = new AnimateZombie(-91,0,1);
        assertTrue(animateZombie.isOffScreen());

        animateZombie = new AnimateZombie(-90,0,1);
        assertFalse(animateZombie.isOffScreen());

    }

}