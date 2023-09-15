package com.cocoa.dto;

import lombok.Data;

@Data
public class CsBoardDto {

    private int cs_board_idx;
    private String cs_title;
    private String cs_contents;
    private int cs_hit_cnt;
    private String cs_created_datetime;
    private String cs_creator_id;
    private String cs_updated_datetime;
    private String cs_updater_id;
    private String cs_deleted_yn;
    private String cs_password;
    private String cs_email;
}
