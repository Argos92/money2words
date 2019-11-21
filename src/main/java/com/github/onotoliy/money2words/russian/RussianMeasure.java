package com.github.onotoliy.money2words.russian;

import com.github.onotoliy.money2words.DegreeMeasure;
import com.github.onotoliy.money2words.Measure;

/**
 * Числительное в русском языке.
 *
 * @author Anatoliy Pokhresnyi
 */
public final class RussianMeasure implements Measure {

    /**
     * Степень.
     */
    private final int degree;

    /**
     * Числительное.
     */
    private final String name;

    /**
     * Конструктор.
     *
     * @param aDegree Степень.
     * @param aName Числительное.
     */
    public RussianMeasure(final int aDegree, final String aName) {
        degree = aDegree;
        name = aName;
    }

    @Override
    public String wrap(final char decade, final char util, final int length) {
        boolean isHundred = length == DegreeMeasure.THOUSAND;

        if (decade == '1') {
            return isHundred ? name : name + "ов";
        }

        if (util == '1') {
            return isHundred ? name + "а" : name;
        }

        if (util == '2' || util == '3' || util == '4') {
            return isHundred ? name + "и" : name + "а";
        }

        return isHundred ? name : name + "ов";
    }

    @Override
    public boolean verify(final int length) {
        return degree == length;
    }
}
