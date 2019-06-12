package de.oddcode.alchemist;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class CoinTosserTest {

    private static final int TOSS_NUM = 1000;

    @Test
    public void testTossCoin() {
        final var results = new HashMap<CoinTosser.Result, Integer>();
        for (int i = 0; i < TOSS_NUM; i++) {
            var result = new CoinTosser().tossCoin();
            results.put(result, results.getOrDefault(result, 0) + 1);
        }
        Assert.assertTrue(results.entrySet().size() > 1);
    }
}
