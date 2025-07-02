package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumTest {

    @Test
    @DisplayName("로또 번호 객체 생성 성공 테스트")
    void createLottoNum() {
        LottoNum num = new LottoNum(1);
        assertThat(num.getNum()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호 객체 생성 실패 테스트")
    void createLottoNum_withNumberGreaterThan45_thorwsException() {
        assertThatThrownBy(() -> new LottoNum(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 객체 생성 실패 테스트")
    void createLottoNum_withNumberLessThan1_thorwsException() {
        assertThatThrownBy(() -> new LottoNum(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}