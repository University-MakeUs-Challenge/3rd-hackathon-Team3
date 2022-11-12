package com.example.demo.src.friendUser;

import com.example.demo.src.friendUser.model.*;
import com.example.demo.src.friendUser.model.GetFriendUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FriendUserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int createFriendUser(PostFriendUserReq postFriendUserReq) {
        String createFriendUserQuery = "insert into friend_user (owner_idx, friend_idx) VALUES (?,?)";
        Object[] createFriendUserParams = new Object[]{postFriendUserReq.getOwnerIdx(), postFriendUserReq.getFriendIdx()};
        this.jdbcTemplate.update(createFriendUserQuery, createFriendUserParams);

        String lastInsertFriendIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertFriendIdQuery, int.class);
    }

    public List<GetFriendUserRes> getFriendUsers(int ownerIdx) {
        String getFriendUsersQuery = "select * from friend_user where owner_idx = ?";
        int getUserFriendUserParams = ownerIdx;

        return this.jdbcTemplate.query(getFriendUsersQuery, (rs, rowNum) -> new GetFriendUserRes(rs.getInt("owner_idx"), rs.getInt("friend_idx"), rs.getString("status")), getUserFriendUserParams);
    }

    public int modifyFriendUser(PatchFriendUserReq patchFriendUserReq) {
        String modifyFriendUserQuery = "update friend_user set status = 'INACTIVE' where idx = ?";
        Object[] modifyFriendUserParams = new Object[]{ patchFriendUserReq.getIdx()};

        return this.jdbcTemplate.update(modifyFriendUserQuery, modifyFriendUserParams);
    }

}