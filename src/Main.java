import lotto.Lotto;
import lotto.LottoService;
import lotto.WinningRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<WinningRule, Integer> resultFormat = LottoService.getResultFormat(lottoResults);
        double yieldRate= LottoService.getTotalYieldRate(resultFormat, amount);

        LottoOutput.printLottoResult(resultFormat, yieldRate);
    }
}