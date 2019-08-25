package com.github.onotoliy.money2words;

import org.junit.Test;

public class Money2WordsTest {

    @Test
    public void test() {
        System.out.println(new Money2Words().numberOfWord("**1".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**2".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**3".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**4".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**5".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**6".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**7".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**8".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**9".toCharArray()));

        System.out.println(new Money2Words().numberOfWord("*10".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*11".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*12".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*13".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*14".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*15".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*16".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*17".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*18".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*19".toCharArray()));

        System.out.println(new Money2Words().numberOfWord("*20".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*30".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*40".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*50".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*60".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*70".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*80".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*90".toCharArray()));

        System.out.println(new Money2Words().numberOfWord("123".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**1234".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*12345".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("123456".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**1234567".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("*12345678".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("123456789".toCharArray()));
        System.out.println(new Money2Words().numberOfWord("**1234567890".toCharArray()));
    }

}
