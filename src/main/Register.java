package main;

import entity.User;
import entity.mapper.UserMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JPanel jpanel;
    private JButton 注册Button;
    private JButton 返回Button;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private UserMapper userMapper = new UserMapper();
    public Register(){
        setTitle("注册");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jpanel);
        setVisible(true);

        注册Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText().trim();
                String password = passwordField1.getText().trim();
                if(!(username.isEmpty() || password.isEmpty())){
                    boolean login = userMapper.register(new User(null, username, password));
                    if(login){
                        dispose();
                        //进入主页
                        JOptionPane.showMessageDialog(new JOptionPane(),"注册成功！！");
                        dispose();
                        new Login();
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"注册失败！！");
                    }
                }
            }
        });

        返回Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

    }
}
