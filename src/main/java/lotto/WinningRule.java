package lotto;

public enum WinningRule {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int price;

    WinningRule(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = prize;
    }

    public static WinningRule of(int matchCount, boolean matchBonus) {
        for (WinningRule rule : values()) {
            if (rule.matchCount == matchCount && rule.matchBonus == matchBonus) {
                return rule;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrice() {
        return price;
    }
}
