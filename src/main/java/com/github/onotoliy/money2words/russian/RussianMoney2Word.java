package com.github.onotoliy.money2words.russian;

import com.github.onotoliy.money2words.DegreeMeasure;
import com.github.onotoliy.money2words.Measure;
import com.github.onotoliy.money2words.Money2Words;
import com.github.onotoliy.money2words.Wallet;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Преобразование денег в письменную форму на русском языке.
 *
 * @author Anatoliy Pokhresnyi
 */
public final class RussianMoney2Word extends Money2Words {

    /**
     * Числительные.
     */
    private static final List<Measure> MEASURES = List.of(
        new RussianMeasure(DegreeMeasure.THOUSAND, "тысяч"),
        new RussianMeasure(DegreeMeasure.MILLION, "миллион"),
        new RussianMeasure(DegreeMeasure.BILLION, "миллиард"),
        new RussianMeasure(DegreeMeasure.TRILLION, "триллион"),
        new RussianMeasure(DegreeMeasure.QUADRILLION, "квадриллион"),
        new RussianMeasure(DegreeMeasure.QUINTILLION, "квинтиллион"),
        new RussianMeasure(DegreeMeasure.SEXTILLION, "секстиллион"),
        new RussianMeasure(DegreeMeasure.SEPTILLION, "септиллион"),
        new RussianMeasure(DegreeMeasure.OCTILLION, "октиллион"),
        new RussianMeasure(DegreeMeasure.NONILLION, "нониллион"),
        new RussianMeasure(DegreeMeasure.DECILLION, "дециллион"));

    /**
     * Конструктор.
     */
    public RussianMoney2Word() {
        this(RussianWallet.RUSSIAN);
    }

    /**
     * Конструктор.
     *
     * @param wallet Валюта.
     */
    public RussianMoney2Word(final Wallet wallet) {
        super(MEASURES, wallet);
    }

    @Override
    protected String wrap(final char hundred,
                          final char decade,
                          final char util,
                          final int degree) {

        boolean female = degree == DegreeMeasure.THOUSAND;

        return concat(List.of(
            wrapHundred(hundred),
            wrapDecade(decade, util, female),
            wrapMeasure(decade, util, degree)));
    }

    /**
     * Преобразование единицы в письменную форму.
     *
     * @param util Разрад числа. Единица.
     * @param female Склонение в женском роде.
     * @return Письменная форма.
     */
    private String wrapUtil(final char util, final boolean female) {
        switch (util) {
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

    /**
     * Преобразование десятка в письменную форму.
     *
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @param female Склонение в женском роде.
     * @return Письменная форма.
     */
    private String wrapDecade(final char decade,
                              final char util,
                              final boolean female) {
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

            return wrapUtil(util, false) + "надцать";
        }

        String utilNumberOfWord = wrapUtil(util, female);
        BiFunction<String, String, String> concat = (prefix, suffix) ->
            suffix.isEmpty() ? prefix : prefix + " " + suffix;

        if (decade == '*' || decade == '0') {
            return utilNumberOfWord;
        }

        if (decade == '2' || decade == '3') {
            return concat.apply(
                wrapUtil(decade, false) + "дцать", utilNumberOfWord);
        }

        if (decade == '4') {
            return concat.apply("сорок", utilNumberOfWord);
        }

        if (decade == '9') {
            return concat.apply("девяносто", utilNumberOfWord);
        }

        return concat.apply(
            wrapUtil(decade, false) + "десят", utilNumberOfWord);
    }

    /**
     * Преобразование сотни в письменную форму.
     *
     * @param hundred Разряд числа. Сотня.
     * @return Письменная форма.
     */
    private String wrapHundred(final char hundred) {
        if (hundred == '*' || hundred == '0') {
            return "";
        }

        if (hundred == '1') {
            return "сто";
        }

        if (hundred == '2') {
            return "двести";
        }

        if (hundred == '3' || hundred == '4') {
            return wrapUtil(hundred, false) + "ста";
        }

        return wrapUtil(hundred, false) + "сот";
    }

}
