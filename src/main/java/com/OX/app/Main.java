package com.OX.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
public class Main {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = null;
        if (args.length == 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                scanner = new Scanner(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        Menu menu = new Menu(new InputProvider(scanner));
        menu.start();

    }

}
