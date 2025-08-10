package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerationStrategy {
    private final List<List<Integer>> inputNumbers;

    public ManualLottoGenerator(List<List<Integer>> chosenNumbers) {
        this.inputNumbers = chosenNumbers;
    }

    @Override
    public List<Lotto> generate() {
        return inputNumbers.stream()
                .map(number -> Lotto.manual(number))
                .collect(Collectors.toList());
    }
}
