package view;

import lotto.*;

import java.util.List;
import java.util.stream.Collectors;

public class LottoOutput {
    public static void printChosenLotto(Lottos lottos){
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getLottoNumbers().stream()
                    .map(LottoNum::getNum)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(numbers);
        }
    }
    public static void printLottoResult(LottoResult result, Rate yieldRate){
        for(WinningRule rule :WinningRule.values()){
            String bonusText = rule.isMatchBonus() ? ", 보너스 볼 일치" : "";
            System.out.printf(
                "%d개 일치%s (%,d원) - %d개\n",
                rule.getMatchCount(),
                bonusText,
                rule.getPrice(),
                result.getCountByLottoRank().get(rule)
            );
        }
        System.out.printf("수익률: %d%%\n", (int)(yieldRate.getRate() * 100));
    }
}
