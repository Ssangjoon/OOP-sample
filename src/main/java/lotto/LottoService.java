package lotto;

import java.util.*;

public class LottoService {
    public static List<WinningRule> calculateRank(Lottos lottos, WinningLotto winningLotto){
        List<WinningRule> results = new ArrayList<>();

        Set<LottoNum> winningLottoNumbers = winningLotto.getLotto().getLottoNumbers();

        for (Lotto lotto : lottos.getLottos()) {
            Set<LottoNum> chosenLottoNumbers = lotto.getLottoNumbers();
            int matchCount = (int) chosenLottoNumbers.stream()
                    .filter(winningLottoNumbers::contains)
                    .count();

            boolean matchBonus = chosenLottoNumbers.stream()
                    .anyMatch(num -> num.getNum() == winningLotto.getBonusNumber());

            WinningRule winningRule= WinningRule.of(matchCount, matchBonus);

            results.add(winningRule);
        }
        return results;
    }

}
