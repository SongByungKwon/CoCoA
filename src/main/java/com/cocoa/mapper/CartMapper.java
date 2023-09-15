package com.cocoa.mapper;

import com.cocoa.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> selectCartList(String fEmail) throws Exception;

    int selectCartTotalprice(String fEmail) throws Exception;

    int allDeleteCartList(String fEmail) throws Exception;

    int checkDeleteCartList(CartDTO cartDTO) throws Exception;
    void insertCart(CartDTO cartDTO) throws Exception;

    List<CartDTO> checkPaymentList(CartDTO cartDTO) throws Exception;

    int paymentTotalPrice(CartDTO cartDTO) throws Exception;

    int paymentPlus(CartDTO cartDTO);

    int cartDelete(CartDTO cartDTO);
}


