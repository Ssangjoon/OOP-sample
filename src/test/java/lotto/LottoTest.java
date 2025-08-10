package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @DisplayName("Lotto 가 서로 다른 6자리 숫자로 이루어지지 않으면 IllegalArgumentException 가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "1,1,2,3,4,5,7"})
    public void validationLottoNumbersTest(String notValidInput) {
        String[] split = notValidInput.split(",");
        List<Integer> numbers = Stream.of(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.manual(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}