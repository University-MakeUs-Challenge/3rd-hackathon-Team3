package com.example.demo.src.card;

import com.example.demo.config.BaseException;
import com.example.demo.src.card.model.GetCardReq;
import com.example.demo.src.card.model.GetCardRes;
import com.example.demo.src.card.model.PatchCardReq;
import com.example.demo.src.card.model.PostCardRes;
import com.example.demo.utils.AES128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.example.demo.config.BaseResponseStatus.*;

@Service
public class CardService {

    private final CardDao cardDao;

    @Autowired
    public CardService(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    /**
     * 명함 생성
     * */
    public PostCardRes createCard(GetCardReq getCardReq) throws BaseException {
        try {
            int cardIdx = cardDao.createCard(getCardReq);
            return new PostCardRes(cardIdx);

        } catch (Exception exception) { // DB에 이상이 있는 경우 에러 메시지를 보냅니다.
            exception.printStackTrace();
            throw new BaseException(DATABASE_ERROR);
        }
    }
    /**
     * 명함 수정
     * */
    public void updateCard(PatchCardReq patchCardReq) throws BaseException {
        try {
            int result = cardDao.updateCard(patchCardReq); // 해당 과정이 무사히 수행되면 True(1), 그렇지 않으면 False(0)입니다.
            if (result == 0) { // result값이 0이면 과정이 실패한 것이므로 에러 메서지를 보냅니다.
                throw new BaseException(MODIFY_FAIL_USERNAME);
            }
        } catch (Exception exception) { // DB에 이상이 있는 경우 에러 메시지를 보냅니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
