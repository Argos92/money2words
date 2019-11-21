package com.github.onotoliy.money2words;

/**
 * Валюта.
 *
 * @author Anatoliy Pokhresnyi
 */
public interface Wallet {

    /**
     * Преобразование валюты в писменную форму.
     *
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @return Валюта в письменной форме.
     */
    String wrapMoney(char decade, char util);

    /**
     * Преобразование валюты в писменную форму.
     *
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @return Валюта в письменной форме.
     */
    String wrapCoin(char decade, char util);
}
