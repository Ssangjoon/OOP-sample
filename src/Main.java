import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        int numberOfGames = Input.receiveAmount();
        int numberOfManual = Input.chooseMode(numberOfGames);

        List<Lotto> chooseLottos =  new ArrayList<>();
        if (numberOfManual > 0){
            chooseLottos = Input.chooseLotto(numberOfManual);
        }

        int numberOfAuto = numberOfGames - numberOfManual;

        for(int i = 0; i < numberOfAuto; i++){
            Lotto lotto = new Lotto();
            chooseLottos.add(lotto);
        }

        Output.printChosenLotto(chooseLottos);

        Lotto winningLotto= Input.receiveWinningNumber();


    }
}