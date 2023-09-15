package com.cocoa.service;

import com.cocoa.dto.*;

import java.util.List;
import java.util.Map;

public interface FriendService {
    List<FriendDTO> getList(FriendDTO dto);
    void save(FriendDTO friendDTO);
    boolean login(FriendDTO friendDTO);
    String myPage(FriendDTO friendDTO);

    List<StarDTO> star();

    LectureinfoDTO getlecturelist(LectureinfoDTO lectureinfoDTO);

    int emailCheck(String email);

    public String findEmail(FriendDTO friendDTO);

    void rePwd(FriendDTO friendDTO);

    boolean ckPwd(FriendDTO friendDTO);

    void deleteFriend(FriendDTO friendDTO);

    List<Map<String, Object>> getMyGoodList(String fEmail);

    GoodDTO getGood(String g_femail);

    int deleteGoodList(GoodDTO goodDTO);

    void deleteGood(GoodDTO goodDTO);

    List<PaymentDTO> getPaymentList();
    List<LectureBoxDTO> getLectureBox(String lf_code);
    void insertGood(GoodDTO goodDTO);

    void insertStar(StarDTO starDTO);

    List<AdminFriendDTO> getmemberlist();

    List<PaymentMypageDTO> paymentListInMypage();
}

