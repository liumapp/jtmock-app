/*
 * Created by JFormDesigner on Wed Sep 27 16:43:57 CST 2023
 */

package com.liumapp.jtmock.view;

import com.liumapp.jtmock.config.MockProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

/**
 * @author liumapp
 */
public class ConfigPanel extends JPanel implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public JPanel getPannel() {
        return pannel;
    }

    public ConfigPanel() {
        initComponents();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void testBtn(ActionEvent e) {
        MockProperties mockProperties = applicationContext.getBean(MockProperties.class);
        mockProperties.setIp(textField1.getText());
        mockProperties.setPort(Integer.parseInt(textField2.getText()));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("往通讯服务器: ");
        stringBuilder.append(textField1.getText());
        stringBuilder.append(" 端口:");
        stringBuilder.append(textField2.getText());
        stringBuilder.append(" 发送终端注册请求报文: ");
        textPane1.setText(stringBuilder.toString());
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
        testBtn = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== pannel ========
        {
            pannel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
            new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
            ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12)
            ,java.awt.Color.red),pannel. getBorder()));pannel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});

            //---- label1 ----
            label1.setText("\u670d\u52a1\u7aefip\u5730\u5740");

            //---- label2 ----
            label2.setText("\u670d\u52a1\u7aef\u901a\u8baf\u7aef\u53e3");

            //---- label3 ----
            label3.setText("\u6a21\u62df\u8f66\u8f86\u81ea\u7f16\u53f7");

            //---- label4 ----
            label4.setText("\u6a21\u62df\u7ebf\u8def\u7f16\u53f7");

            //---- testBtn ----
            testBtn.setText("\u6d4b\u8bd5\u8fde\u63a5");
            testBtn.addActionListener(e -> testBtn(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textPane1);
            }

            GroupLayout pannelLayout = new GroupLayout(pannel);
            pannel.setLayout(pannelLayout);
            pannelLayout.setHorizontalGroup(
                pannelLayout.createParallelGroup()
                    .addGroup(pannelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pannelLayout.createParallelGroup()
                            .addComponent(testBtn)
                            .addComponent(label1)
                            .addGroup(pannelLayout.createSequentialGroup()
                                .addGroup(pannelLayout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))
            );
            pannelLayout.setVerticalGroup(
                pannelLayout.createParallelGroup()
                    .addGroup(pannelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pannelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(pannelLayout.createSequentialGroup()
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
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(testBtn)
                        .addContainerGap(56, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel pannel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JButton testBtn;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
