package com.cocoa.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReplyDTO {
    private int ar_seq;
    private int ar_idx;
    private String ar_writer;
    private String ar_created_datetime;
    private String ar_content;
    private String ar_deleted_yn;
    private String ar_email;
}
