package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Account;

public interface AccountService {


    Account findByUsername(String username);



    void register(String username, String password, Integer type);


    void updateAvatar(String imgUrl);

    void deleteById(Integer accId);
}
