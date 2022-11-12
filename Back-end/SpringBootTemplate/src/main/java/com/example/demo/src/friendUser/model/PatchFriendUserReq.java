package com.example.demo.src.friendUser.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchFriendUserReq {
    private int idx;
    private String status;
}
