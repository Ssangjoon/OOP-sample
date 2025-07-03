package lotto;

import view.LottoInput;
import static lotto.Lotto.PRICE;

public class LottoCount {
    private final int numberOfManual;
    private final int numberOfAuto;

    public LottoCount(int numberOfManual, int numberOfAuto) {
        this.numberOfManual = numberOfManual;
        this.numberOfAuto = numberOfAuto;
    }

    public static LottoCount countLotto(int amount){
        int numberOfGames = amount/PRICE;
        int numberOfManual = LottoInput.chooseMode(numberOfGames);
        return new LottoCount(numberOfManual, numberOfGames - numberOfManual);
    }

    public int getNumberOfManual() {
        return numberOfManual;
    }

    public int getNumberOfAuto() {
        return numberOfAuto;
    }
}
