package com.example.demo.src.friendUser;

import com.example.demo.config.BaseException;
import com.example.demo.src.friendUser.model.FriendUser;
import com.example.demo.src.friendUser.model.PatchFriendUserReq;
import com.example.demo.src.friendUser.model.PostFriendUserReq;
import com.example.demo.src.friendUser.model.PostFriendUserRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@Service
public class FriendUserService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static List<FriendUser> friendUsers = new ArrayList<>();
    private final FriendUserDao friendUserDao;
    private final FriendUserProvider friendUserProvider;
    private final JwtService jwtService;

    @Autowired
    public FriendUserService(FriendUserDao friendUserDao, FriendUserProvider friendUserProvider, JwtService jwtService) {
        this.friendUserDao = friendUserDao;
        this.friendUserProvider = friendUserProvider;
        this.jwtService = jwtService;
    }

    public PostFriendUserRes createFriendUser(PostFriendUserReq postFriendUserReq) throws BaseException {
        try {
            int friendUserIdx = friendUserDao.createFriendUser(postFriendUserReq);
            return new PostFriendUserRes(friendUserIdx);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BaseException(DATABASE_ERROR);
        }
    }


    public void modifyFriendUser(PatchFriendUserReq patchFriendUserReq) throws BaseException {
        try {
            int result = friendUserDao.modifyFriendUser(patchFriendUserReq);
            if (result == 0) {
                throw new BaseException(DELETE_FAIL_FRIEND_USER);
            }
        } catch (Exception exception) {

            exception.printStackTrace();
            throw new BaseException(DATABASE_ERROR);
        }
    }
}