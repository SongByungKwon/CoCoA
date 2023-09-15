package com.cocoa.service;

import com.cocoa.dto.CoumteoDTO;
import com.cocoa.dto.CsBoardDto;
import com.cocoa.mapper.CoumteoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoumteoServicempl implements CoumteoService {

    @Autowired
    private CoumteoMapper coumteoMapper;


    @Override
    public List<CoumteoDTO> selectCoumteoList() throws Exception {
        return coumteoMapper.selectCoumteoList();
    }


    @Override
    public List<CoumteoDTO> selectCoumteoJavaList() throws Exception {
        return coumteoMapper.selectCoumteoJavaList();
    }


    @Override
    public List<CoumteoDTO> selectCoumteoJavascriptList() throws Exception {
        return coumteoMapper.selectCoumteoJavascriptList();
    }

    @Override
    public List<CoumteoDTO> selectCoumteoHtmlCssList() throws Exception {
        return coumteoMapper.selectCoumteoHtmlCssList();
    }

    public List<CoumteoDTO> selectCoumteoSQLList() throws Exception {
        return coumteoMapper.selectCoumteoSQLList();
    }

    public List<CoumteoDTO> selectCoumteoCList() throws Exception {
        return coumteoMapper.selectCoumteoCList();
    }

    public List<CoumteoDTO> selectCoumteoInformationProcessingList() throws Exception {
        return coumteoMapper.selectCoumteoInformationProcessingList();
    }

    @Override
    public CoumteoDTO selectCoumteoBoard(int Q_question) throws Exception {

        CoumteoDTO board =coumteoMapper.selectCoumteoBoard(Q_question);
        return board;
    }


    public List<CoumteoDTO> managerCoumteo() throws Exception {
        return coumteoMapper.managerCoumteo();
    }

    @Override
    public void insertCoumteoInto(CoumteoDTO coumteoDTO) throws Exception {
        coumteoMapper.insertCoumteoInto(coumteoDTO);
    }

    @Override
    public CoumteoDTO managerCoumteoBoard(int Q_question) throws Exception {

        CoumteoDTO board =coumteoMapper.managerCoumteoBoard(Q_question);
        return board;
    }

    @Override
    public void coumteodelete(int Q_question) throws Exception {
        coumteoMapper.coumteodelete(Q_question);
    }


}
