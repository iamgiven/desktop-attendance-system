package StudentMgmtSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class smslog extends JFrame {

    private JPanel mainPanel;
    private JLabel l1, l2;
    private JTextField t1;
    private JPasswordField pass;
    private JButton b1, b2;
    private ImageIcon img;

    public static void main(String[] args) {
        new smslog();
    }

    smslog() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(230, 255, 230));

        img = new ImageIcon(new ImageIcon(getClass().getResource("/StudentMgmtSys/User-icon.png"))
                .getImage().getScaledInstance(150, 212, Image.SCALE_SMOOTH));
        l1 = new JLabel(img);
        l1.setBounds(35, 35, 150, 212);
        mainPanel.add(l1);

        l2 = new JLabel("Username");
        l2.setBounds(230, 50, 90, 40);
        l2.setFont(new Font("Serif", Font.PLAIN, 20));

        l1 = new JLabel("Password");
        l1.setBounds(230, 120, 100, 40);
        l1.setFont(new Font("Serif", Font.PLAIN, 20));

        t1 = new JTextField(30);
        t1.setBounds(320, 50, 230, 35);

        pass = new JPasswordField(10);
        pass.setBounds(320, 120, 230, 35);

        b1 = new JButton("User-Login");
        b1.setBounds(230, 200, 100, 50);
        b1.setBackground(new Color(204, 229, 255));
        b1.setMnemonic('u');

        b2 = new JButton("Administrator-Login");
        b2.setBounds(400, 200, 150, 50);
        b2.setBackground(new Color(204, 229, 255));
        b2.setMnemonic('a');

        mainPanel.add(l2);
        mainPanel.add(t1);
        mainPanel.add(l1);
        mainPanel.add(pass);
        mainPanel.add(b1);
        mainPanel.add(b2);

        add(mainPanel);

        // Menentukan posisi JFrame
        setLocation(200, 100);
        setSize(580, 390);
        setVisible(true);
        setResizable(false);
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userlogin();
        adminlogin();
    }

    public void userlogin() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                if (puname.equals("user") && ppaswd.equals("user")) {
                    // user side view
                    UserSide us = new UserSide();
                    us.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }
        });
    }

    public void adminlogin() {
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                if (puname.equals("admin") && ppaswd.equals("admin")) {
                    // admin side view
                    AdminView av = new AdminView();
                    av.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }
        });
    }
}
