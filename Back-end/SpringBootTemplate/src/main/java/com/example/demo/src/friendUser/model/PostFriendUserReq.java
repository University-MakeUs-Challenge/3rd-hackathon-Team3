package com.example.demo.src.friendUser.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostFriendUserReq {
    private int ownerIdx;
    private int friendIdx;
}