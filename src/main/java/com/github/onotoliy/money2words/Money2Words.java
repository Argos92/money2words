package com.github.onotoliy.money2words;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Преобразование денег в письменную форму. Базоый класс.
 *
 * @author Anatoliy Pokhresnyi
 */
public abstract class Money2Words {

    /**
     * Числительные.
     */
    private final List<Measure> measures;

    /**
     * Валюта.
     */
    private final Wallet wallet;

    /**
     * Кноструктор.
     *
     * @param aMeasures Числительные.
     * @param aWallet Валюта.
     */
    protected Money2Words(final List<Measure> aMeasures, final Wallet aWallet) {
        this.measures = aMeasures;
        this.wallet = aWallet;
    }

    /**
     * Преобразвание в письменый формат.
     *
     * @param util Разрад числа. Единица.
     * @param decade Разряд числа. Десяток.
     * @param hundred Разряд числа. Сотня.
     * @param degree Степень.
     * @return Письменый формат.
     */
    protected abstract String wrap(char util,
                                   char decade,
                                   char hundred,
                                   int degree);

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final int money) {
        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final long money) {
        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final float money) {
        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final double money) {
        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final String money) {
        Objects.requireNonNull(money);

        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final BigDecimal money) {
        Objects.requireNonNull(money);

        String[] parts = money.setScale(2, RoundingMode.HALF_DOWN)
                              .toPlainString()
                              .split("\\.");

        StringBuilder whole = new StringBuilder(parts[0]);

        while (whole.length() % DegreeMeasure.HUNDRED != 0) {
            whole.insert(0, "*");
        }

        return wrap(whole.toString().toCharArray(), parts[1].toCharArray());
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param money Число.
     * @return Письменый формат.
     */
    public String wrap(final BigInteger money) {
        Objects.requireNonNull(money);

        return wrap(new BigDecimal(money));
    }

    /**
     * Преобразвание числа в письменый формат.
     *
     * @param whole Целая часть.
     * @param fractional Дробная часть.
     * @return Письменый формат.
     */
    private String wrap(final char[] whole, final char[] fractional) {
        int wLength = whole.length;
        List<String> words = new LinkedList<>();

        for (int i = 0; i < wLength; i = i + DegreeMeasure.HUNDRED) {
            char util = whole[i + 2];
            char decade = whole[i + 1];
            char hundred = whole[i];

            if (hundred == '0' && decade == '0' && util == '0') {
                continue;
            }

            words.add(wrap(hundred, decade, util, wLength - i));
        }

        words.add(wallet.wrapMoney(whole[wLength - 2], whole[wLength - 1]));
        words.add(wrapCoin(fractional));
        words.add(wallet.wrapCoin(fractional[0], fractional[1]));

        return concat(words);
    }

    /**
     * Преобразование монет в правильную форму.
     *
     * @param fractional Дробная часть.
     * @return Правильная форма.
     */
    private String wrapCoin(final char[] fractional) {
        if (fractional[0] == '0' && fractional[1] == '0') {
            return "0";
        }

        return fractional[0] == '0'
            ? String.valueOf(fractional[1])
            : fractional[0] + "" + fractional[1];
    }

    /**
     * Преобразование числа в письменый формат числительного.
     *
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @param degree Степень.
     * @return Письменый формат.
     */
    protected String wrapMeasure(final char decade,
                                 final char util,
                                 final int degree) {
        return measures.stream()
                       .filter(value -> value.verify(degree))
                       .findFirst()
                       .map(value -> value.wrap(decade, util, degree))
                       .orElse("");
    }

    /**
     * Склеивание массива.
     *
     * @param values Массив.
     * @return Результат склеивания.
     */
    protected String concat(final Collection<String> values) {
        return values.stream()
                     .filter(Objects::nonNull)
                     .filter(Predicate.not(String::isEmpty))
                     .collect(Collectors.joining(" "));
    }
}
