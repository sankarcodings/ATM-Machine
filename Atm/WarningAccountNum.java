package Atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WarningAccountNum
{
   // static JFrame accNumWarning;
    public static void WarningAccNum()
    {
        JFrame accNumWarning = new JFrame("Warning --");
        accNumWarning.getContentPane().setBackground(Color.BLACK);
        JLabel accNumWarn = new JLabel("Account Number Must be in 8 digits");
        accNumWarn.setForeground(Color.WHITE);
        accNumWarn.setFont(new Font("Arial",Font.BOLD,18));
        accNumWarn.setBounds(75,30,400,40);

        accNumWarning.add(accNumWarn);
        accNumWarning.setLayout(null);
        accNumWarning.setSize(500,150);
        accNumWarning.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
