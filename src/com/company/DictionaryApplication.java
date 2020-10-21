package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryApplication implements ActionListener {
    private JPanel panel;
    private JTextField addWordBar;
    private JTextField addDefBar;
    private JTextField deleteBar;
    private JButton addButton;
    private JButton deleteButton;
    private JTextArea outputArea;
    private JTextArea searchKey;
    private JButton searchButton;
    private JTextField searchBar;
    private JButton showAllButton;

    private void action() {
        addButton.addActionListener(e -> {
            String w = addWordBar.getText();
            String d = addDefBar.getText();
            DictionaryManagement.insertFromCommandline(w, d);
            outputArea.setText("Thêm từ: " + w);
            addDefBar.setText("");
            addWordBar.setText("");
        });

        deleteButton.addActionListener(e -> {
            outputArea.setText("");
            String w = deleteBar.getText();
            DictionaryManagement.deleteWord(w);
            outputArea.setText("Xoá từ: " + w);
            deleteBar.setText("");
        });

        searchButton.addActionListener(e -> {
            outputArea.setText("");
            searchKey.setText("");
            String w = searchBar.getText();
            outputArea.setText(DictionaryManagement.dictionaryLookup(w));
            searchKey.setText(searchKey.getText() + DictionaryCommandline.dictionarySearcher(w));
            searchBar.setText("");
        });

        showAllButton.addActionListener(e -> {
            searchKey.setText("");
            outputArea.setText("");
            outputArea.setText("Danh sách các từ:" + "\n");
            outputArea.setText(outputArea.getText() + "" + DictionaryCommandline.showAllWord() + "\n");

        });
    }

    public void runApplication() {
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Từ điển Anh-Việt");
        frame.pack();
        frame.setVisible(true);
        outputArea.setEditable(false);
        searchKey.setEditable(false);
        action();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
