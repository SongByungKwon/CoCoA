package com.cocoa.mapper;

import com.cocoa.dto.CoumteoDTO;

import com.cocoa.dto.CsBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoumteoMapper {
    List<CoumteoDTO> selectCoumteoList() throws Exception;

    List<CoumteoDTO> selectCoumteoJavaList() throws Exception;

    List<CoumteoDTO> selectCoumteoJavascriptList() throws Exception;

    List<CoumteoDTO> selectCoumteoHtmlCssList() throws Exception;

    List<CoumteoDTO> selectCoumteoSQLList() throws Exception;

    List<CoumteoDTO> selectCoumteoCList() throws Exception;

    List<CoumteoDTO> selectCoumteoInformationProcessingList() throws Exception;


    CoumteoDTO selectCoumteoBoard(int Q_question) throws Exception;




    List<CoumteoDTO> managerCoumteo() throws Exception;

    void insertCoumteoInto(CoumteoDTO coumteoDTO) throws Exception;

    CoumteoDTO managerCoumteoBoard(int Q_question) throws Exception;



    void coumteodelete(int Q_question) throws Exception;



}


