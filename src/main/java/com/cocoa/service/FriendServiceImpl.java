package com.cocoa.service;

import java.util.List;
import java.util.Map;

import com.cocoa.dto.*;


import com.cocoa.mapper.FriendMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FriendService")
public class FriendServiceImpl implements FriendService{

	private final FriendMapper friendMapper;

	@Autowired
	public FriendServiceImpl (FriendMapper friendMapper) {
		this.friendMapper = friendMapper;
	}

	@Override
	public List<FriendDTO> getList(FriendDTO dto) {
		List<FriendDTO> friendList = friendMapper.getList(dto);
		return friendList;
	}

	@Override
	public void save(FriendDTO friendDTO) {
		friendMapper.save(friendDTO);
		System.out.println(friendDTO);
	}

	@Override
	public boolean login(FriendDTO friendDTO) {
		boolean flag = false;

		String result = friendMapper.login(friendDTO);

		if (result != null) {
			return true;
		}
		return flag;

	}
	@Override
	public String myPage(FriendDTO friendDTO) {
		return friendMapper.login(friendDTO);
	}

	@Override
	public List<StarDTO> star() {
		List<StarDTO> starList = friendMapper.star();
		System.out.println(starList);

		return starList;
	}

	@Override
	public int emailCheck(String fEmail) {
		int cnt = friendMapper.emailCheck(fEmail);
		System.out.println("cnt:" + cnt);

		return cnt;
	}

	@Override
	public String findEmail(FriendDTO friendDTO) {
		return friendMapper.findEmail(friendDTO);
	}

	@Override
	public void rePwd(FriendDTO friendDTO) {
		friendMapper.rePwd(friendDTO);
	}

	@Override
	public boolean ckPwd(FriendDTO friendDTO) {
		boolean check = false;

		String result = friendMapper.ckPwd(friendDTO);

		if (result != null) {
			return true;
		}
		return check;
	}

	@Override
	public void deleteFriend(FriendDTO friendDTO) {
		friendMapper.deleteFriend(friendDTO);
	}

	@Override
	public LectureinfoDTO getlecturelist(LectureinfoDTO lectureinfoDTO) {
		return friendMapper.getlecturelist(lectureinfoDTO);
	}

	@Override
	public List<Map<String, Object>> getMyGoodList(String fEmail) {
		return friendMapper.getMyGoodList(fEmail);
	}

	@Override
	public GoodDTO getGood(String g_femail) {
		return friendMapper.getGood(g_femail);
	}

	@Override
	public int deleteGoodList(GoodDTO goodDTO) {
		return friendMapper.deleteGoodList(goodDTO);
	}
	@Override
	public void deleteGood(GoodDTO goodDTO) {
		friendMapper.deleteGood(goodDTO);
	}

	@Override
	public List<PaymentDTO> getPaymentList() {
		return friendMapper.getPaymentList();
	}

	@Override
	public List<LectureBoxDTO> getLectureBox(String lf_code) {
		return friendMapper.getLectureBox(lf_code);
	}

	@Override
	public void insertGood(GoodDTO goodDTO) {
		friendMapper.insertGood(goodDTO);
	}

	@Override
	public void insertStar(StarDTO starDTO) {
		friendMapper.insertStar(starDTO);
	}
	@Override
	public List<AdminFriendDTO> getmemberlist() {
		return friendMapper.getmemberlist();
	}
	@Override
	public List<PaymentMypageDTO> paymentListInMypage() {
		return friendMapper.paymentListInMypage();
	}
}


