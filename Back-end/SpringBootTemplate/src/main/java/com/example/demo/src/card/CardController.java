package com.example.demo.src.card;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.card.model.Card;
import com.example.demo.src.card.model.GetCardReq;
import com.example.demo.src.card.model.GetCardRes;
import com.example.demo.src.card.model.PatchCardReq;
import com.example.demo.src.card.model.PostCardReq;
import com.example.demo.src.card.model.PostCardRes;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import java.util.List;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Mul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * 명함 조회 API
     * [GET] /cards
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetCardRes>> getCards() {
        try {
            List<GetCardRes> getCardRes = cardProvider.getCards();

            return new BaseResponse<>(getCardRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @GetMapping("/{cardIdx}")
    public BaseResponse<GetCardRes> getCard(@PathVariable("cardIdx") int cardIdx) {
        try {
            GetCardRes getCardRes = cardProvider.getCard(cardIdx);
            return new BaseResponse<>(getCardRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 명함 생성 API
     * [POST] /cards
     */
    // Body
    @ResponseBody
    @PostMapping("/register")    // POST 방식의 요청을 매핑하기 위한 어노테이션
    public BaseResponse<PostCardRes> createUser(@RequestPart(value = "cards") List<MultipartFile> cards,
        @RequestPart(value = "dto") PostCardReq postCardReq) {

        try {
            PostCardRes postCardRes = cardService.createCard(cards, postCardReq);
            return new BaseResponse<>(postCardRes);
        } catch (BaseException exception) {
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
            PatchCardReq patchCardReq = new PatchCardReq(idx, card.getName(),
                    card.getProfile_img(),card.getIntro(),card.getCard_front_img(),
                    card.getCard_back_img(),card.getAge(),card.getGroup(),
                    card.getMbti(), card.getBirth(),card.getExtra_info(),
                    card.getUpdated_at(), card.getStatus(), card.getIs_main(),
                    card.getOwner_idx(), card.getMaker_idx());
            cardService.updateCard(patchCardReq);

            String result = "명함 정보가 수정되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}
