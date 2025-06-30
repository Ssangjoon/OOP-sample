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
    public static void printLottoResult(List<LottoResult> lottoResults){
        Map<WinningRule, Integer> resultCount= new EnumMap<>(WinningRule.class);

        // 1. 초기화 - 0 세팅
        for (WinningRule rule :WinningRule.values()) {
            resultCount.put(rule, 0);
        }

        // 2.
        for (LottoResult lottoResult : lottoResults) {
            WinningRule rule = lottoResult.getWinningRules();
            resultCount.put(rule, resultCount.get(rule) + 1);
        }

        for(WinningRule rule :WinningRule.values()){
            String bonusText = rule.isMatchBonus() ? ", 보너스 볼 일치" : "";
            System.out.printf(
                "%d개 일치%s (%,d원) - %d개\n",
                rule.getMatchCount(),
                bonusText,
                rule.getPrice(),
                resultCount.get(rule)
            );
        }
    }
}
