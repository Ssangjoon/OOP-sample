package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> numbersList) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> numbers:numbersList){
            Lotto lotto= new Lotto(numbers);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public Lottos(int numberOfAuto) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfAuto; i++){
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public Lottos(Lottos manual, Lottos auto) {
        List<Lotto> combined = new ArrayList<>();
        combined.addAll(manual.lottos);
        combined.addAll(auto.lottos);
        this.lottos = combined;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
