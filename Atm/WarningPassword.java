package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WarningPassword
{
    JFrame passWarning;
    public WarningPassword()
    {
        passWarning = new JFrame("Warning --");
        passWarning.getContentPane().setBackground(Color.BLACK);
        JLabel passWarn1 = new JLabel("-- Password Should Contains only in Small Letters (a-z) and Numeric");
        passWarn1.setForeground(Color.WHITE);
        passWarn1.setFont(new Font("Arial",Font.BOLD,12));
        passWarn1.setBounds(35,30,500,40);

        JLabel passWarn2 = new JLabel("-- Special Characters not Allowed");
        passWarn2.setForeground(Color.WHITE);
        passWarn2.setFont(new Font("Arial",Font.BOLD,12));
        passWarn2.setBounds(35,50,500,40);

        passWarning.add(passWarn1);
        passWarning.add(passWarn2);
        passWarning.setLayout(null);
        passWarning.setSize(500,150);
        passWarning.setVisible(true);
    }
}
