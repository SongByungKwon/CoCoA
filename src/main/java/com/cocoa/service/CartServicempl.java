package com.cocoa.service;

import com.cocoa.dto.CartDTO;
import com.cocoa.mapper.CartMapper;
import com.cocoa.mapper.CoumteoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServicempl implements CartService {

    @Autowired
    private CartMapper cartMapper;


    @Override
    public List<CartDTO> selectCartList(String result) throws Exception {
        return cartMapper.selectCartList(result);
    }

    @Override
    public int selectCartTotalprice(String totalPrice) throws Exception {
        return cartMapper.selectCartTotalprice(totalPrice);
    }

    @Override
    public int allDeleteCartList(String allDeleteNum) throws Exception{
        return cartMapper.allDeleteCartList(allDeleteNum);
    }

    @Override
    public int checkDeleteCartList(CartDTO cartDTO) throws Exception{
        return cartMapper.checkDeleteCartList(cartDTO);
    }
    @Override
    public void insertCart(CartDTO cartDTO) throws Exception {
        cartMapper.insertCart(cartDTO);
    }

    @Override
    public List<CartDTO> checkPaymentList(CartDTO cartDTO) throws Exception {
        return cartMapper.checkPaymentList(cartDTO);
    }

    @Override
    public int paymentTotalPrice(CartDTO cartDTO) throws Exception {
        return cartMapper.paymentTotalPrice(cartDTO);
    }

    @Override
    public int paymentPlus(CartDTO cartDTO) throws Exception{
        return cartMapper.paymentPlus(cartDTO);
    }

    @Override
    public int cartDelete(CartDTO cartDTO) throws Exception{
        return cartMapper.cartDelete(cartDTO);
    }
}
