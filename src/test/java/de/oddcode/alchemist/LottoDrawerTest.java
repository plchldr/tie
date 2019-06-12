package de.oddcode.alchemist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LottoDrawerTest {

    @Test
    public void testDraw() {
        var ballsNum = 49;
        var drawsNum = 6;
        var ld = new LottoDrawer(ballsNum, drawsNum);
        var balls = new HashSet<Integer>();
        for(int i=0;i<drawsNum;i++) {
            balls.add(ld.draw());
        }
        Assert.assertEquals(balls.size(), drawsNum);
    }

}
