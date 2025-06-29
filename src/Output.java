import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public static void printChosenLotto(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getLottoNumbers().stream()
                    .map(LottoNum::getNum)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(numbers);
        }
    }
}
