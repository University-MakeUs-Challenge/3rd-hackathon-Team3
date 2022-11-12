package com.example.demo.src.friendUser.model;



import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor

public class FriendUser {
    private int idx;
    private int ownerIdx;
    private int friendIdx;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
}
