package com.example.demo.src.friendUser;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.model.PatchUserReq;
import com.example.demo.utils.JwtService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.src.friendUser.model.*;

import java.util.List;

@RestController
@RequestMapping("/app/friend-users")

public class FriendUserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final FriendUserProvider friendUserProvider;
    @Autowired
    private final FriendUserService friendUserService;
    @Autowired
    private final JwtService jwtService;

    public FriendUserController(FriendUserProvider friendUserProvider, FriendUserService friendUserService, JwtService jwtService) {
        this.friendUserProvider = friendUserProvider;
        this.friendUserService = friendUserService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/add")
    public BaseResponse<PostFriendUserRes> createFriendUser(@RequestBody PostFriendUserReq postFriendUserReq) {
        try {
            PostFriendUserRes postFriendUserRes = friendUserService.createFriendUser(postFriendUserReq);
            return new BaseResponse<>(postFriendUserRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }


    @ResponseBody
    @GetMapping("/{ownerIdx}")
    public BaseResponse<List<GetFriendUserRes>> getFriendUsers(@PathVariable("ownerIdx") int idx) {
        try {
            List<GetFriendUserRes> getFriendUserRes = friendUserProvider.getFriendUserRes(idx);
            return new BaseResponse<>(getFriendUserRes);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @PatchMapping("/{friendUserIdx}")
    public BaseResponse<String> modifyFriendUser(@PathVariable("friendUserIdx") int friendUserIdx, @RequestBody PatchFriendUserReq friendUser) {
        try {
            PatchFriendUserReq patchFriendUserReq = new PatchFriendUserReq(friendUser.getIdx(), friendUser.getStatus());
            friendUserService.modifyFriendUser(patchFriendUserReq);

            String result = "친구가 삭제되었습니다.";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }

    }


}
