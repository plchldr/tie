package de.oddcode.alchemist;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Entity
public class LottoDrawer {

    @Id
    private Long id;

    private int numDraws;

    @ElementCollection
    private Set<Integer> remainingBalls;
    @ElementCollection
    private Set<Integer> drawnBalls;

    public LottoDrawer(int numBalls, int numDraws) {
        if (numBalls < numDraws) {
            throw new IllegalArgumentException();
        }
        this.numDraws = numDraws;
        remainingBalls = IntStream.range(1, numBalls + 1).boxed().collect(Collectors.toSet());
        drawnBalls = new HashSet<>();
    }

    public synchronized Set<Integer> draw() {
        if (remainingBalls.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Integer drawn = new Random().nextInt(remainingBalls.size());
        remainingBalls.remove(drawn);
        drawnBalls.add(drawn);
        return drawnBalls;
    }
}
