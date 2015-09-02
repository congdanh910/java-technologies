package com.increase.string.generator;

import java.io.IOException;
import java.math.BigDecimal;

import com.increase.string.files.HandleFile;
import org.apache.commons.lang.StringUtils;

public class Generator {

    public Generator() {
    }

    public String pickStub(String specificPrefix) throws IOException {
        String prefix = createPrefix(specificPrefix);
        String nextStub = StringUtils.EMPTY;
        try {
            String lastStub = HandleFile.getLastLine();
            if (lastStub == null) {
                HandleCharset handleCharset = BuildingCharset.buildCharset();
                nextStub = prefix + handleCharset.toString(BigDecimal.ZERO);
            } else {
                nextStub = nextStub(lastStub, prefix);
            }
            HandleFile.saveLastString(nextStub);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nextStub;
    }

    private String nextStub(String stub, String prefix) {
        HandleCharset handleCharset = BuildingCharset.buildCharset();
        return handleCharset.incrementStringWithPrefix(stub, prefix);
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
