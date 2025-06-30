import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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
    public static void printLottoResult(Map<WinningRule, Integer> resultFormat, double yieldRate){
        for(WinningRule rule :WinningRule.values()){
            String bonusText = rule.isMatchBonus() ? ", 보너스 볼 일치" : "";
            System.out.printf(
                "%d개 일치%s (%,d원) - %d개\n",
                rule.getMatchCount(),
                bonusText,
                rule.getPrice(),
                resultFormat.get(rule)
            );
        }
        System.out.printf("수익률: %d%%\n", (int)(yieldRate * 100));
    }
}
