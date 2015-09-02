package com.increase.string.generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.RandomUtils;

public class HandlePrefix {

    private static String DEFAULT_CONFIG_FILE = "charset.txt";

    private static List<Character> charset;

    public HandlePrefix() throws IOException {
        String charsetFromFile = null;
        try {
            charsetFromFile = FileUtils.readFileToString(new File(DEFAULT_CONFIG_FILE), "UTF-8");
        } catch (IOException ex) {
            System.out.println("Can not read charset from file path:" + DEFAULT_CONFIG_FILE + ". Use default charset.");
        }

        if (charsetFromFile == null) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE);
            Scanner scanner = new Scanner(is, "UTF-8");
            if (scanner.hasNext()) {
                charsetFromFile = scanner.next();
            }
            scanner.close();

            if (charsetFromFile == null) {
                throw new IOException("Can not find any charset file.");
            }
        }

        charsetFromFile = charsetFromFile.replaceAll("\\s+", "").replaceAll("\r", "").replaceAll("\n", "");
        charset = BuildingCharset.createCharacterList(charsetFromFile);
    }

    public List<Character> getAllChars() {
        return charset;
    }

    public Character getRandomChar() {
        return charset.get(RandomUtils.nextInt(charset.size()));
    }

}
