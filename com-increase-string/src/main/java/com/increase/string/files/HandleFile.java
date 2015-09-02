package com.increase.string.files;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * Created by CongDanh on 9/2/15.
 */
public class HandleFile {
    private static final String FILE_SAVE = "last.txt";

    public static String getLastLine() {
        try {
            File file = new File(FILE_SAVE);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(file);
            BufferedReader buffered = new BufferedReader(reader);
            String line;
            String last = StringUtils.EMPTY;
            while ((line = buffered.readLine()) != null) {
                if (StringUtils.isNotBlank(line)) {
                    last = line;
                }
            }
            buffered.close();
            reader.close();
            return last;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    public static void saveLastString(final String data) {
        try {
            if (StringUtils.isBlank(data)) {
                return;
            }
            boolean fileExists = true;
            File file = new File(FILE_SAVE);
            if (!file.exists()) {
                fileExists = false;
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter buffered = new BufferedWriter(writer);
            if (!fileExists) {
                buffered.write(data);
            } else {
                buffered.write("\n" + data);
            }
            buffered.close();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
