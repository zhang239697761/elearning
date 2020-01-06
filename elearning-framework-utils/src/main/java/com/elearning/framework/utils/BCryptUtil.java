package com.elearning.framework.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 加密工具类
 */
public class BCryptUtil {
    /**
     * 对字符串加密
     * @param str
     * @return
     */
    public static String encode(String str){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPass = passwordEncoder.encode(str);
        return hashPass;
    }

    /**
     * 验证密码是否和已加密对象字符串匹配
     * @param str
     * @param hashPass
     * @return
     */
    public static boolean matches(String str,String hashPass){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean f = passwordEncoder.matches(str, hashPass);
        return f;
    }
}
