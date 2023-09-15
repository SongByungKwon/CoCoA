package com.cocoa.controller;

import com.cocoa.dto.CoumteoDTO;
import com.cocoa.service.CoumteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManagerHomeController {

    @Autowired
    private CoumteoService coumteoService; //서비스와 연결

    @RequestMapping("/managerLogin")
    public String managerLogin(){
        return "managerLogin";
    }

    @RequestMapping("/managerHome")
    public String managerHome(){
        return "managerHome";
    }



}