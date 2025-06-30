import lotto.Lotto;
import lotto.LottoNum;

import java.util.*;
import static lotto.Lotto.LENGTH;

public class LottoInput {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NUMBER_SPLIT_DELIMITER = ",";

    public static int receiveAmount() {
        System.out.println("로또 구매를 위해 금액을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static int chooseMode(int numberOfGames){
        System.out.println("수동으로 진행할 게임 숫자를 입력해주세요. 총 게임 수 : " + numberOfGames);
        while (true){
            int numberOfManual= Integer.parseInt(sc.nextLine());
            if(numberOfManual > numberOfGames){
                System.out.println("선택하신 수동게임 개수가 총 게임수보다 많습니다.\n 다시 입력해주세요");
                continue;
            }
            return numberOfManual;
        }
    }

    public static List<Lotto> chooseLotto(int numberOfManual){
        List<Lotto> lottoList = new ArrayList<>();

        while (lottoList.size() < numberOfManual){
            System.out.println("로또 번호 6개를 ,로 구분하여 입력해주세요.");
            lottoList.add(receiveNumber());
        }
        return lottoList;
    }

    public static Lotto receiveWinningNumber(){
        System.out.println("당첨 로또번호를 입력하세요");
        Lotto winningLotto = receiveNumber();

        while(true){
            System.out.println("보너스 번호를 입력해주세요");
            int bonusNumber = Integer.parseInt(sc.nextLine());

            boolean isDuplicate = winningLotto.getLottoNumbers().stream().anyMatch(lottoNum ->  lottoNum.getNum() == bonusNumber);
            if(isDuplicate){
                System.out.println("보너스 번호는 기존 로또 당첨번호와 중복될 수 없습니다.");
                continue;
            }
            winningLotto.setBonusNumber(bonusNumber);
            break;
        }
        return winningLotto;
    }

    private static Lotto receiveNumber(){
        while (true){
            String line = sc.nextLine();
            String[] receivedNumberArr= line.split(NUMBER_SPLIT_DELIMITER);

            if(receivedNumberArr.length != LENGTH){
                System.out.println("6개의 숫자를 입력하세요");
                continue;
            }

            Set<LottoNum> chosenLotto = new HashSet<>();
            try{
                for(String chosenNumber : receivedNumberArr) {
                    int num = Integer.parseInt(chosenNumber);
                    chosenLotto.add(new LottoNum(num));
                }
            } catch(IllegalArgumentException e){
                System.out.println("입력값을 확인해주세요");
                continue;
            }

            if (chosenLotto.size() != LENGTH){
                System.out.println("로또 번호는 중복되지 않아야 합니다.");
                continue;
            }

            return new Lotto(chosenLotto);
        }
    }
}
