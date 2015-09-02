package com.increase.string.generator;


import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class HandleCharset {

    private List<Character> charset;

    public HandleCharset(final List<Character> charset) {
        this.charset = charset;
    }

    public int compare(String a, String b) {
        if (toNumber(a).compareTo(toNumber(b)) == 1) {
            return 1;
        } else if (a.equals(b)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Take a string in this charset, convert it into an integer.
     */
    public BigDecimal toNumber(String str) {
        int base = this.charset.size();
        int exponent = 0;
        BigDecimal val = BigDecimal.ZERO;
        char[] chars = str.toCharArray();
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            index = this.charset.indexOf(chars[i]);
            if (index == -1) {
                throw new IllegalArgumentException("Character '" + chars[i]);
            }
            val = val.add(BigDecimal.valueOf(Math.pow(base, exponent) * index));
            exponent += 1;
        }
        return val;
    }

    /**
     * Take an integer, translate it into a string in this charset.
     */
    public String toString(BigDecimal number) {
        int base = this.charset.size();
        int max_exponent = 0;
        BigDecimal diff = BigDecimal.ZERO;

        while (diff.compareTo(BigDecimal.ZERO) >= 0) {
            diff = number.subtract(BigDecimal.valueOf(Math.pow(base, max_exponent) * base));
            max_exponent += 1;
        }
        max_exponent -= 1;

        String str = StringUtils.EMPTY;
        int index = 0;
        for (int exponent = max_exponent; exponent >= 0; exponent--) {
            diff = BigDecimal.ZERO;
            index = 0;
            // find the maximum value we can put in this column without exceeding the number
            while (diff.compareTo(BigDecimal.ZERO) >= 0 && index < base) {
                index += 1;
                diff = number.subtract(BigDecimal.valueOf(Math.pow(base, exponent) * index));
            }
            // record the index before we exceeded the number, then move to the next column
            str = str + this.charset.get(index - 1);
            number = number.subtract(BigDecimal.valueOf(Math.pow(base, exponent) * (index - 1)));
        }
        return str;
    }

    public String increase(String str) {
        BigDecimal currentAsInt = toNumber(str);
        BigDecimal nextAsInt = currentAsInt.add(BigDecimal.ONE);
        return toString(nextAsInt);
    }

    public String incrementWithPrefix(String before, String prefix) {
        String after = increase(before);
        // if the first character of the string has changed, format a new number entirely
        if (before.charAt(0) == after.charAt(0)) {
            return after;
        } else {
            return prefix + StringUtils.repeat(this.charset.get(0).toString(), after.length());
        }
    }

}
