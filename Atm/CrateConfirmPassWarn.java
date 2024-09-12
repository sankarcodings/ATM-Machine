package Atm;

import javax.swing.*;
import java.awt.*;

public class CrateConfirmPassWarn
{
    JFrame createConfirmPass ;
    CrateConfirmPassWarn()
    {
        createConfirmPass = new JFrame("Warning --");
        createConfirmPass.getContentPane().setBackground(Color.BLACK);
        JLabel createConfirm = new JLabel("-- Please check create pwd and confirm pwd . Both are not Same ");
        createConfirm.setForeground(Color.WHITE);
        createConfirm.setFont(new Font("Arial",Font.BOLD,12));
        createConfirm.setBounds(35,30,500,40);

        createConfirmPass.add(createConfirm);
        createConfirmPass.setLayout(null);
        createConfirmPass.setSize(500,150);
        createConfirmPass.setVisible(true);
    }
}
