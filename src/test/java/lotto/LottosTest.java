package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("자동 로또 생성 테스트")
    public void randomGeneratorTest() {
        var g1 = new RandomLottoGenerator(1, new Random(42L));
        var g2 = new RandomLottoGenerator(1, new Random(42L));
        assertThat(g1.generate()).isEqualTo(g2.generate());
    }

    @Test
    @DisplayName("수동 로또 생성 테스트")
    public void manualGeneratorTest() {
        Lotto lotto = Lotto.manual(List.of(1,2,3,4,5,6));
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
}