package lotto;

import java.util.*;

public class Lotto {
    private final Set<LottoNum> lottoNumbers;
    public static final int LENGTH = 6;
    public static final int PRICE = 1_000;

    private Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateNumber(numbers);

        Set<LottoNum>  lottoNumbers = new HashSet<>();
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

    public Set<LottoNum> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
