package com.example.demo.src.friendUser;


import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.friendUser.model.GetFriendUserRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class FriendUserProvider {
    private final FriendUserDao friendUserDao;
    private final JwtService jwtService;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public FriendUserProvider(FriendUserDao friendUserDao, JwtService jwtService) {
        this.friendUserDao = friendUserDao;
        this.jwtService = jwtService;
    }

    public List<GetFriendUserRes> getFriendUserRes(int ownerIdx) throws BaseException {
        try {
            List<GetFriendUserRes> getFriendUserRes = friendUserDao.getFriendUsers(ownerIdx);
            return getFriendUserRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}