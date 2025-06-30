import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        int amount = Input.receiveAmount();
        int numberOfGames = amount/1000;
        int numberOfManual = Input.chooseMode(numberOfGames);

        List<Lotto> chosenLottos =  new ArrayList<>();
        if (numberOfManual > 0){
            chosenLottos = Input.chooseLotto(numberOfManual);
        }

        int numberOfAuto = numberOfGames - numberOfManual;

        for(int i = 0; i < numberOfAuto; i++){
            Lotto lotto = new Lotto();
            chosenLottos.add(lotto);
        }

        Output.printChosenLotto(chosenLottos);

        Lotto winningLotto= Input.receiveWinningNumber();

        List<LottoResult> lottoResults= LottoResult.calculateRank(chosenLottos, winningLotto);
        Map<WinningRule, Integer> resultFormat = LottoResult.getResultFormat(lottoResults);

        double yieldRate= LottoResult.getTotalYieldRate(resultFormat, amount);
        Output.printLottoResult(resultFormat, yieldRate);
    }
}