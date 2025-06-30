public enum WinningRule {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
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
