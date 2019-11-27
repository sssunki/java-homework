package com.team7.yourturn.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * author : ski
 * This class is used to learn swing
 */

public class UICreator {

    private JButton moveButton;
    private JFrame frame;

    private void createAndShowUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Hello, world");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, world");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);

    }

    private void createAndShowUITest2() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame("Hello,world,Swing");
        // set size of the frame
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);

        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100,50,165,25);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10,80,80,25);

        moveButton = new JButton("move");
        moveButton.setBounds(10,110,80,25);

        loginButton.setActionCommand("login");
        loginButton.addActionListener(new ButtonClickListener());

        panelAdd(panel, userLabel, userText, passwordLabel, passwordText, loginButton, moveButton);
    }

    private void panelAdd(JPanel panel, JComponent ... jComponents){
        for (JComponent jComponent: jComponents) {
            panel.add(jComponent);
        }
    }

    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            moveButton.setBounds(moveButton.getX() + 10,moveButton.getY(),moveButton.getWidth(),moveButton.getHeight());
            frame.repaint();
            System.out.println(moveButton.getX());
        }
    }

    public static void main(String[] args) {
        UICreator creator = new UICreator();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                creator.createAndShowUITest2();
            }
        });
    }
}
