package com.company;

public class Main extends Dictionary {

    public static void main(String[] args) {
        DictionaryManagement.createFile();
        DictionaryApplication dictionaryGUI = new DictionaryApplication();
        dictionaryGUI.runApplication();
    }
}
