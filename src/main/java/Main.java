import lotto.*;
import view.LottoInput;
import view.LottoOutput;


public class Main {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        int amount = LottoInput.receiveAmount();
        LottoCount lottoCount = LottoCount.countLotto(amount);

        Lottos manual = LottoInput.chooseLotto(lottoCount.getNumberOfManual());
        Lottos auto = new Lottos(lottoCount.getNumberOfAuto());
        Lottos lottos = new Lottos(manual, auto);

        LottoOutput.printChosenLotto(lottos);

        WinningLotto winningLotto= LottoInput.receiveWinningNumber();

        LottoResult result = new LottoResult(LottoService.calculateRank(lottos, winningLotto));
        double yieldRate= LottoService.getTotalYieldRate(result, amount);

        LottoOutput.printLottoResult(result, yieldRate);
    }
}