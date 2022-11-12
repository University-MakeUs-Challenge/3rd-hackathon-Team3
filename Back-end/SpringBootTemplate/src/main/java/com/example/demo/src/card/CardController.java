package com.example.demo.src.card;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.card.model.*;

import com.example.demo.src.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private final CardProvider cardProvider;
    @Autowired
    private final CardService cardService;


    public CardController(CardProvider cardProvider, CardService cardService) {
        this.cardProvider = cardProvider;
        this.cardService = cardService;
    }

    /**
     * 명함 생성 API
     * [POST] /cards
     */
    // Body
    @ResponseBody
    @PostMapping("/register")    // POST 방식의 요청을 매핑하기 위한 어노테이션
    public BaseResponse<PostCardRes> createCard(@RequestBody GetCardReq getCardReq) {

        try {
            PostCardRes postCardRes = cardService.createCard(getCardReq);
            return new BaseResponse<>(postCardRes);
        } catch (BaseException exception) {
            exception.printStackTrace();
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 카드정보변경 API
     * [PATCH] /cards/:Idx
     */
    @ResponseBody
    @PatchMapping("/{idx}")
    public BaseResponse<String> updateCard(@PathVariable("idx") int idx, @RequestBody Card card) {
        try {
            PatchCardReq patchCardReq = new PatchCardReq(
                    card.getName(),
                    card.getProfile_img(),
                    card.getIntro(),
                    card.getCard_front_img(),
                    card.getCard_back_img(),
                    card.getAge(),
                    card.getGroup(),
                    card.getMbti(),
                    card.getBirth(),
                    card.getExtra_info(),
                    card.getUpdated_at(),
                    card.getStatus(),
                    card.getIs_main(),
                    card.getOwner_idx(),
                    card.getMaker_idx(),
                    idx);
            cardService.updateCard(patchCardReq);

            String result = "명함 정보가 수정되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            exception.printStackTrace();
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}
