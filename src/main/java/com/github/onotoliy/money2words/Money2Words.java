package com.github.onotoliy.money2words;

public class Money2Words {

    public String numberOfWord(char[] symbols) {
        StringBuilder word = new StringBuilder();

        for (int i = 0 ; i < symbols.length; i = i + 3) {
            char util = symbols[i + 2];
            char decade = symbols[i + 1];
            char hundred = symbols[i];

            boolean isHundred = symbols.length - i > 3 && symbols.length - i < 7;

            word.append(" ")
                .append(hundredNumberOfWord(hundred))
                .append(" ")
                .append(decadeNumberOfWord(decade, util, isHundred))
                .append(" ")
                .append(measureOfWord(decade, util, isHundred, symbols.length - i));
        }

        return word.toString()
                   .trim()
                   .replaceAll(" {2}", " ");
    }

    private String utilNumberOfWord(char symbol, boolean female) {
        switch (symbol) {
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

    private String decadeNumberOfWord(char decade, char util, boolean female) {
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
            return "сорок " + utilNumberOfWord;
        }

        if (decade == '9') {
            return "девяносто " + utilNumberOfWord;
        }

        return utilNumberOfWord(decade, false) + "дцать " + utilNumberOfWord;
    }

    private String hundredNumberOfWord(char symbol) {
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

    private String measureOfWord(char decade, char util, boolean isHundred, int length) {
        if (length < 4) {
            return "";
        }

        String measure = measureOfWord(length);

        if (decade == '1') {
            return isHundred ? measure : measure + "ов";
        }

        if (util == '1') {
            return isHundred ? measure + "а" : measure;
        }

        if (util == '2' || util == '3' || util == '4' || util == '5') {
            return isHundred ? measure + "и" : measure + "а";
        }

        return isHundred ? measure : measure + "ов";
    }

    private String measureOfWord(int length) {
        if (length < 7) {
            return "тысяч";
        }

        if (length < 10) {
            return "миллион";
        }

        if (length < 13) {
            return "миллиард";
        }

        if (length < 16) {
            return "триллион";
        }

        if (length < 19) {
            return "квадриллион";
        }

        if (length < 22) {
            return "квинтиллион";
        }

        if (length < 25) {
            return "секстиллион";
        }

        if (length < 28) {
            return "септиллион";
        }

        if (length < 31) {
            return "октиллион";
        }

        if (length < 34) {
            return "нониллион";
        }

        if (length < 37) {
            return "дециллион";
        }

        throw new IllegalArgumentException();
    }
}
