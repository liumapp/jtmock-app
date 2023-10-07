package com.liumapp.jtmock;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.liumapp.jtmock.view.MainPanel;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static JFrame mainFrame = new JFrame(String.valueOf(FlatOneDarkIJTheme.setup()));

    public static void main(String[] args) {

        mainFrame.setTitle("JTMock");
        mainFrame.setResizable(true);
        MainPanel mainPanel = new MainPanel();
        mainFrame.setContentPane(mainPanel.getPanel());
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
