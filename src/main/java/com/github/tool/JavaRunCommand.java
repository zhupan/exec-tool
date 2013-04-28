package com.github.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRunCommand {

    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("please input file name: java -jar xxxx.jar keytool/javac/java/etc");
            }
            Process process = Runtime.getRuntime().exec(args[0]);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("Here is the standard output of the command:\n");
            String line;
            while ((line = stdInput.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((line = stdError.readLine()) != null) {
                System.out.println(line);
            }
            System.exit(0);
        } catch (IOException e) {
            System.out.println("exception happened - here'line what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
