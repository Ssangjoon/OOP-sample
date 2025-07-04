package lotto;

import java.util.*;

public class LottoResult {
    private final Map<WinningRule, Integer> countByLottoRank;

    public LottoResult(List<WinningRule> results) {
        Map<WinningRule, Integer> resultCount= new EnumMap<>(WinningRule.class);

        for (WinningRule rule : WinningRule.values()) {
            resultCount.put(rule, 0);
        }

        for (WinningRule rule : results) {
            resultCount.put(rule, resultCount.get(rule) + 1);
        }

        this.countByLottoRank = resultCount;
    }

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


    public Map<WinningRule, Integer> getCountByLottoRank() {
        return countByLottoRank;
    }
}
