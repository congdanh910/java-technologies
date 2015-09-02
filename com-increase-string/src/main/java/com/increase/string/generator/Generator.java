package com.increase.string.generator;

import java.io.IOException;
import java.math.BigDecimal;

import com.increase.string.files.HandleFile;
import org.apache.commons.lang.StringUtils;

public class Generator {

    public Generator() {
    }

    public String getNextString(String prefix) throws IOException {
        String pre = createPrefix(prefix);
        String next = StringUtils.EMPTY;
        try {
            String last = HandleFile.getLastLine();
            if (last == null) {
                HandleCharset handleCharset = BuildingCharset.buildCharset();
                next = pre + handleCharset.toString(BigDecimal.ZERO);
            } else {
                next = nextString(last, prefix);
            }
            HandleFile.saveLastString(next);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return next;
    }

    private String nextString(String last, String prefix) {
        HandleCharset handleCharset = BuildingCharset.buildCharset();
        return handleCharset.incrementWithPrefix(last, prefix);
    }

    private String createPrefix(String specificPrefix) throws IOException {
        // pick a prefix from our available set, or use the one specified
        String prefix;
        if (specificPrefix == null) {
            prefix = new HandlePrefix().getRandomChar().toString();
        } else {
            prefix = specificPrefix;
        }
        return prefix;
    }
}
