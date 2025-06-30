package lotto;

import java.util.*;

public class LottoResult {
    private final int matchCount;
    private final boolean matchBonus;
    private final WinningRule winningRules;

    public LottoResult(int matchCount, boolean matchBonus, WinningRule winningRules) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningRules = winningRules;
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
