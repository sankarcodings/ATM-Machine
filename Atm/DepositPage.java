package Atm;

import DataFetch.DepositDataFetch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DepositPage
{

    JFrame depositAmt;
    DepositPage() {
        depositAmt = new JFrame("SSS ATM --");
        depositAmt.getContentPane().setBackground(Color.black);
        // deposit amt title
        JLabel depositTitle = new JLabel("-- Deposit Amount --");
        depositTitle.setBounds(160, 60, 300, 30);
        depositTitle.setForeground(Color.white);
        depositTitle.setFont(new Font("Arial", Font.BOLD, 22));

        // enter AccNo
        JLabel accNum = new JLabel("Enter Account Number");
        accNum.setBounds(40, 130, 250, 30);
        accNum.setForeground(Color.white);
        accNum.setFont(new Font("Arial", Font.BOLD, 16));

        //Colon1
        JLabel colon1 = new JLabel(":");
        colon1.setForeground(new Color(255, 255, 255));
        colon1.setBounds(240, 134, 50, 25);
        colon1.setFont(new Font("Arial", Font.BOLD, 16));

        //Num TextField
        JTextField numField = new JTextField();
        numField.setBounds(270, 133, 280, 28);
        numField.setBorder(null);
        numField.setFont(new Font("Arial", Font.PLAIN, 17));

        // enter pwd
        JLabel loginPwd = new JLabel("Enter Password");
        loginPwd.setBounds(40, 190, 250, 30);
        loginPwd.setForeground(Color.white);
        loginPwd.setFont(new Font("Arial", Font.BOLD, 16));

        //colon2
        JLabel colon2 = new JLabel(":");
        colon2.setForeground(new Color(255, 255, 255));
        colon2.setBounds(240, 194, 50, 25);
        colon2.setFont(new Font("Arial", Font.BOLD, 16));

        //login-Pwd TextField
        JTextField loginPwdField = new JTextField();
        loginPwdField.setBounds(270, 193, 280, 28);
        loginPwdField.setBorder(null);
        loginPwdField.setFont(new Font("Arial", Font.PLAIN, 17));

        // enter amount
        JLabel enterAmount = new JLabel("Enter Amount");
        enterAmount.setBounds(40, 250, 250, 30);
        enterAmount.setForeground(Color.white);
        enterAmount.setFont(new Font("Arial", Font.BOLD, 16));

        //colon3
        JLabel colon3 = new JLabel(":");
        colon3.setForeground(new Color(255, 255, 255));
        colon3.setBounds(240, 254, 50, 25);
        colon3.setFont(new Font("Arial", Font.BOLD, 16));

        //enter-amt TextField
        JTextField enterAmtField = new JTextField();
        enterAmtField.setBounds(270, 253, 280, 28);
        enterAmtField.setBorder(null);
        enterAmtField.setFont(new Font("Arial", Font.PLAIN, 17));

        // output - message

        JLabel ouputMess = new JLabel("");
        ouputMess.setBounds(160, 373, 300, 30);
        ouputMess.setForeground(Color.white);
        ouputMess.setFont(new Font("Arial", Font.BOLD, 22));

        // submit
        JButton submit = new JButton("- Submit -");
        submit.setBounds(40, 313, 100, 30);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setBorder(null);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = numField.getText();
                String s2 = loginPwdField.getText();
                String s3 = enterAmtField.getText();
                try {
                    if (DepositDataFetch.depositData(s1, s2, s3)) {
                        ouputMess.setText("- Amount Deposited Successfully - ");
                        ouputMess.setBounds(100, 373, 450, 30);
                    } else {
                        new AccNumOrPassWarning();
                    }
                } catch (Exception ex) {
                    System.out.println("Server Not Reached !!! " + ex);
                }
            }
        });

        // return home page
        JButton returnButton = new JButton("- Return to Home Page -");
        returnButton.setBounds(20,470,300,30);
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font("Arial",Font.BOLD,20));
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setBorder(null);
        returnButton.setBackground(null);

        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                depositAmt.setVisible(false);
                new HomePage();
            }
        });

        depositAmt.add(accNum);
        depositAmt.add(colon1);
        depositAmt.add(numField);
        depositAmt.add(loginPwd);
        depositAmt.add(colon2);
        depositAmt.add(loginPwdField);
        depositAmt.add(enterAmount);
        depositAmt.add(colon3);
        depositAmt.add(enterAmtField);
        depositAmt.add(depositTitle);
        depositAmt.add(submit);
        depositAmt.add(ouputMess);
        depositAmt.add(returnButton);
        depositAmt.setLayout(null);
        depositAmt.setSize(600, 600);
        depositAmt.setVisible(true);
    }
}