package lotto;

import java.util.List;

@FunctionalInterface
public interface LottoGenerationStrategy {
    List<Lotto> generate();
}
