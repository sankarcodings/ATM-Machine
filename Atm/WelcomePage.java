package Atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage
{
    JFrame welcomePage;
    WelcomePage()
    {
        welcomePage = new JFrame("SSS ATM --");
        welcomePage.getContentPane().setBackground(Color.BLACK);

        // Welo]come text

        JLabel welcome = new JLabel("-- Welcome to SSS ATM --");
        welcome.setBounds(140,100,400,40);
        welcome.setForeground(Color.white);
        welcome.setFont(new Font("Arial",Font.BOLD,25));

        // if already have account

        JLabel wellalreadyhave1 = new JLabel("-- if you already have account just login --");
        wellalreadyhave1.setBounds(85,150,400,40);
        wellalreadyhave1.setForeground(Color.white);
        wellalreadyhave1.setFont(new Font("Arial",Font.BOLD,20));

        // Login-button

        JButton loginbuttonWell = new JButton("- Login -");
        loginbuttonWell.setBounds(220,200,100,30);
        loginbuttonWell.setForeground(Color.BLACK);
        loginbuttonWell.setFont(new Font("Arial",Font.BOLD,18));
        loginbuttonWell.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginbuttonWell.setBorder(null);

        loginbuttonWell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomePage.setVisible(false);
                new LoginPage();
            }
        });

        // otherwise
        JLabel wellalreadyhave2 = new JLabel("-- Otherwise , you want to create a new Account --");
        wellalreadyhave2.setBounds(55,240,500,40);
        wellalreadyhave2.setForeground(Color.white);
        wellalreadyhave2.setFont(new Font("Arial",Font.BOLD,20));

        // signing Button

        JButton signinbuttonWell = new JButton("- Create a New Account -");
        signinbuttonWell.setBounds(130,300,300,30);
        signinbuttonWell.setForeground(Color.black);
        signinbuttonWell.setFont(new Font("Arial",Font.BOLD,18));
        signinbuttonWell.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signinbuttonWell.setBorder(null);

        signinbuttonWell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomePage.setVisible(false);
               // signinFrame.setVisible(true);
                new SigninPage();
            }
        });



        welcomePage.add(welcome);
        welcomePage.add(wellalreadyhave1);
        welcomePage.add(wellalreadyhave2);
        welcomePage.add(loginbuttonWell);
        welcomePage.add(signinbuttonWell);
        welcomePage.setLayout(null);
        welcomePage.setSize(600,600);
        welcomePage.setVisible(true);

    }
}
