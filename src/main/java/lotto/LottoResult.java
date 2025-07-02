package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningRule, Integer> countByLottoRank;

    public LottoResult(List<WinningRule> results) {
        Map<WinningRule, Integer> resultCount= new EnumMap<>(WinningRule.class);

        // 1. 초기화 - 0 세팅
        for (WinningRule rule : WinningRule.values()) {
            resultCount.put(rule, 0);
        }

        for (WinningRule rule : results) {
            resultCount.put(rule, resultCount.get(rule) + 1);
        }

        this.countByLottoRank = resultCount;
    }


    public Map<WinningRule, Integer> getCountByLottoRank() {
        return countByLottoRank;
    }
}
