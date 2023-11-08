package lotto.dto;

import static lotto.exception.ExceptionMessage.ILLEGAL_NUMBER;

import lotto.domain.LottoNumber;

public class BonusNumberRequest {
    private LottoNumber bonusNumber;

    private BonusNumberRequest(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public BonusNumberRequest (String input) {
        int bonusNumber = stringToInt(input);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private static int stringToInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) { //그냥 엔터한 경우 null로 return되는데 이경우도 처리됨.
            throw new IllegalArgumentException(ILLEGAL_NUMBER.getMessage());
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
