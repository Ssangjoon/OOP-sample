package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<WinningRule, Integer> countByLottoRank;

    public LottoResult(Map<WinningRule, Integer> countByLottoRank) {
        this.countByLottoRank = countByLottoRank;
    }

    public Map<WinningRule, Integer> getCountByLottoRank() {
        return countByLottoRank;
    }
}
