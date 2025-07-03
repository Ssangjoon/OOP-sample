package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<LottoNum> lottoNumbers;
    public static final int LENGTH = 6;
    public static final int PRICE = 1_000;

    public Lotto(){
        lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LENGTH){
            LottoNum lottoNum = new LottoNum();
            lottoNumbers.add(lottoNum);
        }
    }

    public Lotto(List<Integer> numbers) {
        Set<LottoNum>  lottoNumbers = new HashSet<>();
        for(int number : numbers){
            LottoNum lottoNum = new LottoNum(number);
            lottoNumbers.add(lottoNum);
        }
        this.lottoNumbers = lottoNumbers;
    }


    public Set<LottoNum> getLottoNumbers() {
        return lottoNumbers;
    }

}
