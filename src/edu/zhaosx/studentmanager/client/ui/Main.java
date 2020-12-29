package edu.zhaosx.studentmanager.client.ui;

import edu.zhaosx.studentmanager.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public  void show(){
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().jpanle1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTable table1;
    private JButton OKButton;
    private JButton searchButton;
    private JButton cancelButton;
    private JButton addButton;
    private JButton deleatButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel jpanle1;

    public Main() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private Student mkStu(){
        Student student = new Student(textField1.getText(),textField2.getText(),textField3.getText());
        return student;
    }
}
