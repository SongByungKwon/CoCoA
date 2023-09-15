package com.cocoa.service;

import com.cocoa.dto.CsBoardDto;
import com.cocoa.dto.ReplyDTO;
import com.cocoa.mapper.CsBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsBoardServiceImpl implements CsBoardService{

    @Autowired //Mapper와 연결
    private CsBoardMapper csBoardMapper;


    @Override
    public List<CsBoardDto> selectBoardList() throws Exception {
        return csBoardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(CsBoardDto csBoardDto) throws Exception {
        csBoardMapper.insertBoard(csBoardDto);
    }

    @Override
    public CsBoardDto selectCsBoardDetail(int cs_board_idx) throws Exception {
        csBoardMapper.updateHitCount(cs_board_idx);

        CsBoardDto board = csBoardMapper.selectCsBoardDetail(cs_board_idx);

        return board;
    }

    @Override
    public void updateBoard(CsBoardDto upboard) throws Exception {
        csBoardMapper.updateBoard(upboard);
    }

    @Override
    public void deleteBoard(int cs_board_idx) throws Exception {
        csBoardMapper.deleteBoard(cs_board_idx);
    }

    @Override
    public CsBoardDto csboardpwdcheck(CsBoardDto pwchk) throws Exception {
        csBoardMapper.updateHitCount(pwchk.getCs_board_idx());
        CsBoardDto pwcheck = csBoardMapper.csboardpwdcheck(pwchk);

        return pwcheck;
    }

    @Override
    public void insertReply(ReplyDTO replyDTO) throws Exception {
        csBoardMapper.insertReply(replyDTO);
    }

    @Override
    public List<ReplyDTO> getReplyList(ReplyDTO srDTO) throws Exception {
        return csBoardMapper.getReplyList(srDTO);
    }

}
