package com.cocoa.controller;

import com.cocoa.dto.CartDTO;
import com.cocoa.mapper.CartMapper;
import com.cocoa.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    //장바구니 목록 불러오기
    @RequestMapping("/cart")
    public ModelAndView cart(HttpSession session) throws Exception  {

        ModelAndView mv = new ModelAndView("/cart");

        System.out.println("cart");
        String fEmail = (String) session.getAttribute("user");

        List<CartDTO> list = cartService.selectCartList(fEmail);
        int selectCartTotalprice = cartService.selectCartTotalprice(fEmail);

        mv.addObject("list", list);
        mv.addObject("totalPrice", selectCartTotalprice);

        return mv;
    }

    //장바구니 전체 삭제하기
    @ResponseBody
    @RequestMapping(value = "/allDelete", method = RequestMethod.POST)
    public int allDelete(HttpSession session) throws Exception{

        System.out.println("allDelete");
        String fEmail = (String) session.getAttribute("user");

        int result = cartService.allDeleteCartList(fEmail);
        System.out.println(result);

        return result;
    }

    //장바구니 선택 삭제하기
    @ResponseBody
    @RequestMapping(value = "/checkDelete", method = RequestMethod.POST)
    public int checkDelete(@RequestParam(value = "c_lcode[]", required=false) String[] checkList, HttpSession session) throws Exception{

        CartDTO cartDTO = new CartDTO();

        cartDTO.setC_lcode(checkList);

        String fEmail = (String) session.getAttribute("user");

        cartDTO.setC_femail(fEmail);

        System.out.println(cartDTO.getC_femail());

        int result = cartService.checkDeleteCartList(cartDTO);
        System.out.println(result);

        return result;
    }
    @RequestMapping("/insertCart")
    public String insertCart(CartDTO cartDTO){
        try {
            cartService.insertCart(cartDTO);
        }catch (Exception e){
            return "cartErrorAlert";
        }

        return "redirect:/cart";
    }

    //장바구니에서 선택한 강의 목록 구매 페이지에 띄우기
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
//    public ModelAndView payment(@RequestParam(value = "payList[]")String[] checkPay, HttpSession session) throws Exception  {
    public ModelAndView payment(CartDTO cartDTO, HttpSession session) throws Exception  {

        System.out.println(cartDTO);

        ModelAndView mv = new ModelAndView("/payment");
        System.out.println("payment");

        String fEmail = (String) session.getAttribute("user");
        System.out.println("fEmail 확인 : "+ fEmail);

        cartDTO.setC_femail(fEmail);
        System.out.println("cartDTO : "+cartDTO);

        List<CartDTO> checkPaymentList = cartService.checkPaymentList(cartDTO);

        int paymentTotalPrice = cartService.paymentTotalPrice(cartDTO);

        System.out.println("paymentTotalPrice : "+paymentTotalPrice);

        String[] test = cartDTO.getPayList();

        System.out.println(test);


        mv.addObject("list", checkPaymentList);
        mv.addObject("totalPay", paymentTotalPrice);
        mv.addObject("code", cartDTO.getPayList());

        System.out.println(mv);

        return mv;
    }
    //장바구니에서 선택한 강의 목록 구매 페이지에 띄우기

    @ResponseBody
    @RequestMapping(value = "/goPayment", method = RequestMethod.POST)
//    public ModelAndView payment(@RequestParam(value = "payList[]")String[] checkPay, HttpSession session) throws Exception  {
    public int goPayment(CartDTO cartDTO, HttpSession session) throws Exception  {

        System.out.println(cartDTO);
        System.out.println(cartDTO.getTitle());


        String[] title = cartDTO.getTitle();
        String[] code = cartDTO.getC_lcode();

        String title1 = "";
        String title2 = "";
        String code1 = "";
        String code2 = "";

        CartDTO cartDTO1 = new CartDTO();

        for(int i = 0; i < code.length; i++){
            title1 = title[i];
            code1 = code[i];

            if(i == 0){
                title2 = title1;
                code2 = code1;
            }else{
                title2 = title2 + "|" + title1;
                code2 = code2 + "|" + code1;
            }

        }

        cartDTO1.setP_title(title2);
        cartDTO1.setP_lcode(code2);


        String fEmail = (String) session.getAttribute("user");
        System.out.println("fEmail 확인 : "+ fEmail);

        cartDTO.setC_femail(fEmail);
        cartDTO1.setC_femail(fEmail);

        int paymentPlus = cartService.paymentPlus(cartDTO1);
        int cartDelete = 0;
        int result = 0;

        System.out.println(paymentPlus);

        if(paymentPlus > 0){
            cartDelete = cartService.cartDelete(cartDTO);
            System.out.println(cartDelete);
            if (cartDelete > 0){
                result = 1;
            }
        }

        return result;
    }

}
