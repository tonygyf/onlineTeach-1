package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {


    @Select("SELECT * from account where username=#{username}")
    Account findByUsername(String username);

    @Insert("insert into account(username,password,type) values (#{username},#{md5Password},#{type})")
    void register(String username, String md5Password, Integer type);

    @Update("update account set avatar=#{imgUrl} where accId=#{accId}")
    void updateAvatar(Integer accId, String imgUrl);
    @Delete("delete from account where accId=#{accId}")
    void deleteById(Integer accId);
}

