package com.team7.yourturn.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * author : ski
 * This class is used to learn swing
 */

public class UICreator implements KeyListener {

    private JButton moveButton;
    private JFrame frame;
    private ItemComponent imageTest;

    private void MoveIamgeTest() {
        loadImage();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                imageTest.setLocation(imageTest.getX() - 50, imageTest.getY());
                System.out.println(imageTest.getX());
                break;
            case KeyEvent.VK_RIGHT:
                imageTest.setLocation(imageTest.getX() + 50, imageTest.getY());
                System.out.println(imageTest.getX());
                break;
            case KeyEvent.VK_DOWN:
                imageTest.setLocation(imageTest.getX(), imageTest.getY() + 50);
                System.out.println(imageTest.getY());
                break;
            case KeyEvent.VK_UP:
                imageTest.setLocation(imageTest.getX(), imageTest.getY() - 50);
                System.out.println(imageTest.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    private void loadImage() {
        // frame init
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("picture hello world");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageTest = new ItemComponent("test.jpg",100,100);
//        JPanel panel = new JPanel();
//        panel.setSize(400,400);
//        panel.add(imageTest);
        frame.getContentPane().setBackground(Color.BLACK);
        JLabel label = new JLabel();
        label.setLocation(100, 100);
        label.add(imageTest);
        label.setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBackground(Color.BLACK);
//        frame.getContentPane().add(label);
        frame.getContentPane().add(imageTest);
        frame.addKeyListener(this);
//        panel.setBackground(Color.BLACK);
//        frame.add(panel);

//        frame.setBackground(Color.black);


//        imageTest = new ItemComponent("enemy.bmp");
//        frame.add(imageTest);

//        placeComponents(panel);

        frame.setVisible(true);
    }

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

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        JPanel panel = new JPanel();
//        frame.add(panel);

//        placeComponents(panel);



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

        imageTest = new ItemComponent("");
        imageTest.setBounds(10,140,30,30);
        ImageIcon icon = new ImageIcon("src/com/team7/yourturn/test/enemy.bmp");

//        panelAdd(panel, userLabel, userText, passwordLabel, passwordText, loginButton, moveButton);
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

    private void sizeTest(int testNum) {
        switch (testNum) {
            case 1:
                JFrame.setDefaultLookAndFeelDecorated(true);
                frame = new JFrame("picture hello world");
                frame.setSize(400,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
                frame.setVisible(true);
                break;
            case 2:
                JFrame.setDefaultLookAndFeelDecorated(true);
                frame = new JFrame("Hello,world,Swing");
                frame.setSize(400,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        UICreator creator = new UICreator();
//        creator.createAndShowUITest2();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                creator.loadImage();
//                creator.sizeTest(1);
//                creator.createAndShowUITest2();
            }
        });


    }
}
