package com.project.onlineTeach.Controller;
import com.project.onlineTeach.DTO.ReqUserLogin;
import com.project.onlineTeach.Util.JwtUtil;
import com.project.onlineTeach.Util.Md5Util;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Account;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.AccountService;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Delete;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/account")
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@RequestBody Account uaccount) {
        /**
         * 用于用户注册
         */
        String username = uaccount.getUsername();
        String password = uaccount.getPassword();
        int type = uaccount.getType();

        Account account = accountService.findByUsername(username);
        if (account == null) {
            accountService.register(username, password,type);
            return Result.success();
        } else {
            return Result.error("用户名被占用");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody ReqUserLogin reqUserLogin) {
        /**
         * 用户登陆
         */
        String username = reqUserLogin.getUsername();
        String password = reqUserLogin.getPassword();
        Account account = accountService.findByUsername(username);
        if (account == null) {
            return Result.error("用户不存在!");
        }
        String MD5password = account.getPassword();
        if (MD5password.equals(Md5Util.getMD5String(password))) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", account.getAccId());
            claims.put("username", account.getUsername());
            claims.put("password", account.getPassword());
            String token = JwtUtil.genToken(claims);
            //将JWT存储至Redis
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(token, token, 24000, TimeUnit.HOURS);
              return Result.success(token);
        } else {
            return Result.error("密码错误！");
        }

    }





    @PatchMapping("/avatar")
    public Result updateAvatar(@RequestParam @URL String imgUrl) {
        /**
         * 头像上传
         */

        accountService.updateAvatar(imgUrl);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public  Result deleteById(@RequestParam Integer accId){
        /**
         * 用户删除
         */
        accountService.deleteById(accId);
        return Result.success();

    }
    @GetMapping
    public Result getInfo() {
        /**
         * 获取用户信息
         */
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        Account user = accountService.findByUsername(username);
        return Result.success(user);
    }
}
