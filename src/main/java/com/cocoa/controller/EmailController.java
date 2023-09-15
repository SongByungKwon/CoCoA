package com.cocoa.controller;

import com.cocoa.service.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private FriendServiceImpl friendService;

    @PostMapping(value="/")
    @ResponseBody
    public int emailCheck(@RequestParam("fEmail") String fEmail)  {

        int cnt = friendService.emailCheck(fEmail);
        System.out.println(cnt);

        return cnt;

    }
}
