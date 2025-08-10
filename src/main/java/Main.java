import lotto.*;
import view.LottoInput;
import view.LottoOutput;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        int amount = LottoInput.receiveAmount();
        LottoCount lottoCount = LottoCount.countLotto(amount);

        List<List<Integer>> chosenNumbers = LottoInput.chooseLotto(lottoCount.getNumberOfManual());

        Lottos manual = Lottos.from(new ManualLottoGenerator(chosenNumbers));
        Lottos auto = Lottos.from(new RandomLottoGenerator(lottoCount.getNumberOfAuto()));
        Lottos lottos = Lottos.combine(manual, auto);

        LottoOutput.printChosenLotto(lottos);

        WinningLotto winningLotto= LottoInput.receiveWinningNumber();

        LottoResult result = new LottoResult(LottoResult.calculateRank(lottos, winningLotto));
        Rate yieldRate = new Rate(result, amount);

        LottoOutput.printLottoResult(result, yieldRate);
    }
}