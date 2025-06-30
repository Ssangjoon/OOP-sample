import lotto.Lotto;
import lotto.LottoResult;
import lotto.LottoService;
import lotto.WinningRule;

import java.util.ArrayList;
import java.util.List;
import static lotto.Lotto.PRICE;

public class Main {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        int amount = LottoInput.receiveAmount();
        int numberOfGames = amount/PRICE;
        int numberOfManual = LottoInput.chooseMode(numberOfGames);

        List<Lotto> chosenLottos =  new ArrayList<>();
        if (numberOfManual > 0){
            chosenLottos = LottoInput.chooseLotto(numberOfManual);
        }

        int numberOfAuto = numberOfGames - numberOfManual;

        for(int i = 0; i < numberOfAuto; i++){
            Lotto lotto = new Lotto();
            chosenLottos.add(lotto);
        }

        LottoOutput.printChosenLotto(chosenLottos);

        Lotto winningLotto= LottoInput.receiveWinningNumber();

        List<WinningRule> lottoResults= LottoService.calculateRank(chosenLottos, winningLotto);
        LottoResult result = LottoService.getResult(lottoResults);
        double yieldRate= LottoService.getTotalYieldRate(result, amount);

        LottoOutput.printLottoResult(result, yieldRate);
    }
}