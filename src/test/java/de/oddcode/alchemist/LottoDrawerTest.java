package de.oddcode.alchemist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LottoDrawerTest {

    @Test
    public void testDraw() {
        var ballsNum = 49;
        var drawsNum = 6;
        var ld = new LottoDrawer(ballsNum, drawsNum);
        Set<Integer> balls = null;
        for(int i=0;i<drawsNum;i++) {
            balls = ld.draw();
        }
        Assert.assertEquals(balls.size(), drawsNum);
    }

}
