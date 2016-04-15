package org.chance.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by wqg on 2016/3/18.
 */
public class EncryptUtils {
    private static final String SITE_WIDE_SECRET = "my-secret-key";
    //private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);
    private static final PasswordEncoder encoder = new StandardPasswordEncoder("");

    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.matches(rawPassword, password);
    }

//    public static void main(String[] args) {
//        String s1 = EncryptUtils.encrypt("每次结果都不一样伐?");
//        System.out.println(s1);
//        System.out.println(match("每次结果都不一样伐?",s1));
//        System.out.println(match("每次结果都不一样伐",s1));
//        String s2= EncryptUtils.encrypt("每次结果都不一样伐?");
//        System.out.println(s2);
//        System.out.println(match("每次结果都不一样伐?",s1));
//        //但是把每次结果拿出来进行match，你会发现可以得到true。
//    }

}
