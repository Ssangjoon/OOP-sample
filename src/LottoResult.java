import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoResult {
    private final int matchCount;
    private final boolean matchBonus;
    private final WinningRule winningRules;

    public LottoResult(int matchCount, boolean matchBonus, WinningRule winningRules) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningRules = winningRules;
    }

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

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public WinningRule getWinningRules() {
        return winningRules;
    }
}
