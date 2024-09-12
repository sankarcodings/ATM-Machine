package Atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class HomePage
{
    JFrame homePage;
    HomePage()
    {
        homePage = new JFrame("SSS ATM --");
        homePage.getContentPane().setBackground(Color.black);
        // select process
        JLabel selectProcess = new JLabel("- Select Your Process -");
        selectProcess.setBounds(170,90,300,30);
        selectProcess.setForeground(Color.white);
        selectProcess.setFont(new Font("Arial",Font.BOLD,22));

        //Withdrawal button
        JButton withdrawalButton = new JButton("- Cash Withdrawal -");
        withdrawalButton.setBounds(170,150,240,30);
        withdrawalButton.setForeground(Color.black);
        withdrawalButton.setFont(new Font("Arial",Font.BOLD,20));
        withdrawalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdrawalButton.setBorder(null);

        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.setVisible(false);
                new CashWithdrawalPage();
            }
        });

        // deposit
        JButton depositButton = new JButton("- Amount Deposit -");
        depositButton.setBounds(170,210,240,30);
        depositButton.setForeground(Color.black);
        depositButton.setFont(new Font("Arial",Font.BOLD,20));
        depositButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        depositButton.setBorder(null);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.setVisible(false);
                new DepositPage();
            }
        });

        // Balance enquiry
        JButton balanceButton = new JButton("- Balance Enquiry -");
        balanceButton.setBounds(170,270,240,30);
        balanceButton.setForeground(Color.black);
        balanceButton.setFont(new Font("Arial",Font.BOLD,20));
        balanceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        balanceButton.setBorder(null);

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.setVisible(false);
                new BalanceCheckPage();
            }
        });
        // change Password
        JButton changePassButton = new JButton("- Change Password -");
        changePassButton.setBounds(170,330,240,30);
        changePassButton.setForeground(Color.black);
        changePassButton.setFont(new Font("Arial",Font.BOLD,20));
        changePassButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePassButton.setBorder(null);

        homePage.add(selectProcess);
        homePage.add(withdrawalButton);
        homePage.add(depositButton);
        homePage.add(balanceButton);
        homePage.add(changePassButton);
        homePage.setSize(600,600);
        homePage.setLayout(null);
        homePage.setVisible(true);
    }
}
