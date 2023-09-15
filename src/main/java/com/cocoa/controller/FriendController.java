package com.cocoa.controller;

import com.cocoa.dto.*;
import com.cocoa.service.CartService;

import com.cocoa.dto.StarDTO;
import com.cocoa.service.FriendService;
import com.cocoa.service.JsonData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FriendController {

    @Autowired
    FriendService friendService;

    @Autowired
    CartService cartService;

    String result;
    String llcode;

    @GetMapping({"/loginHome"})
    public String reHome(Model model, @ModelAttribute FriendDTO friendDTO, HttpSession session) {
        //session값 때문에 추가
        session.getAttribute(friendDTO.getfEmail());

        List<StarDTO> starList = friendService.star();
        model.addAttribute("starList", starList);

        JsonData jsd = new JsonData();
        model.addAttribute("list", jsd.list());

        System.out.println("reHome");
        return "loginHome";
    }

    @RequestMapping("/findEmail")
    public String findEmail(Model model, FriendDTO friendDTO) {
        String email = friendService.findEmail(friendDTO);
        model.addAttribute("email", email);
        System.out.println("email 컨트롤러에서 확인 : " + email);

        JsonData jsd = new JsonData();
        model.addAttribute("list", jsd.list());

        List<StarDTO> starList = friendService.star();
        model.addAttribute("starList", starList);

        return "mainHome";
    }

    @PostMapping("/loginFriend")
    public String loginHome(Model model, @ModelAttribute FriendDTO friendDTO, HttpSession session) throws IOException {

        boolean result = friendService.login(friendDTO);
        String com = friendService.myPage(friendDTO);

        if(result == true){
            List<StarDTO> starList = friendService.star();
            model.addAttribute("starList", starList);

            session.setAttribute("user", friendDTO.getfEmail());
            session.setAttribute("user1", com);
            System.out.println("세션 이름 : " + com);
            System.out.println("세션 이메일 : " + friendDTO.getfEmail());

            JsonData jsd = new JsonData();
            model.addAttribute("list", jsd.list());

            System.out.println("login success");

            return "loginHome";
        }
        else{
            return "LogOut";
        }
    }

    @PostMapping("/mainHome")
    public String signUpFriend(Model model, @ModelAttribute FriendDTO friendDTO, HttpSession session) {
        session.setAttribute("user", friendDTO); //session값 때문에 추가해봄

        boolean check = friendService.ckPwd(friendDTO);
        result = friendDTO.getfEmail();
        System.out.println(result);

        if(!result.equals("")&&!friendDTO.getFName().equals("")&&check==true) {
            model.addAttribute("result", result);
            return "/include/rePwd";
        }

        List<StarDTO> starList = friendService.star();
        model.addAttribute("starList", starList);
        JsonData jsd = new JsonData();
        model.addAttribute("list", jsd.list());

        System.out.println(friendDTO.getfEmail());
        friendService.save(friendDTO);

        return "mainHome";
    }
    //비밀번호 변경
    @RequestMapping("/rePwd")
    public String rePwd(FriendDTO friendDTO, HttpSession session) throws IOException {
        result = (String) session.getAttribute("user");
        friendDTO.setFEmail(result);
        System.out.println("rePwd: " + result);
        ModelAndView mv = new ModelAndView("/mainHome");
        mv.addObject(result);
        friendService.rePwd(friendDTO);
        System.out.println(friendDTO);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(FriendDTO friendDTO, HttpSession session) {
        result = (String) session.getAttribute("user");
        friendDTO.setFEmail(result);
        friendService.deleteFriend(friendDTO);
        return "LogOut";
    }

    @RequestMapping("/myPage")
    public String myPage(Model model, HttpSession session) {
        String fEmail = (String) session.getAttribute("user");
        List<Map<String, Object>> goodList = friendService.getMyGoodList(fEmail);
        model.addAttribute("goodList", goodList);
        List<PaymentMypageDTO> paylist = friendService.paymentListInMypage();
        model.addAttribute("paylist", paylist);
        System.out.println("마이페이지 좋아용");
        return "myPage";
    }

    @RequestMapping("/personal")
    public String personal(HttpSession session, FriendDTO friendDTO) {
        session.getAttribute(friendDTO.getfEmail());
        session.getAttribute(friendDTO.getFName());
        return "personalData";
    }

    @RequestMapping("/lecture")
    public ModelAndView lectureinfo(LectureinfoDTO lectureinfoDTO, HttpSession session) {
        ModelAndView mv = new ModelAndView("/lectureinfo");

        ModelAndView mvalert = new ModelAndView("/goodErrorAlert");

        System.out.println("lecture 컨트롤러 실행");


        String userchk = (String) session.getAttribute("user");
        System.out.println("session user 확인 : " + userchk);

        LectureinfoDTO lecture = friendService.getlecturelist(lectureinfoDTO);
//        System.out.println("lecture 컨트롤러에서의 lecture 확인 : " + lecture);
        System.out.println("lecture 컨트롤러에서의 Lf_code 확인 : " + lectureinfoDTO.getLf_code());

        llcode = lectureinfoDTO.getLf_code();

        List<PaymentDTO> payment = friendService.getPaymentList();
        System.out.println("lecture 컨트롤러에서의 payment 확인 : " + payment);

        List<LectureBoxDTO> lbox = friendService.getLectureBox(lecture.getLf_code());

        mv.addObject("lecture", lecture);
        mv.addObject("payment", payment);
        mv.addObject("lbox", lbox);

        try {
            GoodDTO good = friendService.getGood(userchk);
            mv.addObject("good", good);
            System.out.println("좋아요 : " + good);

        }catch (Exception e){

            return mvalert;
        }

        return mv;
    }
    @RequestMapping("/paymentList")
    public ModelAndView getPaymentList() {
        ModelAndView pmv = new ModelAndView("/paymentList");

        List<PaymentMypageDTO> paymentlistMypage = friendService.paymentListInMypage();

        System.out.println("lecture 컨트롤러에서의 payment 확인 : " + paymentlistMypage);
        pmv.addObject("paymentlistMypage", paymentlistMypage);

        return pmv;

    }

    @ResponseBody
    @RequestMapping(value = "/lectureStar")
    public void insertStar(StarDTO starDTO) {
        friendService.insertStar(starDTO);
        System.out.println("리뷰등록 성공 : " + starDTO);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        System.out.println("로그아웃 성공입니다.");

        return "LogOut";
    }

    @RequestMapping("/good")
    public String good(Model model, HttpSession session){
        String fEmail = (String) session.getAttribute("user");
        List<Map<String, Object>> goodList = friendService.getMyGoodList(fEmail);
        System.out.println("fEmail : " + fEmail);
        model.addAttribute("goodList", goodList);
        System.out.println("goodList : " + goodList);

        return "good";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGoodList", method = RequestMethod.POST)
    public int deleteGood(@RequestParam(value = "g_pk[]", required = false) int[] checkList) {
        GoodDTO goodDTO = new GoodDTO();
        goodDTO.setG_pk(checkList);
        int num = friendService.deleteGoodList(goodDTO);
        System.out.println(num);
        return num;
    }
    @ResponseBody
    @RequestMapping("/insertGood")
    public void insertGood(GoodDTO goodDTO, HttpSession session) {
        String g_femail = (String) session.getAttribute("user");
        System.out.println("g_femail : " + g_femail);
        goodDTO.setG_femail(g_femail);

        goodDTO.setG_code(llcode);

        friendService.insertGood(goodDTO);
        System.out.println("insertGood");
    }

    @ResponseBody
    @RequestMapping("/deleteGood")
    public void deleteGood(GoodDTO goodDTO, HttpSession session) {
        String g_femail = (String) session.getAttribute("user");
        System.out.println("g_femail : " + g_femail);
        goodDTO.setG_femail(g_femail);

        goodDTO.setG_code(llcode);

        friendService.deleteGood(goodDTO);
        System.out.println("deleteGood");
    }

    @RequestMapping("/cocoafriendList.do")
    public ModelAndView getmemberlist(){
        ModelAndView amv = new ModelAndView("friendList");
        List<AdminFriendDTO> flist = friendService.getmemberlist();
        amv.addObject("flist", flist);

        return amv;
    }
}
