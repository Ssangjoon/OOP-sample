package view;

import lotto.Lottos;
import lotto.WinningLotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LottoInput {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NUMBER_SPLIT_DELIMITER = ",";

    public static int receiveAmount() {
        System.out.println("로또 구매를 위해 금액을 입력해주세요.");
        return receiveNumber(amount -> amount > 0 && amount % 1000 == 0, "1000원 단위의 양수만 입력해주세요.");
    }

    public static int chooseMode(int numberOfGames){
        System.out.println("수동으로 진행할 게임 숫자를 입력해주세요. 총 게임 수 : " + numberOfGames);
        return receiveNumber(manual -> manual >= 0 && manual <= numberOfGames, "수동 게임 수는 0 이상이며 총 게임 수를 초과할 수 없습니다.");
    }

    public static Lottos chooseLotto(int numberOfManual){
        List<List<Integer>> chosenNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfManual; i++) {
            List<Integer> numbers = receiveNumber();
            chosenNumbers.add(numbers);
        }

        return new Lottos(chosenNumbers);
    }

    public static WinningLotto receiveWinningNumber(){
        System.out.println("당첨 로또번호를 입력하세요");
        List<Integer> lottoNumbers = receiveNumber();

        System.out.println("보너스 번호를 입력해주세요");
        int bonusNumber = Integer.parseInt(sc.nextLine());

        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private static List<Integer> receiveNumber(){
        String line = sc.nextLine();
        String[] receivedNumberArr= line.split(NUMBER_SPLIT_DELIMITER);

//        if(receivedNumberArr.length != LENGTH){
//            System.out.println(LENGTH + "개의 숫자를 입력하세요");
//        }

        return Arrays.stream(receivedNumberArr)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }


    private static int receiveNumber(Predicate<Integer> validator, String invalidMessage){
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (!validator.test(input)) {
                    System.out.println(invalidMessage);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 시도해주세요.");
            }
        }
    }
}
