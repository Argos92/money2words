package com.github.onotoliy.money2words;

/**
 * Числительное.
 *
 * @author Anatoliy Pokhresnyi
 */
public interface Measure {

    /**
     * Преобразование числительного в писменную форму.
     *
     * @param decade Разряд числа. Десяток.
     * @param util Разрад числа. Единица.
     * @param degree Степень.
     * @return Числительное в письменной форме.
     */
    String wrap(char decade, char util, int degree);

    /**
     * Проверка соответсвия числительного степень.
     *
     * @param degree Степень.
     * @return Результат проверки. {@code true} - соответсвует, иначе
     *         {@code false}
     */
    boolean verify(int degree);

}
