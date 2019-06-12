package de.oddcode.alchemist;

import java.util.Random;

public class CoinTosser {

    public enum Result {
        HEAD, TAIL, EDGE;
    }

    public Result tossCoin() {
        final int randomIndex = new Random().nextInt(Result.values().length);
        return Result.values()[randomIndex];
    }
}
