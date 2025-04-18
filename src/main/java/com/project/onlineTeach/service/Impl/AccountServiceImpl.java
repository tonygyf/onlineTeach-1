package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.AccountMapper;
import com.project.onlineTeach.Util.Md5Util;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Account;
 import com.project.onlineTeach.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }


    @Override
    public void register(String username, String password, Integer type) {
        String md5password=Md5Util.getMD5String(password);
        accountMapper.register(username,md5password,type);
    }



    @Override
    public void updateAvatar(String imgUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer accId = (Integer) map.get("id");
        accountMapper.updateAvatar(accId,imgUrl);
    }

    @Override
    public void deleteById(Integer accId) {
        accountMapper.deleteById(accId);
    }


}
