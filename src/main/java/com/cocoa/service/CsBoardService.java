package com.cocoa.service;

import com.cocoa.dto.CsBoardDto;
import com.cocoa.dto.ReplyDTO;

import java.util.List;

public interface CsBoardService {
    List<CsBoardDto> selectBoardList() throws Exception;

    void insertBoard(CsBoardDto csBoardDto) throws Exception;

    CsBoardDto selectCsBoardDetail(int cs_board_idx) throws Exception;

    void updateBoard(CsBoardDto upboard) throws  Exception;

    void deleteBoard(int cs_board_idx) throws Exception;

    CsBoardDto csboardpwdcheck(CsBoardDto pwchk) throws Exception;

    void insertReply(ReplyDTO replyDTO)  throws Exception;

    List<ReplyDTO> getReplyList(ReplyDTO srDTO) throws Exception;

}
