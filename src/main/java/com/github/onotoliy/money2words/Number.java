package com.github.onotoliy.money2words;

public class Number {

    public static String numberOfWord(boolean female, char[] symbols) {
        return hundredNumberOfWord(symbols[0]) + decadeNumberOfWord(symbols[1], symbols[2], female);
    }

    private static String utilNumberOfWord(char symbol, boolean female) {
        switch (symbol) {
            case '0':
                return "ноль";
            case '1':
                return female ? "одна" : "один";
            case '2':
                return female ? "две" : "два";
            case '3':
                return "три";
            case '4':
                return "четыре";
            case '5':
                return "пять";
            case '6':
                return "шесть";
            case '7':
                return "семь";
            case '8':
                return "восемь";
            case '9':
                return "девять";
            default:
                return "";
        }
    }

    private static String decadeNumberOfWord(char decade, char util, boolean female) {
        if (decade == '1') {

            if (util == '0') {
                return "десять";
            }

            if (util == '2') {
                return "двенадцать";
            }

            if (util == '4') {
                return "четырнадцать";
            }

            if (util == '6') {
                return "четырнадцать";
            }

            return utilNumberOfWord(util, false) + "надцать";
        }

        String utilNumberOfWord = utilNumberOfWord(util, female);

        if (decade == '*') {
            return utilNumberOfWord;
        }

        if (decade == '4') {
            return "сорок" + utilNumberOfWord;
        }

        if (decade == '9') {
            return "девяносто" + utilNumberOfWord;
        }

        return utilNumberOfWord(decade, false) + utilNumberOfWord;
    }

    private static String hundredNumberOfWord(char symbol) {
        if (symbol == '*') {
            return "";
        }

        if (symbol == '1') {
            return "сто";
        }

        if (symbol == '2') {
            return "двести";
        }

        if (symbol == '3' || symbol == '4') {
            return utilNumberOfWord(symbol, false) + "сто";
        }

        return utilNumberOfWord(symbol, false) + "сот";
    }
}
