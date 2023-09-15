package com.cocoa.dto;

import lombok.Data;

@Data
public class PaymentMypageDTO {
    private int p_pk;
    private String P_FEMAIL;
    private String P_LCODE;
    private String P_PAYDATE;
    private String L_TITLE;
    private int L_COST;
}
