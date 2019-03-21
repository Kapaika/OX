package com.OX.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
public class StartingMain {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        if (args.length == 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line).append(System.lineSeparator());
                }
                Menu menu = new Menu(new InputProvider(new Scanner(stringBuilder.toString())));
                menu.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Menu menu = new Menu(new InputProvider(new Scanner(System.in)));
            menu.start();
        }

    }

}
