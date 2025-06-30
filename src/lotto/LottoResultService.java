package lotto;

import java.util.*;

public class LottoResultService {
    public static List<LottoResult> calculateRank(List<Lotto> chosenLottos, Lotto winningLotto){
        List<LottoResult> results = new ArrayList<>();

        Set<LottoNum> winningLottoNumbers = winningLotto.getLottoNumbers();

        for (Lotto lotto : chosenLottos) {
            Set<LottoNum> chosenLottoNumbers = lotto.getLottoNumbers();
            int matchCount = (int) chosenLottoNumbers.stream()
                    .filter(num -> winningLottoNumbers.contains(num))
                    .count();

            boolean matchBonus = chosenLottoNumbers.stream()
                    .anyMatch(num -> num.getNum() == winningLotto.getBonusNumber());

            WinningRule winningRule= WinningRule.of(matchCount, matchBonus);

            results.add(new LottoResult(matchCount, matchBonus, winningRule));
        }
        return results;
    }

    public static Map<WinningRule, Integer> getResultFormat(List<LottoResult> results){
        Map<WinningRule, Integer> resultCount= new EnumMap<>(WinningRule.class);

        // 1. 초기화 - 0 세팅
        for (WinningRule rule : WinningRule.values()) {
            resultCount.put(rule, 0);
        }

        for (LottoResult lottoResult : results) {
            WinningRule rule = lottoResult.getWinningRules();
            resultCount.put(rule, resultCount.get(rule) + 1);
        }

        return resultCount;
    }

    public static double getTotalYieldRate(Map<WinningRule, Integer> resultFormat, int amount) {
        double totalPrice = (double) resultFormat.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return totalPrice / amount;
    }
}
