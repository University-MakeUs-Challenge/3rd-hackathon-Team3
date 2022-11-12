package com.example.demo.src.card;

import com.example.demo.src.card.model.GetCardReq;
import com.example.demo.src.card.model.GetCardRes;
import com.example.demo.src.card.model.PatchCardReq;
import com.example.demo.src.card.model.PostCardReq;
import com.example.demo.src.card.model.PostCardRes;
import com.example.demo.src.user.model.GetUserRes;
import com.example.demo.src.user.model.PatchUserReq;
import com.example.demo.src.user.model.PostUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class CardDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 명함 생성 코드(Create)
     * */
    public PostCardRes createCard(List<String> cardUrlList, PostCardReq postCardReq) {
        String createCardQuery = "insert into card" +
                " (`name`, profile_img, intro, card_front_img, card_back_img," +
                "age, `group`, mbti, birth, extra_info, created_at," +
                "`status`, is_main, owner_idx, maker_idx) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // 실행될 동적 쿼리문

        Object[] createCardParams = new Object[]{
                postCardReq.getName(),
                postCardReq.getProfile_img(),
                postCardReq.getIntro(),
                cardUrlList.get(0),
                cardUrlList.get(1),
                postCardReq.getAge(),
                postCardReq.getGroup(),
                postCardReq.getMbti(),
                postCardReq.getBirth(),
                postCardReq.getExtra_info(),
                postCardReq.getCreated_at(),
                postCardReq.getStatus(),
                postCardReq.getIs_main(),
                postCardReq.getOwner_idx(),
                postCardReq.getMaker_idx()}; // 동적 쿼리의 ?부분에 주입될 값
        this.jdbcTemplate.update(createCardQuery, createCardParams);

        String lastInsertIdQuery = "select last_insert_id()"; // 가장 마지막에 삽입된(생성된) id값은 가져온다.
        int lastInsertId = this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
        System.out.println("여기봐");
        System.out.println(lastInsertId);

        String getCardInfoQuery = "select idx, card_front_img, card_back_img from card where idx=?;";
//        String getWalkInfoQuery = "select walkIdx, calorie, distance, pathImageUrl from Walk where walkIdx=? and status='ACTIVE';"
//        GetWalkInfo getWalkInfo = this.jdbcTemplate.queryForObject(getWalkInfoQuery,
//            (rs,rowNum) -> new GetWalkInfo(
//                rs.getInt("walkIdx"),
//                getWalkTime,
//                rs.getInt("calorie"),
//                rs.getDouble("distance"),
//                footCount,
//                rs.getString("pathImageUrl")), walkIdx);

        PostCardRes postCardRes = this.jdbcTemplate.queryForObject(getCardInfoQuery,
            (rs, rowNum) -> new PostCardRes(
                rs.getInt("idx"),
                rs.getString("card_front_img"),
                rs.getString("card_back_img")
            ), lastInsertId);

        return postCardRes; // 해당 쿼리문의 결과 마지막으로 삽인된 유저의 userIdx번호를 반환한다.
    }

    /**
     * Card 테이블에 존재하는 전체 명함들의 정보 조회
     * */
    public List<GetCardRes> getCards() {
        String getCardsQuery = "select * from card"; //Card 테이블에 존재하는 모든 명함들의 정보를 조회하는 쿼리
        return this.jdbcTemplate.query(getCardsQuery,
                (rs, rowNum) -> new GetCardRes(
                        rs.getString("name"),
                        rs.getString("profile_img"),
                        rs.getString("intro"),
                        rs.getString("card_front_img"),
                        rs.getString("card_back_img"),
                        rs.getInt("age"),
                        rs.getString("group"),
                        rs.getString("mbti"),
                        rs.getDate("birth"),
                        rs.getString("extra_info"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getString("status"),
                        rs.getInt("is_main"),
                        rs.getInt("owner_idx"),
                        rs.getInt("maker_idx")) // RowMapper(위의 링크 참조): 원하는 결과값 형태로 받기
        ); // 복수개의 회원정보들을 얻기 위해 jdbcTemplate 함수(Query, 객체 매핑 정보)의 결과 반환(동적쿼리가 아니므로 Parmas부분이 없음)
    }

    // 해당 cardId를 갖는 유저조회
    public GetCardRes getCard(int cardId) {
        String getCardQuery = "select * from card where idx = ?"; // 해당 idx를 만족하는 명함을 조회하는 쿼리문
        int getCardParams = cardId;
        return this.jdbcTemplate.queryForObject(getCardQuery,
                (rs, rowNum) -> new GetCardRes(
                        rs.getString("name"),
                        rs.getString("profile_img"),
                        rs.getString("intro"),
                        rs.getString("card_front_img"),
                        rs.getString("card_back_img"),
                        rs.getInt("age"),
                        rs.getString("group"),
                        rs.getString("mbti"),
                        rs.getDate("birth"),
                        rs.getString("extra_info"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getString("status"),
                        rs.getInt("is_main"),
                        rs.getInt("owner_idx"),
                        rs.getInt("maker_idx")), // RowMapper(위의 링크 참조): 원하는 결과값 형태로 받기
                getCardParams); // 한 개의 회원정보를 얻기 위한 jdbcTemplate 함수(Query, 객체 매핑 정보, Params)의 결과 반환
    }

    // 명함정보 변경
    public int updateCard(PatchCardReq patchCardReq) {
        String updateCardQuery = "update card set name = ?," +
                "profile_img = ?, intro = ?, card_frond_img = ?," +
                "card_back_img = ?, age = ?, group = ?, mbti = ?," +
                "birth = ?, extra_info = ?, updated_at = ?," +
                "status = ?, is_main = ? , ownder_idx = ?," +
                "macker_idx = ?, where idx = ? "; // 해당 idx를 만족하는 Card를 해당 내용으로 변경한다.
        Object[] updateCardParams = new Object[]{patchCardReq.getName(), patchCardReq.getProfile_img(),
                patchCardReq.getIntro(),patchCardReq.getCard_front_img(), patchCardReq.getCard_back_img(),
                patchCardReq.getAge(),patchCardReq.getGroup(),patchCardReq.getMbti(),patchCardReq.getBirth(),
                patchCardReq.getExtra_info(),patchCardReq.getUpdated_at(),patchCardReq.getStatus(),
                patchCardReq.getIs_main(),patchCardReq.getOwner_idx(),patchCardReq.getMaker_idx()}; // 주입될 값들(nickname, userIdx) 순

        return this.jdbcTemplate.update(updateCardQuery, updateCardParams); // 대응시켜 매핑시켜 쿼리 요청(생성했으면 1, 실패했으면 0)
    }

}
