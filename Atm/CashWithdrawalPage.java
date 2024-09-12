package Atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import DataFetch.CashDataFetch;
public class CashWithdrawalPage
{
    JFrame cashWithdrawal;
    CashWithdrawalPage()
    {
        cashWithdrawal = new JFrame("SSS ATM --");
        cashWithdrawal.getContentPane().setBackground(Color.black);
        // cash withdrawal title
        JLabel cashwithTitle = new JLabel("-- Cash Withdrawal --");
        cashwithTitle.setBounds(160, 60, 300, 30);
        cashwithTitle.setForeground(Color.white);
        cashwithTitle.setFont(new Font("Arial",Font.BOLD,22));

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

        // enter amount
        JLabel enterAmount = new JLabel("Enter Amount");
        enterAmount.setBounds(40, 250, 250, 30);
        enterAmount.setForeground(Color.white);
        enterAmount.setFont(new Font("Arial",Font.BOLD,16));

        //colon3
        JLabel colon3 = new JLabel(":");
        colon3.setForeground(new Color(255,255,255));
        colon3.setBounds(240,254,50,25);
        colon3.setFont(new Font("Arial",Font.BOLD,16));

        //enter-amt TextField
        JTextField enterAmtField = new JTextField();
        enterAmtField.setBounds(270,253,280,28);
        enterAmtField.setBorder(null);
        enterAmtField.setFont(new Font("Arial",Font.PLAIN,17));

        // output - message

        JLabel ouputMess = new JLabel(""); // - Insufficient Balance -
        ouputMess.setBounds(160, 373, 300, 30);
        ouputMess.setForeground(Color.white);
        ouputMess.setFont(new Font("Arial",Font.BOLD,22));

        // submit
        JButton submit = new JButton("- Submit -");
        submit.setBounds(40,313,100,30);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setBorder(null);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = numField.getText();
                String s2 = loginPwdField.getText();
                String s3 = enterAmtField.getText();
                try
                {
                    if(CashDataFetch.cashData(s1,s2,s3))
                    {
                        ouputMess.setText("- Get Cash - ");
                        ouputMess.setBounds(220,373, 300, 30);
                        new GetCash(s3);
                        CashDataFetch.updateCash(s1);
                    }
                    else
                    {
                        ouputMess.setText("- Insufficient Balance -");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Server Not Reached !!! "+ex);
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
                cashWithdrawal.setVisible(false);
                new HomePage();
            }
        });

        cashWithdrawal.add(accNum);
        cashWithdrawal.add(colon1);
        cashWithdrawal.add(numField);
        cashWithdrawal.add(loginPwd);
        cashWithdrawal.add(colon2);
        cashWithdrawal.add(loginPwdField);
        cashWithdrawal.add(enterAmount);
        cashWithdrawal.add(colon3);
        cashWithdrawal.add(enterAmtField);
        cashWithdrawal.add(cashwithTitle);
        cashWithdrawal.add(submit);
        cashWithdrawal.add(ouputMess);
        cashWithdrawal.add(returnButton);
        cashWithdrawal.setLayout(null);
        cashWithdrawal.setSize(600,600);
        cashWithdrawal.setVisible(true);
    }
}
