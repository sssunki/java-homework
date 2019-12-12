package com.team7.yourturn.test;

import com.team7.yourturn.utils.CoordinateCalculator;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        ItemComponent imageTest = new ItemComponent("test.jpg",100,100);
        frame.setVisible(true);

        frame.getContentPane().add(imageTest);
        frame.setVisible(true);

//        imageTest.setLocation(1000,1000);
//        CoordinateCalculator calculator = new CoordinateCalculator();
//        imageTest.setLocation(calculator.arrayToFrame(5),calculator.arrayToFrame(5));
//        System.out.println(imageTest.getX());
//        imageTest.setLocation(100,100);
//        frame.setVisible(true);
    }
}
