package edu.zhaosx.studentmanager.client.ui;

import edu.zhaosx.studentmanager.Student;
import edu.zhaosx.studentmanager.network.addClientTread;
import edu.zhaosx.studentmanager.util.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JButton editButton;

    public Main() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientTread ac = new addClientTread(4,"stu",mkStu(),"");
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientTread ac = new addClientTread(1,"stu",mkStu(),"");
            }
        });
        deleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientTread ac = new addClientTread(2,"stu",mkStu(),"");
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object> list = JDBCUtils.getDate("stu");
                for(Object s : list){

                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientTread ac = new addClientTread(3,"stu",mkStu(),"");
            }
        });
    }

    private Student mkStu(){
        Student student = new Student(textField1.getText(),textField2.getText(),textField3.getText());
        return student;
    }

}
