package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(LottoGenerationStrategy strategy){
        lottos = strategy.generate();
    }

    private Lottos(Lottos manual, Lottos auto) {
        List<Lotto> combined = new ArrayList<>();
        combined.addAll(manual.lottos);
        combined.addAll(auto.lottos);
        this.lottos = combined;
    }

    public static Lottos from(LottoGenerationStrategy strategy){
        return new Lottos(strategy);
    }

    public static Lottos combine(Lottos manual, Lottos auto) {
        return new Lottos(manual, auto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
