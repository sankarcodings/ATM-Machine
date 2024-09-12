package Atm;

import SQl.SqlConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SigninPage extends SqlConnection
{
	JFrame signinFrame;
	SigninPage()
	{
		signinFrame = new JFrame("SSS Atm --");
		signinFrame.getContentPane().setBackground(Color.BLACK);
		
		
		// welcome sigin page
		JLabel signinTitle = new JLabel("-- Welcome to Our Signin Page --");
		signinTitle.setBounds(160, 30, 300, 30);
		signinTitle.setForeground(Color.white);
		signinTitle.setFont(new Font("Arial",Font.BOLD,19));
		
		//Account Holder Name
		JLabel accName = new JLabel("Enter Account Holder Name");
		accName.setBounds(40, 90, 250, 30);
		accName.setForeground(Color.white);
		accName.setFont(new Font("Arial",Font.BOLD,16));
		
		//Colon1
		JLabel colon = new JLabel(":");
		colon.setForeground(new Color(255,255,255));
		colon.setBounds(270,94,50,25);
		colon.setFont(new Font("Arial",Font.BOLD,16));
		
		//Name TextField
		JTextField nameField = new JTextField();
		nameField.setBounds(310,93,280,28);
		nameField.setBorder(null);
		nameField.setFont(new Font("Arial",Font.PLAIN,17));
		
		//Account Number
		JLabel accNum = new JLabel("Enter Account Number");
		accNum.setBounds(40, 150, 250, 30);
		accNum.setForeground(Color.white);
		accNum.setFont(new Font("Arial",Font.BOLD,16));
		
		//Colon1
		JLabel colon1 = new JLabel(":");
		colon1.setForeground(new Color(255,255,255));
		colon1.setBounds(270,154,50,25);
		colon1.setFont(new Font("Arial",Font.BOLD,16));
		
		//Name TextField
		JTextField numField = new JTextField();
		numField.setBounds(310,153,280,28);
		numField.setBorder(null);
		numField.setFont(new Font("Arial",Font.PLAIN,17));
		
		// rules
//		JLabel ruleAccNum = new JLabel("Acc.No in 8 digit number");
//		colon1.setForeground(new Color(255,255,255));
//		numField.setBounds(310,200,100,20);
//		numField.setFont(new Font("Arial",Font.BOLD,5));

		// create - pwd
		JLabel createPwd = new JLabel("Create New Password");
		createPwd.setBounds(40, 210, 250, 30);
		createPwd.setForeground(Color.white);
		createPwd.setFont(new Font("Arial",Font.BOLD,16));

		//colon2
		JLabel colon2 = new JLabel(":");
		colon2.setForeground(new Color(255,255,255));
		colon2.setBounds(270,214,50,25);
		colon2.setFont(new Font("Arial",Font.BOLD,16));

		//create-Pwd TextField
		JTextField createPwdField = new JTextField();
		createPwdField.setBounds(310,213,280,28);
		createPwdField.setBorder(null);
		createPwdField.setFont(new Font("Arial",Font.PLAIN,17));

		// Confirm - pwd
		JLabel confirmPwd = new JLabel("Confirm Password");
		confirmPwd.setBounds(40, 270, 250, 30);
		confirmPwd.setForeground(Color.white);
		confirmPwd.setFont(new Font("Arial",Font.BOLD,16));

		//colon2
		JLabel colon3 = new JLabel(":");
		colon3.setForeground(new Color(255,255,255));
		colon3.setBounds(270,274,50,25);
		colon3.setFont(new Font("Arial",Font.BOLD,16));

		//create-Pwd TextField
		JTextField confirmPwdField = new JTextField();
		confirmPwdField.setBounds(310,273,280,28);
		confirmPwdField.setBorder(null);
		confirmPwdField.setFont(new Font("Arial",Font.PLAIN,17));

		// Date
		JLabel date = new JLabel("Enter Date (eg : yyyy/mm/dd)");
		date.setBounds(40, 330, 250, 30);
		date.setForeground(Color.white);
		date.setFont(new Font("Arial",Font.BOLD,16));

		//colon4
		JLabel colon4 = new JLabel(":");
		colon4.setForeground(new Color(255,255,255));
		colon4.setBounds(270,334,50,25);
		colon4.setFont(new Font("Arial",Font.BOLD,16));

		//date TextField
		JTextField dateField = new JTextField();
		dateField.setBounds(310,333,280,28);
		dateField.setBorder(null);
		dateField.setFont(new Font("Arial",Font.PLAIN,17));

		// Create - Account
		JButton createAccbutton = new JButton("Create Account");
		createAccbutton.setBounds(40,400,200,30);
		createAccbutton.setForeground(Color.black);
		createAccbutton.setFont(new Font("Arial",Font.BOLD,18));
		createAccbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createAccbutton.setBorder(null);

		createAccbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
                    String p1 = createPwdField.getText();
                    String p2 = confirmPwdField.getText();
                    if(eightDigit(numField.getText()))// && checkPassword(p1) && p1.equals(p2));
                    {
                        if(checkPassword(p1))
                        {
                            if(strCheck(p1,p2))
                            {
                                insertvalues(nameField.getText(),numField.getText(),createPwdField.getText(),dateField.getText());
                               // readValues();
								signinFrame.setVisible(false);
								new HomePage();
                            }
                            else
                            {
								new CrateConfirmPassWarn();
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
				catch (Exception ex)
				{
					System.out.println("Values Not Inserted --"+ex);
				}
			}
		});

		// already have account
		JLabel alreadyhave = new JLabel("already have account click login ,");
		alreadyhave.setForeground(new Color(255,255,255));
		alreadyhave.setBounds(40,460,300,30);
		alreadyhave.setFont(new Font("Arial",Font.PLAIN,20));

		// return - login
		JButton retLoginbutton = new JButton("- Login -");
		retLoginbutton.setBounds(25,505,100,30);
		retLoginbutton.setForeground(Color.WHITE);
		retLoginbutton.setFont(new Font("Arial",Font.BOLD,18));
		retLoginbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		retLoginbutton.setBorder(null);
		retLoginbutton.setBackground(null);

		retLoginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signinFrame.setVisible(false);
				new LoginPage();
			}
		});
		
		signinFrame.add(signinTitle);
		signinFrame.add(accName);
		signinFrame.add(colon);
		signinFrame.add(nameField);
		signinFrame.add(accNum);
		signinFrame.add(colon1);
		signinFrame.add(numField);
		//signinFrame.add(ruleAccNum);
		signinFrame.add(createPwd);
		signinFrame.add(colon2);
		signinFrame.add(createPwdField);
		signinFrame.add(confirmPwd);
		signinFrame.add(colon3);
		signinFrame.add(confirmPwdField);
		signinFrame.add(date);
		signinFrame.add(colon4);
		signinFrame.add(dateField);
		signinFrame.add(createAccbutton);
		signinFrame.add(alreadyhave);
		signinFrame.add(retLoginbutton);
		signinFrame.setLayout(null);
		signinFrame.setSize(650,650);
		signinFrame.setVisible(true);
		
	}

}
