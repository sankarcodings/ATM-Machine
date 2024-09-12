package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import DataFetch.BalanceDataFetch;

public class BalanceCheckPage extends BalanceDataFetch
{
    JFrame balanceCheck;
    BalanceCheckPage()
    {
        balanceCheck = new JFrame("SSS ATM --");
        balanceCheck.getContentPane().setBackground(Color.black);

        // balance check title
        JLabel balanceTitle = new JLabel("-- Balance Checking --");
        balanceTitle.setBounds(160, 60, 300, 30);
        balanceTitle.setForeground(Color.white);
        balanceTitle.setFont(new Font("Arial",Font.BOLD,22));

        // enter AccNo
        JLabel accNum = new JLabel("Enter Account Number");
        accNum.setBounds(40, 130, 250, 30);
        accNum.setForeground(Color.white);
        accNum.setFont(new Font("Arial",Font.BOLD,16));

        //Colon1
        JLabel colon1 = new JLabel(":");
        colon1.setForeground(new Color(255,255,255));
        colon1.setBounds(240,134,50,25);
        colon1.setFont(new Font("Arial",Font.BOLD,16));

        //Num TextField
        JTextField numField = new JTextField();
        numField.setBounds(270,133,280,28);
        numField.setBorder(null);
        numField.setFont(new Font("Arial",Font.PLAIN,17));

        // enter pwd
        JLabel loginPwd = new JLabel("Enter Password");
        loginPwd.setBounds(40, 190, 250, 30);
        loginPwd.setForeground(Color.white);
        loginPwd.setFont(new Font("Arial",Font.BOLD,16));

        //colon2
        JLabel colon2 = new JLabel(":");
        colon2.setForeground(new Color(255,255,255));
        colon2.setBounds(240,194,50,25);
        colon2.setFont(new Font("Arial",Font.BOLD,16));

        //login-Pwd TextField
        JTextField loginPwdField = new JTextField();
        loginPwdField.setBounds(270,193,280,28);
        loginPwdField.setBorder(null);
        loginPwdField.setFont(new Font("Arial",Font.PLAIN,17));

        // output - message

        JLabel ouputMess = new JLabel("");
        ouputMess.setBounds(330, 340, 300, 30);
        ouputMess.setForeground(Color.white);
        ouputMess.setFont(new Font("Arial",Font.BOLD,25));

        // submit
        JButton submit = new JButton("- Submit -");
        submit.setBounds(40,253,100,30);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setBorder(null);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = numField.getText();
                String s2 = loginPwdField.getText();
                try
                {
                    if(balanceDataFetch(s1,s2))
                    {
                        int balance = getBalance();
                        ouputMess.setText("Balance : "+balance+"");
                    }
                    else
                    {
                        new AccNumOrPassWarning();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Server Not Reached !!!"+ex);
                }
            }
        });

        // return home page
        JButton returnButton = new JButton("- Return to Home Page -");
        returnButton.setBounds(30,410,300,30);
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font("Arial",Font.BOLD,20));
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setBorder(null);
        returnButton.setBackground(null);

        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                balanceCheck.setVisible(false);
                new HomePage();
            }
        });

        balanceCheck.add(returnButton);
        balanceCheck.add(balanceTitle);
        balanceCheck.add(accNum);
        balanceCheck.add(colon1);
        balanceCheck.add(numField);
        balanceCheck.add(loginPwd);
        balanceCheck.add(colon2);
        balanceCheck.add(loginPwdField);
        balanceCheck.add(submit);
        balanceCheck.add(ouputMess);
        balanceCheck.setLayout(null);
        balanceCheck.setSize(600,600);
        balanceCheck.setVisible(true);
    }
}
