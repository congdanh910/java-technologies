package com.increase.string.main;

import com.increase.string.files.HandleFile;
import com.increase.string.generator.Generator;

import java.io.IOException;

/**
 * Created by CongDanh on 9/2/15.
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
//        HandleFile.saveLastString("Ngan");
//        String lastLine = HandleFile.getLastLine();
//        System.out.println(lastLine);
        Generator generator = new Generator();
        for (int i = 0; i <= 1000; i++) {
            String createString = generator.pickStub(null);
            System.out.println("createString : " + createString);
        }
    }
}
