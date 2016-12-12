package entity;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by asus on 2016/12/5.
 */
public class SeedCardTest {
    SeedCard seedCard;
    @Before
    public void setUp() throws Exception {
        Point point1 = new Point(0,0);
        Point point2 = new Point(2,0);
        seedCard = new SeedCard(point1,point2);
    }

    @Test
    public void mouseIn() throws Exception {
        assertTrue(seedCard.mouseIn(1,1));
        assertFalse(seedCard.mouseIn(0,0));

        //ºÚºÐ µÈ¼ÛÀà
        assertFalse(seedCard.mouseIn(0,1));
        assertTrue(seedCard.mouseIn(1,1));
        assertFalse(seedCard.mouseIn(51,1));
        assertFalse(seedCard.mouseIn(1,0));
        assertFalse(seedCard.mouseIn(1,71));
        assertFalse(seedCard.mouseIn(0,71));
        assertFalse(seedCard.mouseIn(0,0));
        assertFalse(seedCard.mouseIn(51,71));






    }

    @Test
    public void seedUpdate() throws Exception {
//        seedCard.seedUpdate(100);
        seedCard.seedUpdate(0);
//        seedCard.seedUpdate(-1);
    }

}