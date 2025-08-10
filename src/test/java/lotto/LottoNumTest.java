package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumTest {

    @ParameterizedTest
    @DisplayName("로또 숫자는 1~45 의 범위의 숫자 하나로 생성된다.")
    @ValueSource(ints = {1, 45})
    void createLottoNumberTest(int number) {
        LottoNum lottoNumber = LottoNum.of(number);

        assertThat(lottoNumber.getNum()).isEqualTo(number);
    }

    @ParameterizedTest
    @DisplayName("1~45 범위 밖에 있는 숫자로 로또 숫자를 만들면 IllegalArgumentException 이 발생한다.")
    @ValueSource(ints = {0, 46})
    void validationRangeTest(int outOfRangeNumber) {
        assertThatThrownBy(() -> LottoNum.of(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}