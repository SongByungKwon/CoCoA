package com.cocoa.dto;

import lombok.Data;

@Data
public class LectureBoxDTO {
    private int l_pk;
    private String l_code;
    private String l_teacher;
    private int l_cost;
    private String l_time;
    private String l_difficulty;
    private String l_tag;
}
