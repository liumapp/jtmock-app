/*
 * Created by JFormDesigner on Wed Sep 27 16:43:57 CST 2023
 */

package com.liumapp.jtmock.view;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author liumapp
 */
public class ConfigPanel extends JPanel {
    public ConfigPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        pannel = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();

        //======== pannel ========
        {
            pannel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),pannel. getBorder()));pannel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

            //---- label1 ----
            label1.setText("\u670d\u52a1\u7aefip\u5730\u5740");

            //---- label2 ----
            label2.setText("\u670d\u52a1\u7aef\u901a\u8baf\u7aef\u53e3");

            //---- label3 ----
            label3.setText("\u6a21\u62df\u8f66\u8f86\u81ea\u7f16\u53f7");

            //---- label4 ----
            label4.setText("\u6a21\u62df\u7ebf\u8def\u7f16\u53f7");

            GroupLayout pannelLayout = new GroupLayout(pannel);
            pannel.setLayout(pannelLayout);
            pannelLayout.setHorizontalGroup(
                pannelLayout.createParallelGroup()
                    .addGroup(pannelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pannelLayout.createParallelGroup()
                            .addComponent(label4)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addContainerGap(205, Short.MAX_VALUE))
            );
            pannelLayout.setVerticalGroup(
                pannelLayout.createParallelGroup()
                    .addGroup(pannelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addGap(6, 6, 6)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label3)
                        .addGap(6, 6, 6)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label4)
                        .addGap(6, 6, 6)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(98, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    public JPanel pannel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
