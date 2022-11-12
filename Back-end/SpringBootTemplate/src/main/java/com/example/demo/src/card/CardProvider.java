package com.example.demo.src.card;

import com.example.demo.config.BaseException;
import com.example.demo.src.card.model.GetCardRes;
import com.example.demo.src.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class CardProvider {

    private final CardDao cardDao;

    @Autowired
    public CardProvider(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    // Card들의 정보를 조회 -> Card 리스트 반환
    public List<GetCardRes> getCards() throws BaseException {
        try {
            List<GetCardRes> getCardRes = cardDao.getCards();
            return getCardRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    // 해당 cardId를 갖는 card의 정보 조회
    public GetCardRes getCard(int cardId) throws BaseException {
        try {
            GetCardRes getCardRes = cardDao.getCard(cardId);
            return getCardRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
