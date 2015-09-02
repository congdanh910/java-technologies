package com.increase.string.generator;

import java.util.ArrayList;
import java.util.List;

public class BuildingCharset {

    public static final String DEFAULT_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public BuildingCharset() {
    }

    public static HandleCharset buildCharset() {
        List<Character> charList = createCharacterList(DEFAULT_CHARACTERS);
        return new HandleCharset(charList);
    }

    public static List<Character> createCharacterList(String chars) {
        List<Character> charList = new ArrayList<Character>();
        for (Character character : chars.toCharArray()) {
            charList.add(character);
        }
        return charList;
    }
}
