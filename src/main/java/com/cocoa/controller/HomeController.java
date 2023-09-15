package com.cocoa.controller;


import com.cocoa.dto.LectureDTO;
import com.cocoa.dto.StarDTO;
import com.cocoa.service.FriendService;
import com.cocoa.service.JsonData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FriendService friendService;

    @GetMapping({"/"})
    public String star(Model model) {

        List<StarDTO> starList = friendService.star();
        model.addAttribute("starList", starList);
        JsonData jsd = new JsonData();
        model.addAttribute("list", jsd.list());
        System.out.println("main.star");
        return "mainHome";
    }

    @RequestMapping({"/CoCoA"})
    public String CoCoA() {
        return "cocoa";
    }


    @RequestMapping({"/cibi"})
    public String cibi() {
        return "cibi";
    }

    @RequestMapping({"/teacher"})
    public String teacher() {
        return "teacher";
    }

    @RequestMapping({"/studyList"})
    public String studyList() {
        return "studyList";
    }


    @RequestMapping("/lectureLink")
    public String lectureLink() {
        return "lectureLink";
    }


    @RequestMapping("/payment")
    public String payment() {
        return "payment";
    }



    @RequestMapping("/studyMP4_java01")
    public String studyMP4_java01() {
        return "studyMP4_java01";
    }

    @RequestMapping("/studyMP4_java02")
    public String studyMP4_java02() {
        return "studyMP4_java02";
    }

    @RequestMapping("/studyMP4_java03")
    public String studyMP4_java03() {
        return "studyMP4_java03";
    }

    @RequestMapping("/myLecture")
    public String myLecture(){
        return "myLecture";
    }

}

