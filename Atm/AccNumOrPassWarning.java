package Atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AccNumOrPassWarning
{
    JFrame accPassWarning ;
    AccNumOrPassWarning()
    {
        accPassWarning = new JFrame("Warning --");
        accPassWarning.getContentPane().setBackground(Color.BLACK);

        JLabel accpassWarn1 = new JLabel("-- Invalid Acc.No or Password");
        accpassWarn1.setForeground(Color.WHITE);
        accpassWarn1.setFont(new Font("Arial",Font.BOLD,12));
        accpassWarn1.setBounds(35,20,500,40);

        JLabel accpassWarn2 = new JLabel("-- Enter Valid Acc.No or Password , Else Create new Account");
        accpassWarn2.setForeground(Color.WHITE);
        accpassWarn2.setFont(new Font("Arial",Font.BOLD,12));
        accpassWarn2.setBounds(35,50,500,40);


        accPassWarning.add(accpassWarn1);
        accPassWarning.add(accpassWarn2);
        accPassWarning.setLayout(null);
        accPassWarning.setSize(500,150);
        accPassWarning.setVisible(true);
    }
}
