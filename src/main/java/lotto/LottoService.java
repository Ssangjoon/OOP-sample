package lotto;

import java.util.*;

public class LottoService {
    public static List<WinningRule> calculateRank(List<Lotto> chosenLottos, Lotto winningLotto){
        List<WinningRule> results = new ArrayList<>();

        Set<LottoNum> winningLottoNumbers = winningLotto.getLottoNumbers();

        for (Lotto lotto : chosenLottos) {
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


    public static double getTotalYieldRate(LottoResult result, int amount) {
        double totalPrice = result.getCountByLottoRank().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return totalPrice / amount;
    }
}
