package com.cocoa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoumteoDTO {
    private int Q_question;
    private String Q_questionTitle;
    private String Q_questionContents;
    private String Q_questionKind;
    private String Q_questionDateTime;
    private String Q_questionDATA;
    private String Q_questionIn;
    private String Q_questionOut;
    private String Q_questionLink;
}
