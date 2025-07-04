package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

    }
}