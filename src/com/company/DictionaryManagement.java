package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    static Word newWord = new Word();

    // tham khảo w3schools;
    public static void createFile() {
        try {
            File newFile = new File("dictionaries.txt");
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File Already Exist.");
            }

        } catch (IOException e) {
            System.out.println("An Error has occurred");
            e.printStackTrace();
        }
    }

    // tham khảo w3schools;
    public static void dictionaryExportToFile(String word, String def) {
        try {
            FileWriter myWriter = new FileWriter("dictionaries.txt", true);
            if (Objects.equals(word, "") && Objects.equals(def, "")) {
                myWriter.close();
                return;
            }
            myWriter.write(word + " " + def + "\n");
            myWriter.close();

        } catch (Exception e) {
            System.out.println("An Error has occurred");
            e.printStackTrace();
        }
    }

    public static void insertFromCommandline(String w, String d) {
        newWord.setWord_target(w);
        newWord.setWord_explain("=" + " " + d);
        map.put(newWord.getWord_target(), newWord.getWord_explain());
        dictionaryExportToFile(newWord.getWord_target(), newWord.getWord_explain());
    }

    public static String search(String word) {
        List<String> store = new ArrayList<>();
        int i = 0;
        Scanner sc = null;
        File filePath = new File("dictionaries.txt");

        try {
            sc = new Scanner(filePath);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                if (data[i].equalsIgnoreCase(word)) {
                    sc.close();
                    return "Từ và nghĩa của từ: \n" + line;
                }
                if (data[i].contains(word)) {
                    store.add(data[i]);
                }
            }
            sc.close();
            return "Từ này hiện tại chưa có trong từ điển";

        } catch (Exception e) {
            return "An Error has occurred";
        }
    }

    public static String dictionaryLookup(String word) {
        return fixArrayList(search(word));
    }

    public static void delete(String word) {
        int i = 0;
        File oldFile = new File("dictionaries.txt");
        File newFile = new File("new.txt");
        Scanner sc = null;
        try {
            FileWriter fw = new FileWriter("new.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            sc = new Scanner(oldFile);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                if (!(data[i].equalsIgnoreCase(word))) {
                    pw.println(line);
                }
            }
            sc.close();
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump = new File("dictionaries.txt");
            newFile.renameTo(dump);

        } catch (Exception e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    public static void deleteWord(String word) {
        delete(word);
    }

    public static String fixArrayList(String s) {
        s = s.replace("[", "").replace("]", "").replace(", ", "\n");
        return s;
    }

}
