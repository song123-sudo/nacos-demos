package com.sinosoft.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 16602
 */ /*
 *@author
 *16602  2021/10/25 10:30
 */
public class PasswordEncoderUtil {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("0302");
        System.out.println(encode);
    }
}
