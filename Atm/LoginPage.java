package Atm;

import SQl.SqlConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends SqlConnection
{
    JFrame loginPage;
    LoginPage(){
        loginPage = new JFrame("SSS ATM --");
        loginPage.getContentPane().setBackground(Color.black);

        // welcome Login page
        JLabel loginTitle = new JLabel("-- Welcome to Our Login Page --");
        loginTitle.setBounds(130, 60, 330, 30);
        loginTitle.setForeground(Color.white);
        loginTitle.setFont(new Font("Arial",Font.BOLD,22));

        //Account Number
        JLabel accNum = new JLabel("Enter Account Number");
        accNum.setBounds(40, 150, 250, 30);
        accNum.setForeground(Color.white);
        accNum.setFont(new Font("Arial",Font.BOLD,16));

        //Colon1
        JLabel colon1 = new JLabel(":");
        colon1.setForeground(new Color(255,255,255));
        colon1.setBounds(240,154,50,25);
        colon1.setFont(new Font("Arial",Font.BOLD,16));

        //Num TextField
        JTextField numField = new JTextField();
        numField.setBounds(270,153,280,28);
        numField.setBorder(null);
        numField.setFont(new Font("Arial",Font.PLAIN,17));

        // login - pwd
        JLabel loginPwd = new JLabel("Enter Password");
        loginPwd.setBounds(40, 210, 250, 30);
        loginPwd.setForeground(Color.white);
        loginPwd.setFont(new Font("Arial",Font.BOLD,16));

        //colon2
        JLabel colon2 = new JLabel(":");
        colon2.setForeground(new Color(255,255,255));
        colon2.setBounds(240,214,50,25);
        colon2.setFont(new Font("Arial",Font.BOLD,16));

        //login-Pwd TextField
        JTextField loginPwdField = new JTextField();
        loginPwdField.setBounds(270,213,280,28);
        loginPwdField.setBorder(null);
        loginPwdField.setFont(new Font("Arial",Font.PLAIN,17));

        //Login Button
        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(40,270,100,30);
        loginbutton.setForeground(Color.black);
        loginbutton.setFont(new Font("Arial",Font.BOLD,18));
        loginbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginbutton.setBorder(null);

        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s1 = numField.getText();
                String s2 = loginPwdField.getText();
                if(eightDigit(s1))
                {
                    if(checkPassword(s2))
                    {
                        try
                        {
                            if(loginDataFetch(s1,s2))
                            {
                                loginPage.setVisible(false);
                                new HomePage();
                            }
                            else
                            {
                                new AccNumOrPassWarning();
                            }
                        }
                        catch (Exception ex)
                        {
                            System.out.println("No records Match !!!" + ex);

                        }
                    }
                    else
                    {
                        new WarningPassword();
                    }
                }
                else
                {
                    WarningAccountNum.WarningAccNum();
                }
            }
        });

        // already have
        JLabel alreadyHave = new JLabel("If you don't have account , you want to create a new account ");
        alreadyHave.setFont(new Font("Arial",Font.PLAIN,14));
        alreadyHave.setForeground(Color.white);
        alreadyHave.setBounds(40,320,600,30);

        // Create account
        JButton createAccbutton = new JButton("Create New Account");
        createAccbutton.setBounds(28,360,200,30);
        createAccbutton.setForeground(Color.white);
        createAccbutton.setFont(new Font("Arial",Font.BOLD,18));
        createAccbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccbutton.setBorder(null);
        createAccbutton.setBackground(null);

        createAccbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage.setVisible(false);
                new SigninPage();
            }
        });

        loginPage.add(loginTitle);
        loginPage.add(accNum);
        loginPage.add(colon1);
        loginPage.add(numField);
        loginPage.add(loginPwd);
        loginPage.add(colon2);
        loginPage.add(loginPwdField);
        loginPage.add(loginbutton);
        loginPage.add(alreadyHave);
        loginPage.add(createAccbutton);
        loginPage.setLayout(null);
        loginPage.setSize(600,600);
        loginPage.setVisible(true);
    }
}
