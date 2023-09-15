package com.cocoa.mapper;

import com.cocoa.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FriendMapper {

	List<FriendDTO> getList(FriendDTO dto);

	void save(FriendDTO friendDTO);

	String login(FriendDTO friendDTO);

	List<StarDTO> star();

	LectureinfoDTO getlecturelist(LectureinfoDTO lectureinfoDTO);

	@Select("select COUNT(f_email) from friend where f_email=#{signUpFEmail}")
	int emailCheck(String fEmail);

	String findEmail(FriendDTO friendDTO);

	void rePwd(FriendDTO friendDTO);

	String ckPwd(FriendDTO friendDTO);

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
