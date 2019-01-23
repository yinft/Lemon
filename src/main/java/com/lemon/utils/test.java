package com.lemon.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/23 15:02
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>(); // 创建一个集合s1
        s1.add("1");
        s1.add("2");
        s1.add("3");

        Set<String> s2 = new HashSet<String>(); // 创建一个集合s2
        s2.add("3");

        s2.add("4");

        s1.addAll(s2); // 将s2中的数据添加到s1中

        for (String str : s1) { // 输出s1
            System.out.print(str);

        }
    }
}