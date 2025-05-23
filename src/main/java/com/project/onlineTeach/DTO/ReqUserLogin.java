package com.project.onlineTeach.DTO;

import lombok.Data;
import lombok.NonNull;

@Data
public class ReqUserLogin {
    @NonNull
    public String username;
    @NonNull
    public String password;

}
