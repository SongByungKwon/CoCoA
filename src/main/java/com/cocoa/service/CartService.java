package com.cocoa.service;

import com.cocoa.dto.CartDTO;

import java.util.List;

public interface CartService {
    //cart
    //장바구니 목록 리스트 불러오기
    List<CartDTO> selectCartList(String fEmail) throws Exception;
    void insertCart(CartDTO cartDTO) throws Exception;

    //장바구니에 담은 강의 합계 가격
    int selectCartTotalprice(String fEmail) throws Exception;

    //전체 삭제하기
    int allDeleteCartList(String fEmail) throws Exception;

    //선택 삭제하기
    int checkDeleteCartList(CartDTO cartDTO) throws Exception;

    //payment
    //결제목록 리스트 불러오기
    List<CartDTO> checkPaymentList(CartDTO cartDTO) throws Exception;

    //결제목록 합계 가격
    int paymentTotalPrice(CartDTO cartDTO) throws Exception;

    //결제 성공(결제내역 추가)
    int paymentPlus(CartDTO cartDTO) throws Exception;

    //결제 성공(장바구니 삭제)
    int cartDelete(CartDTO cartDTO) throws Exception;
}
