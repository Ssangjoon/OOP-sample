package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerationStrategy {
    private final int numberOfAuto;

    public RandomLottoGenerator(int numberOfAuto) {
        this.numberOfAuto = numberOfAuto;
    }

    @Override
    public List<Lotto> generate() {
        return IntStream.range(0, numberOfAuto)
            .mapToObj(i -> Lotto.random())
            .collect(Collectors.toList());
    }
}
