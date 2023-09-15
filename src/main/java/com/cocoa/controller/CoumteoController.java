package com.cocoa.controller;

import com.cocoa.dto.CoumteoDTO;
import com.cocoa.dto.CsBoardDto;
import com.cocoa.service.CoumteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CoumteoController {

    @Autowired
    private CoumteoService coumteoService; //서비스와 연결

    @RequestMapping("/Coumteo")
    public ModelAndView openCoumteoLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/Coumteo");

        List<CoumteoDTO> list = coumteoService.selectCoumteoList();
        System.out.println(list);
        Cv.addObject("list",list);

        return Cv;

    }

    @RequestMapping("/CoumteoJava")
    public ModelAndView openCoumteoJavaLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoJava");

        List<CoumteoDTO> Javalist = coumteoService.selectCoumteoJavaList();
        System.out.println(Javalist);
        Cv.addObject("Javalist",Javalist);

        return Cv;

    }

    @RequestMapping("/Coumteojavascript")
    public ModelAndView openCoumteoJavascriptLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoJavascript");

        List<CoumteoDTO> Javascriptlist = coumteoService.selectCoumteoJavascriptList();
        System.out.println(Javascriptlist);
        Cv.addObject("Javascriptlist",Javascriptlist);

        return Cv;

    }

    @RequestMapping("/CoumteoHtmlCss")
    public ModelAndView openCoumteoHtmlCssLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoHtmlCss");

        List<CoumteoDTO> HtmlCsslist = coumteoService.selectCoumteoHtmlCssList();
        System.out.println(HtmlCsslist);
        Cv.addObject("HtmlCsslist",HtmlCsslist);

        return Cv;

    }

    @RequestMapping("/CoumteoSQL")
    public ModelAndView openCoumteoSQLLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoSQL");

        List<CoumteoDTO> SQLlist = coumteoService.selectCoumteoSQLList();
        System.out.println(SQLlist);
        Cv.addObject("SQLlist",SQLlist);

        return Cv;

    }

    @RequestMapping("/CoumteoC")
    public ModelAndView openCoumteoCLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoC");

        List<CoumteoDTO> Clist = coumteoService.selectCoumteoCList();
        System.out.println(Clist);
        Cv.addObject("Clist",Clist);

        return Cv;

    }

    @RequestMapping("/CoumteoInformationProcessing")
    public ModelAndView openCoumteoInformationProcessingLsit()throws Exception{
        System.out.println("/Coumteo 컨트롤러 실행");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoInformationProcessing");

        List<CoumteoDTO> InformationProcessinglist = coumteoService.selectCoumteoInformationProcessingList();
        System.out.println(InformationProcessinglist);
        Cv.addObject("InformationProcessinglist",InformationProcessinglist);

        return Cv;

    }




    @RequestMapping("/coumteoBoard")
    public ModelAndView CoumteoBoard(@RequestParam int Q_question)throws Exception{
        System.out.println("Test");
        ModelAndView Cv = new ModelAndView("coumteo/CoumteoBoard");
        System.out.println(Cv);

        CoumteoDTO board=coumteoService.selectCoumteoBoard(Q_question);
        Cv.addObject("board",board);
        System.out.println(Cv);

        return Cv;

    }


/////관리자 모드//////


    @RequestMapping("/managerCoumteo")
    public ModelAndView managerCoumteo()throws Exception{
        System.out.println("list");
        ModelAndView Cv = new ModelAndView("coumteo/managerCoumteo");
        System.out.println(Cv);

        List<CoumteoDTO> list = coumteoService.managerCoumteo();
        Cv.addObject("list",list);
        System.out.println(Cv);

        return Cv;

    }
    //코움터 글쓰기 창
    @RequestMapping("/managerCoumteo/insertCoumteo")
    public String insertCoumtep() throws Exception {
        return "coumteo/insertCoumteo";
    }

     //글쓰기 등록 및 등록 후 화면전환
    @RequestMapping("/managerCoumteo/insertCoumteoInto")
    public String insertCoumteoInto(CoumteoDTO coumteoDTO) throws Exception {
        coumteoService.insertCoumteoInto(coumteoDTO);
        return "redirect:/managerCoumteo";
    }




    @RequestMapping("/managercoumteoBoard")
    public ModelAndView managerCoumteoBoard(@RequestParam int Q_question)throws Exception{
        System.out.println("Test");
        ModelAndView Cv = new ModelAndView("coumteo/managerCoumteoBoard");
        System.out.println(Cv);

        CoumteoDTO board=coumteoService.managerCoumteoBoard(Q_question);
        Cv.addObject("board",board);
        System.out.println(Cv);

        return Cv;

    }



    //게시글 수정하기




    //게시글 삭제하기



    @PostMapping("/coumteo/coumteodelete")
    public String coumteodelete(int Q_question) throws Exception{
        System.out.println(Q_question+"aaaaaaaaaa");
        coumteoService.coumteodelete(Q_question);
        System.out.println("Q_question 값 : "+Q_question);
        return "redirect:/managerCoumteo";
    }







    }


