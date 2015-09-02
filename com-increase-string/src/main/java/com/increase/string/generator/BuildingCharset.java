package com.increase.string.generator;

import java.util.ArrayList;
import java.util.List;

public class BuildingCharset {

    public static final String DEFAULT_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public BuildingCharset() {
    }

    public static HandleCharset buildCharset() {
        String characters = DEFAULT_CHARS;
        List<Character> charList = createCharacterList(characters);
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
