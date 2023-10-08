/*
 * Created by JFormDesigner on Sat Oct 07 14:27:02 CST 2023
 */

package com.liumapp.jtmock.view;

import com.liumapp.jtmock.config.MockProperties;
import com.liumapp.jtmock.factory.CustomBeanFactory;
import com.liumapp.jtmock.remote.NettyTcpClient;
import com.liumapp.jtmock.utils.ByteUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author liumapp
 */
public class HandPanel {

    public HandPanel() {
        initComponents();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextPane getTextPane1() {
        return textPane1;
    }

    private void sendBtn(ActionEvent e) {
        MockProperties mockProperties = CustomBeanFactory.getMockProperties();
        NettyTcpClient nettyTcpClient = CustomBeanFactory.getNettyTcpClient();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("往通讯服务器: ");
        stringBuilder.append(mockProperties.getIp());
        stringBuilder.append(" 端口:");
        stringBuilder.append(mockProperties.getPort());
        stringBuilder.append(" 发送报文: ");
        stringBuilder.append(textField1.getText());
        nettyTcpClient.send(ByteUtil.toByteArray(textField1.getText()));
        textPane1.setText(textPane1.getText() + "\n" + stringBuilder.toString());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel = new JPanel();
        textField1 = new JTextField();
        sendBtn = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== panel ========
        {
            panel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
            .EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax
            .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,
            12),java.awt.Color.red),panel. getBorder()));panel. addPropertyChangeListener(new java.beans
            .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.
            getPropertyName()))throw new RuntimeException();}});

            //---- sendBtn ----
            sendBtn.setText("\u53d1\u9001");
            sendBtn.addActionListener(e -> sendBtn(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textPane1);
            }

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendBtn)
                                .addGap(0, 215, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendBtn))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel;
    private JTextField textField1;
    private JButton sendBtn;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
