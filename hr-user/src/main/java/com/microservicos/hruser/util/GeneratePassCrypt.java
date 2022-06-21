package com.microservicos.hruser.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassCrypt {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("BCRYPT: " + bCryptPasswordEncoder.encode("123456"));
    }
}
