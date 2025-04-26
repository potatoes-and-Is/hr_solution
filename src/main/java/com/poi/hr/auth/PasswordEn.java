package com.poi.hr;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEn {
    public static void main(String[] args) {
        // 1. PasswordEncoder 생성
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 2. 암호화할 비밀번호 설정
        String rawPassword = "1234";  // 여기에 원하는 비밀번호 입력

        // 3. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 4. 결과 출력
        System.out.println("원본 비밀번호: " + rawPassword);
        System.out.println("암호화된 비밀번호: " + encodedPassword);
    }
}
