package main;

import entity.User;
import entity.mapper.UserMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel jpanel;
    private JTextField textField1;
    private JButton 登录Button;
    private JButton 注册Button;
    private JPasswordField passwordField1;

    private UserMapper userMapper = new UserMapper();

    public Login(){
        setTitle("登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jpanel);
        setVisible(true);

        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText().trim();
                String password = passwordField1.getText().trim();
                if(!(username.isEmpty() || password.isEmpty())){
                    boolean login = userMapper.login(new User(null, username, password));
                    if(login){
                        dispose();
                        //进入主页
                        new Main();
                    }else{
                        JOptionPane.showMessageDialog(new JOptionPane(),"登录失败，请重新登录");
                    }
                }
            }
        });

        注册Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Register();
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
