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
        System.out.println("로또번호를 입력하세요.");
        List<Lotto> lottoList = new ArrayList<>();

        while (true){
            Set<LottoNum> chosenLotto = new HashSet<>();
            for(int i = 0; i < numberOfManual; i++){
                String chosenLottoStr = sc.nextLine();
                String[] chosenLottoArr= chosenLottoStr.split(NUMBER_SPLIT_DELIMITER);

                Arrays.stream(chosenLottoArr).forEach(lottoNumber -> {
                    int number = Integer.parseInt(lottoNumber);
                    LottoNum lottoNum= new LottoNum(number);
                    chosenLotto.add(lottoNum);
                });
            }
            if (chosenLotto.size() == 6){
                lottoList.add(new Lotto(chosenLotto));
                if(lottoList.size() == numberOfManual){
                    return lottoList;
                }
            } else  {
                System.out.println("로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

}
