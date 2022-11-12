package com.example.demo.src.friendUser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetFriendUserRes {
    private int owner_idx;
    private int friend_idx;
    private String status;
}
