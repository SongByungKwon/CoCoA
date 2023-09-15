package com.cocoa.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String fEmail;

    private String l_code;
    private int l_cost;
    private String l_title;
    private String c_femail;
    private int c_pk;
    private String[] c_lcode;
    private String f_email;
    private int totalPrice;

    private String p_pk;
    private String p_femail;
    private String p_lcode;
    private String p_title;

    private String[] payList;
    private String[] checkPay;

    private String[] title;

}
