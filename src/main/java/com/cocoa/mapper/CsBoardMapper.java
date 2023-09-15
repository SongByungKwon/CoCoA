package com.cocoa.mapper;

import com.cocoa.dto.CsBoardDto;
import com.cocoa.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Mapper라고 선언함
public interface CsBoardMapper {

    // 여기서 지정한 메서드의 이름은 쿼리의 이름과 동일해야 함 (selectBoardList)
    List<CsBoardDto> selectBoardList() throws Exception;

    void insertBoard(CsBoardDto csBoardDto) throws Exception;

    void updateHitCount(int cs_board_idx) throws Exception;

    CsBoardDto selectCsBoardDetail(int cs_board_idx) throws Exception;

    void updateBoard(CsBoardDto upboard) throws  Exception;

    void deleteBoard(int cs_board_idx) throws Exception;

    CsBoardDto csboardpwdcheck(CsBoardDto pwchk) throws Exception;

    void insertReply(ReplyDTO replyDTO)  throws Exception;

    List<ReplyDTO> getReplyList(ReplyDTO srDTO) throws Exception;
}


