package com.cocoa.controller;

import com.cocoa.dto.CsBoardDto;
import com.cocoa.dto.ReplyDTO;
import com.cocoa.service.CsBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private CsBoardService csBoardService; //서비스와 연결

    // 게시판 리스트 Read
    @RequestMapping("/csboard/openBoardList.do") //노테이션의 값으로 주소 지정
    public ModelAndView openBoardList(HttpSession session) throws Exception{
        //templates 폴더 아래있는 /csboardList.html을 의미함. Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        ModelAndView mv = new ModelAndView("csBoard/csboardList");
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출

        List<CsBoardDto> list = csBoardService.selectBoardList();
        System.out.println("openBoardList.do 의 list 확인 : " + list);
        mv.addObject("list", list);

        return mv;
    }

    // 게시판 리스트 Read-관리자 모드
    @RequestMapping("/csboard/openBoardList.admin") //노테이션의 값으로 주소 지정
    public ModelAndView openBoardListAdmin(HttpSession session) throws Exception{
        //templates 폴더 아래있는 /csboardList.html을 의미함. Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        ModelAndView mv = new ModelAndView("csBoard/csboardListAdmin");
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출

        List<CsBoardDto> list = csBoardService.selectBoardList();
        System.out.println("openBoardList.do 의 list 확인 : " + list);
        mv.addObject("list", list);

        return mv;
    }

    // 글쓰기 창
    @RequestMapping("/csboard/openBoardWrite.do")
    public String openBoardWrite() throws Exception {
        return "/csboard/csboardWrite";
    }

    // 글쓰기 등록 및 등록 후 화면전환
    @RequestMapping("/csboard/insertBoard.do")
    public String insertBoard(CsBoardDto csBoardDto) throws Exception {
        csBoardService.insertBoard(csBoardDto);
        return "redirect:/csboard/openBoardList.do";
    }

//     게시글 상세보기
    @GetMapping("/csboard/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int cs_board_idx) throws Exception{
        ModelAndView mv = new ModelAndView("csboard/csboardDetail");

        CsBoardDto pwchk = csBoardService.selectCsBoardDetail(cs_board_idx);
        System.out.println("detail dto 값 : " + pwchk);
        mv.addObject("pwchk", pwchk);

        return mv;
    }

    @PostMapping("/csboard/openBoardDetail.do")
    public ModelAndView csboardpwdcheck(CsBoardDto pwdcheck) throws Exception{
        ModelAndView mv = new ModelAndView("csboard/csboardDetail");
        System.out.println("detail dto 값 : " + pwdcheck);

        CsBoardDto pwchk = csBoardService.csboardpwdcheck(pwdcheck);

        System.out.println("비밀번호 값이 컨트롤러에 어떻게 들어왔죠? : " + pwchk);
        if(pwchk==null){
            List<CsBoardDto> list = csBoardService.selectBoardList();
            mv.addObject("list", list);
//            mv.setViewName("csboard/csboardList");
            mv.setViewName("csboard/alert");
        }
        System.out.println("test : ");
        System.out.println(pwchk);
        mv.addObject("pwchk", pwchk);

        return mv;
    }

    //게시글 수정하기
    @RequestMapping("/csboard/updateBoard.do")
    public String updateBoard(CsBoardDto upboard) throws Exception{
        csBoardService.updateBoard(upboard);
        System.out.println(upboard);
        return "redirect:/csboard/openBoardList.do";
    }


    //게시글 삭제하기
    @RequestMapping("/csboard/deleteBoard.do")
    public String deleteBoard(int cs_board_idx) throws Exception{
        csBoardService.deleteBoard(cs_board_idx);
        System.out.println("delete idx 값 : "+cs_board_idx);
        return "redirect:/csboard/openBoardList.do";
    }

    @RequestMapping("/csboard/reply/write.do")
    public String insertReply(@RequestParam String ar_idx, @RequestParam String ar_content, @RequestParam String ar_email, @RequestParam String ar_created_datetime) throws Exception{
        int idx = Integer.parseInt(ar_idx);

        System.out.println("컨트롤러 idx 값 확인 : " + idx);

        System.out.println("컨트롤러 content 값 확인 : " + ar_content);

        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setAr_content(ar_content);
        replyDTO.setAr_idx(idx);
        replyDTO.setAr_email(ar_email);
        replyDTO.setAr_created_datetime(ar_created_datetime);
        csBoardService.insertReply(replyDTO);
        String redirectUrl = "redirect:/csboard/openBoardDetail.do?cs_board_idx="+idx;
        System.out.println("리다이렉트 주소 확인 : "+redirectUrl);

        return redirectUrl;
    }

    @GetMapping("/getReplyList")
    @ResponseBody
    public List<ReplyDTO> getReplyList(@RequestParam int ar_idx) throws Exception{
        System.out.println("댓글 조회하기 컨트롤러 실헹");
        System.out.println("getReplyList 의 idx 확인 : " + ar_idx);
//        int idx = Integer.parseInt(ar_idx);
//        System.out.println("getReplyList 의 idx 확인 : " + idx);
        ReplyDTO result = new ReplyDTO();
//        System.out.println("getReplyList 의 result 확인 : " + result);
        result.setAr_idx(ar_idx);
        System.out.println("getReplyList 의 replyDTO 확인 : " + result);

        return csBoardService.getReplyList(result);
    }
}
