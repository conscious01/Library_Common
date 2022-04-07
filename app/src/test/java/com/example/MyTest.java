package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * @author apple
 * @since 13/2/2022 12:11 pm
 */
public class MyTest {


    @Test
    public void testNull() {
        String a = "1";
        String b = null;
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
    }


    @Test
    public void solution() {
        List<String> urls = new ArrayList<>();
        urls.add("33");
        urls.add("www.baidu.com");
        urls.add("http:/www.baidu.com");
        urls.add("http://www.xx.com/");
        urls.add("http://www.xx.com");
        urls.add("https://www.xx.com/");
        urls.add("https://www.xx.com");
        urls.add("http://192.168.0.1");
        urls.add("http://192.168.0.1/");
        urls.add("http://192.168.0.1:8080/");

        urls.add("http://192.168.0.1:8080");

        urls.add("http://192.168.1:8080");
        urls.add("http://192.168.0.1:");

        for (String s : urls) {
            System.out.println(s + "是否是域名或者IP地址 = " + ifAu(s));
        }


    }

    public int getNonRepeatNumbers(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        int result = 0;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            resultList.add(String.valueOf(str.charAt(i)));
        }
        System.out.println(resultList);

        return result;
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    public boolean ifAu(String urls) {
        boolean isurl;
//        String regex = "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&%\\$#\\=~])*$";

        String regex = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

//        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
//                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";// 设置正则表达式

        Pattern pat = Pattern.compile(regex.trim());// 比对
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();// 判断是否匹配
//        LogUtils.d("url = " + urls + " | is url = " + isurl);
        return isurl;


    }
}
