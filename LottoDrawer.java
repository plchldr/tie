package de.oddcode.alchemist;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDrawer {

    private int numDraws;

    private Set<Integer> balls;
    private int drawn = 0;

    public LottoDrawer(int numBalls, int numDraws) {
        if (numBalls < numDraws) {
            throw new IllegalArgumentException();
        }
        this.numDraws = numDraws;
        balls = IntStream.range(1, numBalls + 1).boxed().collect(Collectors.toSet());
    }

    public synchronized Integer draw() {
        if (drawn >= numDraws) {
            throw new UnsupportedOperationException();
        } else {
            drawn++;
        }
        Integer drawn = new Random().nextInt(balls.size());
        balls.remove(drawn);
        return drawn;
    }
}
