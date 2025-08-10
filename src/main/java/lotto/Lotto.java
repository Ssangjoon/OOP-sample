package lotto;

import java.util.*;

public class Lotto {
    private final Set<LottoNum> lottoNumbers;
    public static final int LENGTH = 6;
    public static final int PRICE = 1_000;

    private Lotto(){
        lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LENGTH){
            LottoNum lottoNum = LottoNum.create();
            lottoNumbers.add(lottoNum);
        }
    }

    private Lotto(List<Integer> numbers) {
        Set<LottoNum>  lottoNumbers = new HashSet<>();

        validateLength(numbers);
        validateDuplicateNumber(numbers);

        for(int number : numbers){
            LottoNum lottoNum = LottoNum.of(number);
            lottoNumbers.add(lottoNum);
        }

        this.lottoNumbers = lottoNumbers;
    }

    private void validateDuplicateNumber(List<Integer> numbers){
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        validateLength(lottoNumbers);
    }

    private void validateLength(Collection<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 6자리 숫자로 이루어져야 합니다.");
        }
    }

    public static Lotto manual(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public static Lotto random(){
        return new Lotto();
    }

    public Set<LottoNum> getLottoNumbers() {
        return lottoNumbers;
    }

}
