import java.util.*;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NUMBER_SPLIT_DELIMITER = ",";

    public static int receiveAmount() {
        System.out.println("로또 구매를 위해 금액을 입력해주세요.");
        int amount = Integer.parseInt(sc.nextLine());
        return amount/1000;
    }

    public static int chooseMode(int numberOfGames){
        System.out.println("수동으로 진행할 게임 숫자를 입력해주세요. 총 게임 수 : " + numberOfGames);
        return Integer.parseInt(sc.nextLine());
    }

    public static List<Lotto> chooseLotto(int numberOfManual){
        List<Lotto> lottoList = new ArrayList<>();

        while (lottoList.size() < numberOfManual){
            System.out.println("로또 번호 6개를 ,로 구분하여 입력해주세요.");
            String line = sc.nextLine();
            String[] chosenLottoArr = line.split(NUMBER_SPLIT_DELIMITER);

            if(chosenLottoArr.length != 6) {
                System.out.println("6개의 숫자를 입력하세요");
                continue;
            }

            Set<LottoNum> chosenLotto = new HashSet<>();
            for(String chosenLottoStr : chosenLottoArr) {
                int num = Integer.parseInt(chosenLottoStr);
                chosenLotto.add(new LottoNum(num));
            }

            if (chosenLotto.size() != 6){
                System.out.println("로또 번호는 중복되지 않아야 합니다.");
                continue;
            }
            lottoList.add(new Lotto(chosenLotto));
        }
        return lottoList;
    }

}
