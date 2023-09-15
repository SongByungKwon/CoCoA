package com.cocoa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FriendDTO {
    private String fName;
    private String fEmail;
    private String fPassword;
    private String fPhone;
    private String fJob;
    private String fRecently;
    private String fMyCourse;

    public String getfEmail() {
        return fEmail;
    }
}
