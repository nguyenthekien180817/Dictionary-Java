package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {

    public static String printAll() {
        List<String> printAll = new ArrayList<>();
        File filePath = new File("dictionaries.txt");
        Scanner sc = null;

        try {
            sc = new Scanner(filePath);
            while (sc.hasNext()) {
                printAll.add(sc.nextLine());
            }

        } catch (Exception e) {
            System.out.println("An Error has occurred");
            e.printStackTrace();
        }
        sc.close();
        return String.valueOf(printAll);
    }

    public static String showAllWord() {
        return DictionaryManagement.fixArrayList(printAll());
    }

    public static String search(String word) {
        File filePath = new File("dictionaries.txt");
        List<String> store = new ArrayList<>();
        Scanner sc = null;

        try {
            int i = 0;
            sc = new Scanner(filePath);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                if (data[i].contains(word)) {
                    store.add(data[i]);
                }
            }
            if (word.equals("")) {
                sc.close();
                return "";
            }
            sc.close();
            return String.valueOf(store);

        } catch (Exception e) {
            return "An Error has occurred";
        }

    }

    public static String dictionarySearcher(String word){
        return DictionaryManagement.fixArrayList(search(word));
    }

    public static void dictionaryBasic(String w, String d) {
        Scanner scanner = new Scanner(System.in);
        DictionaryManagement.insertFromCommandline(w,d);
        DictionaryCommandline.showAllWord();
        scanner.close();
    }
}
