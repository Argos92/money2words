package com.github.onotoliy.money2words;

import com.github.onotoliy.money2words.russian.RussianMoney2Word;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RussianMoney2WordsTest {

    private void testWrap(String expected, String money) {
        Money2Words word = new RussianMoney2Word();

        Assert.assertEquals(expected, word.wrap(money));
        Assert.assertEquals(expected, word.wrap(Float.valueOf(money)));
        Assert.assertEquals(expected, word.wrap(Double.valueOf(money)));
        Assert.assertEquals(expected, word.wrap(Integer.valueOf(money)));
        Assert.assertEquals(expected, word.wrap(Long.valueOf(money)));
        Assert.assertEquals(expected, word.wrap(new BigDecimal(money)));
        Assert.assertEquals(expected, word.wrap(new BigInteger(money)));
    }

    @Test
    public void test() {
        testWrap("один рубль 0 копеек", "1");
        testWrap("два рубля 0 копеек", "2");
        testWrap("три рубля 0 копеек", "3");
        testWrap("четыре рубля 0 копеек", "4");
        testWrap("пять рублей 0 копеек", "5");
        testWrap("шесть рублей 0 копеек", "6");
        testWrap("семь рублей 0 копеек", "7");
        testWrap("восемь рублей 0 копеек", "8");
        testWrap("девять рублей 0 копеек", "9");
        testWrap("десять рублей 0 копеек", "10");
        testWrap("одиннадцать рублей 0 копеек", "11");
        testWrap("двенадцать рублей 0 копеек", "12");
        testWrap("тринадцать рублей 0 копеек", "13");
        testWrap("четырнадцать рублей 0 копеек", "14");
        testWrap("пятьнадцать рублей 0 копеек", "15");
        testWrap("шестьнадцать рублей 0 копеек", "16");
        testWrap("семьнадцать рублей 0 копеек", "17");
        testWrap("восемьнадцать рублей 0 копеек", "18");
        testWrap("девятьнадцать рублей 0 копеек", "19");
        testWrap("двадцать рублей 0 копеек", "20");
        testWrap("двадцать один рубль 0 копеек", "21");
        testWrap("двадцать два рубля 0 копеек", "22");
        testWrap("двадцать три рубля 0 копеек", "23");
        testWrap("двадцать четыре рубля 0 копеек", "24");
        testWrap("двадцать пять рублей 0 копеек", "25");
        testWrap("двадцать шесть рублей 0 копеек", "26");
        testWrap("двадцать семь рублей 0 копеек", "27");
        testWrap("двадцать восемь рублей 0 копеек", "28");
        testWrap("двадцать девять рублей 0 копеек", "29");
        testWrap("тридцать рублей 0 копеек", "30");
        testWrap("сорок рублей 0 копеек", "40");
        testWrap("пятьдесят рублей 0 копеек", "50");
        testWrap("шестьдесят рублей 0 копеек", "60");
        testWrap("семьдесят рублей 0 копеек", "70");
        testWrap("восемьдесят рублей 0 копеек", "80");
        testWrap("девяносто рублей 0 копеек", "90");
        testWrap("сто рублей 0 копеек", "100");
        testWrap("двести рублей 0 копеек", "200");
        testWrap("триста рублей 0 копеек", "300");
        testWrap("четыреста рублей 0 копеек", "400");
        testWrap("пятьсот рублей 0 копеек", "500");
        testWrap("шестьсот рублей 0 копеек", "600");
        testWrap("семьсот рублей 0 копеек", "700");
        testWrap("восемьсот рублей 0 копеек", "800");
        testWrap("девятьсот рублей 0 копеек", "900");
        testWrap("одна тысяча рублей 0 копеек", "1000");
        testWrap("одна тысяча один рубль 0 копеек", "1001");
        testWrap("одна тысяча одиннадцать рублей 0 копеек", "1011");
        testWrap("одна тысяча сто рублей 0 копеек", "1100");
        testWrap("одна тысяча сто один рубль 0 копеек", "1101");
        testWrap("одна тысяча сто десять рублей 0 копеек", "1110");
        testWrap("одна тысяча сто одиннадцать рублей 0 копеек", "1111");
        testWrap("две тысячи рублей 0 копеек", "2000");
        testWrap("три тысячи рублей 0 копеек", "3000");
        testWrap("четыре тысячи рублей 0 копеек", "4000");
        testWrap("пять тысяч рублей 0 копеек", "5000");
        testWrap("шесть тысяч рублей 0 копеек", "6000");
        testWrap("семь тысяч рублей 0 копеек", "7000");
        testWrap("восемь тысяч рублей 0 копеек", "8000");
        testWrap("девять тысяч рублей 0 копеек", "9000");
        testWrap("один миллион рублей 0 копеек", "1000000");
        testWrap("два миллиона рублей 0 копеек", "2000000");
        testWrap("три миллиона рублей 0 копеек", "3000000");
        testWrap("четыре миллиона рублей 0 копеек", "4000000");
        testWrap("пять миллионов рублей 0 копеек", "5000000");
        testWrap("шесть миллионов рублей 0 копеек", "6000000");
        testWrap("семь миллионов рублей 0 копеек", "7000000");
        testWrap("восемь миллионов рублей 0 копеек", "8000000");
        testWrap("девять миллионов рублей 0 копеек", "9000000");
        testWrap("сто двадцать три рубля 0 копеек", "123");
        testWrap("одна тысяча двести тридцать четыре рубля 0 копеек", "1234");
        testWrap("двенадцать тысяч триста сорок пять рублей 0 копеек", "12345");
        testWrap(
            "сто двадцать три тысячи четыреста пятьдесят шесть рублей 0 копеек",
            "123456");
        testWrap(
            "один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь рублей 0 копеек",
            "1234567");
        testWrap(
            "двенадцать миллионов триста сорок пять тысяч шестьсот семьдесят восемь рублей 0 копеек",
            "12345678");

        Money2Words words = new RussianMoney2Word();
        Assert.assertEquals("один рубль 0 копеек", words.wrap("1.00"));
        Assert.assertEquals("один рубль 1 копейка", words.wrap("1.01"));
        Assert.assertEquals("один рубль 20 копеек", words.wrap("1.20"));
        Assert.assertEquals("один рубль 45 копеек", words.wrap("1.45"));

        Assert.assertEquals(
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей 0 копеек",
            words.wrap("123456789"));
        Assert.assertEquals(
            "один миллиард двести тридцать четыре миллиона пятьсот шестьдесят семь тысяч восемьсот девяносто рублей 0 копеек",
            words.wrap("1234567890"));
    }

}
