package lotto;

import java.util.Objects;

public class LottoNum {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int num;

    private LottoNum(int num){
        if (num < MIN_NUMBER || num > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static LottoNum of(int num){
        return new LottoNum(num);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }
}
