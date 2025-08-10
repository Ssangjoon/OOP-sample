package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerationStrategy {
    private final int count;
    private final Random random;

    public RandomLottoGenerator(int count, Random random) {
        this.count = count;
        this.random = random;
    }

    @Override
    public List<Lotto> generate() {
        return IntStream.range(0, count)
            .mapToObj(i -> {
                List<Integer> bag = IntStream.rangeClosed(LottoNum.MIN_NUMBER, LottoNum.MAX_NUMBER).boxed().collect(Collectors.toList());
                Collections.shuffle(bag, random);              // 결정론적 셔플
                return Lotto.manual(bag.subList(0, Lotto.LENGTH));
            })
            .collect(Collectors.toList());
    }
}
