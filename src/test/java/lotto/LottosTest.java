package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("자동 로또 생성 테스트")
    public void randomGeneratorTest() {
        Lottos lottos = Lottos.from(new RandomLottoGenerator(5));
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("수동 로또 생성 테스트")
    public void manualGeneratorTest() {
        Lotto lotto = Lotto.manual(List.of(1,2,3,4,5,6));
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
}