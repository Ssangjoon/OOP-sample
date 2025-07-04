package lotto;

public class Rate {
    private final double rate;

    public Rate(LottoResult result, int amount) {
        double totalPrice = result.getCountByLottoRank().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        this.rate = totalPrice / amount;
    }

    public double getRate() {
        return rate;
    }
}
