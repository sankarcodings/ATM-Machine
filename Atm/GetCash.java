package Atm;

import javax.swing.*;
import java.awt.*;

public class GetCash
{
    JFrame getCash;
    GetCash(String amt)
    {
        getCash = new JFrame("SSS ATM --");
        getCash.getContentPane().setBackground(Color.black);

        // Cash
        JLabel cash = new JLabel(amt);
        cash.setBounds(200,65,300,30);
        cash.setFont(new Font("Arial",Font.BOLD,40));
        cash.setForeground(Color.white);

        getCash.add(cash);
        getCash.setLayout(null);
        getCash.setSize(500,200);
        getCash.setVisible(true);

    }
}
