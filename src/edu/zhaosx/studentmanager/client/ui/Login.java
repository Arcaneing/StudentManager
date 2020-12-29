package edu.zhaosx.studentmanager.client.ui;

import edu.zhaosx.studentmanager.util.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField textField1;
    private JPanel panel1;
    private JTextField textField2;
    private JButton loginButton;
    private static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame("Login");
        frame.setTitle("学生管理系统");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();
        int width=dimension.width;
        int height=dimension.height;
        int x=(width-422)/2;
        int y=(height-529)/2;
        frame.setLocation(x, y);
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,200);
        frame.setVisible(true);
    }


    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField1.getText();
                String ps = textField2.getText();
                if(JDBCUtils.login(user,ps)){
                Main m = new Main();
                m.show();
                frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
