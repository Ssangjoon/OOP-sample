package lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final Set<LottoNum> lottoNumbers;
    private int bonusNumber;
    public static final int LENGTH = 6;
    public static final int PRICE = 1000;

    public Lotto(Set<LottoNum> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }
    public Lotto(){
        lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LENGTH){
            LottoNum lottoNum = new LottoNum();
            lottoNumbers.add(lottoNum);
        }
    }

    public Set<LottoNum> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
