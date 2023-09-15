package com.cocoa.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private int p_pk;
    private String p_femail;
    private String p_lcode;
    private String p_paydate;
    private String p_refund;
    private String p_refdate;
    private String p_recently;
    private String p_title;
}
