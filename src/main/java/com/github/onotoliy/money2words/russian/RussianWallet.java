package com.github.onotoliy.money2words.russian;

import com.github.onotoliy.money2words.Wallet;

/**
 * Валюта в русском языке.
 *
 * @author Anatoliy Pokhresnyi
 */
public final class RussianWallet implements Wallet {

    /**
     * Российский рубль.
     */
    public static final Wallet RUSSIAN = new RussianWallet(
        "рубль", "рубля", "рублей",
        "копейка", "копейки", "копеек");

    /**
     * Беларуский рубль.
     */
    public static final Wallet BELARUS = new RussianWallet(
        "беларуский рубль", "беларуских рубля", "беларуских рублей",
        "копейка", "копейки", "копеек");

    /**
     * Американский долор.
     */
    public static final Wallet USD = new RussianWallet(
        "доллор", "доллора", "доллоров",
        "цент", "цента", "центов");

    /**
     * Целая часть. Единственое число.
     */
    private final String singularMoney;

    /**
     * Целая часть. Родительный падеж.
     */
    private final String feminineMoney;

    /**
     * Целая часть. Множественное число.
     */
    private final String pluralMoney;

    /**
     * Дробная часть. Единственое число.
     */
    private final String singularCoin;

    /**
     * Дробная часть. Родительный падеж.
     */
    private final String feminineCoin;

    /**
     * Целая часть. Множественное число.
     */
    private final String pluralCoin;

    /**
     * Конструктор.
     *
     * @param aSingularMoney Целая часть. Единственое число.
     * @param aFeminineMoney Целая часть. Родительный падеж.
     * @param aPluralMoney Целая часть. Множественное число.
     * @param aSingularCoin Дробная часть. Единственое число.
     * @param aFeminineCoin Дробная часть. Родительный падеж.
     * @param aPluralCoin Целая часть. Множественное число.
     */
    public RussianWallet(final String aSingularMoney,
                         final String aFeminineMoney,
                         final String aPluralMoney,
                         final String aSingularCoin,
                         final String aFeminineCoin,
                         final String aPluralCoin) {
        this.singularMoney = aSingularMoney;
        this.feminineMoney = aFeminineMoney;
        this.pluralMoney = aPluralMoney;
        this.singularCoin = aSingularCoin;
        this.feminineCoin = aFeminineCoin;
        this.pluralCoin = aPluralCoin;
    }

    /**
     * Преобразование валюты в писменную форму.
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @param singular Единственое число.
     * @param feminine Родительный падеж.
     * @param plural Множественное число.
     * @return Письменная форма.
     */
    private String wrap(final char decade,
                        final char util,
                        final String singular,
                        final String feminine,
                        final String plural) {
        if (decade == '1') {
            return plural;
        }

        if (util == '1') {
            return singular;
        }

        if (util == '2' || util == '3' || util == '4') {
            return feminine;
        }

        return plural;
    }

    @Override
    public String wrapMoney(final char decade, final char util) {
        return wrap(decade, util, singularMoney, feminineMoney, pluralMoney);
    }

    @Override
    public String wrapCoin(final char decade, final char util) {
        return wrap(decade, util, singularCoin, feminineCoin, pluralCoin);
    }
}
