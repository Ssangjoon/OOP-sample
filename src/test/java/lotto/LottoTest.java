package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("Lotto는 LottoNum 6개로 구성된다.")
    public void createLottoNumbersTest() {
        Lotto lotto = Lotto.create();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("Lotto 가 서로 다른 6자리 숫자로 이루어지지 않으면 IllegalArgumentException 가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "1,1,2,3,4,5,7"})
    public void validationLottoNumbersTest(String notValidInput) {
        String[] split = notValidInput.split(",");
        List<Integer> numbers = Stream.of(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}