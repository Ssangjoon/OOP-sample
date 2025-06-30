import java.util.Objects;
import java.util.Random;

public class LottoNum {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int num;

    public LottoNum(){
        Random random = new Random();
        this.num = random.nextInt(MAX_NUMBER);
    }
    public LottoNum(int num){
        if (num < MIN_NUMBER || num > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
        this.num = num;
    }

    public int getNum() {
        return num;
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
