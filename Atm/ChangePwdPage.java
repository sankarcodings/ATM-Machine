package Atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import DataFetch.*;
public class ChangePwdPage extends LoginDataFetch
{
    JFrame changePwd;
    ChangePwdPage()
    {
        changePwd = new JFrame("SSS ATM --");
        changePwd.getContentPane().setBackground(Color.black);

        // welcome Login page
        JLabel changePwdTitle = new JLabel("-- Change Password --");
        changePwdTitle.setBounds(160, 60, 330, 30);
        changePwdTitle.setForeground(Color.white);
        changePwdTitle.setFont(new Font("Arial",Font.BOLD,22));

        //Account Number
        JLabel accNum = new JLabel("Enter Account Number");
        accNum.setBounds(40, 140, 250, 30);
        accNum.setForeground(Color.white);
        accNum.setFont(new Font("Arial",Font.BOLD,16));

        //Colon1
        JLabel colon1 = new JLabel(":");
        colon1.setForeground(new Color(255,255,255));
        colon1.setBounds(240,144,50,25);
        colon1.setFont(new Font("Arial",Font.BOLD,16));

        //Num TextField
        JTextField numField = new JTextField();
        numField.setBounds(270,143,280,28);
        numField.setBorder(null);
        numField.setFont(new Font("Arial",Font.PLAIN,17));

        //old pwd
        JLabel oldPwd = new JLabel("Enter Old Password");
        oldPwd.setBounds(40, 210, 250, 30);
        oldPwd.setForeground(Color.white);
        oldPwd.setFont(new Font("Arial",Font.BOLD,16));

        //Colon2
        JLabel colon2 = new JLabel(":");
        colon2.setForeground(new Color(255,255,255));
        colon2.setBounds(240,214,50,25);
        colon2.setFont(new Font("Arial",Font.BOLD,16));

        //old-pwd TextField
        JTextField oldPwdField = new JTextField();
        oldPwdField.setBounds(270,213,280,28);
        oldPwdField.setBorder(null);
        oldPwdField.setFont(new Font("Arial",Font.PLAIN,17));

        //new pwd
        JLabel newPwd = new JLabel("Enter New Password");
        newPwd.setBounds(40, 280, 250, 30);
        newPwd.setForeground(Color.white);
        newPwd.setFont(new Font("Arial",Font.BOLD,16));

        //Colon3
        JLabel colon3 = new JLabel(":");
        colon3.setForeground(new Color(255,255,255));
        colon3.setBounds(240,284,50,25);
        colon3.setFont(new Font("Arial",Font.BOLD,16));

        //new-pwd TextField
        JTextField newPwdField = new JTextField();
        newPwdField.setBounds(270,283,280,28);
        newPwdField.setBorder(null);
        newPwdField.setFont(new Font("Arial",Font.PLAIN,17));

        // output-mess
        JLabel outputMess = new JLabel("");
        outputMess.setForeground(Color.white);
        outputMess.setFont(new Font("Arial",Font.BOLD,25));
        outputMess.setBounds(120,423,500,30);

        //Chane Button
        JButton changePwdButt = new JButton("Change Password");
        changePwdButt.setBounds(40,350,200,30);
        changePwdButt.setForeground(Color.black);
        changePwdButt.setFont(new Font("Arial",Font.BOLD,18));
        changePwdButt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePwdButt.setBorder(null);

        changePwdButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = numField.getText();
                String s2 = oldPwdField.getText();
                String s3 = newPwdField.getText();
               try
                {
                    if(loginDataFetch(s1,s2))
                    {
                        if(ChangePwdDataFetch.changePwdData(s1,s3)) {
                            outputMess.setText("Successfully Password Updated");
                        }
                        else
                        {
                            System.out.println("Successfully Updated !!!!");
                        }
                    }
                    else {
                        new AccNumOrPassWarning();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Server Not Reached !! "+ex);
                }
            }
        });

        // return home page
        JButton returnButton = new JButton("- Return to Home Page -");
        returnButton.setBounds(10,500,300,30);
        returnButton.setForeground(Color.white);
        returnButton.setFont(new Font("Arial",Font.BOLD,20));
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setBorder(null);
        returnButton.setBackground(null);

        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                changePwd.setVisible(false);
                new HomePage();
            }
        });

        changePwd.add(changePwdTitle);
        changePwd.add(accNum);
        changePwd.add(colon1);
        changePwd.add(numField);
        changePwd.add(oldPwd);
        changePwd.add(colon2);
        changePwd.add(oldPwdField);
        changePwd.add(newPwd);
        changePwd.add(colon3);
        changePwd.add(newPwdField);
        changePwd.add(changePwdButt);
        changePwd.add(returnButton);
        changePwd.add(outputMess);
        changePwd.setLayout(null);
        changePwd.setSize(600,600);
        changePwd.setVisible(true);
    }
}
