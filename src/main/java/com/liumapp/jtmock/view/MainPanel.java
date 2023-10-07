/*
 * Created by JFormDesigner on Wed Sep 27 15:31:00 CST 2023
 */

package com.liumapp.jtmock.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author liumapp
 */
public class MainPanel extends JPanel{

    public MainPanel() {
        initComponents();
        configBtn.doClick();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void manageConfig(ActionEvent e) {
        ConfigPanel configPanel = new ConfigPanel();
        subPanel.setLayout(new BorderLayout());
        subPanel.removeAll();
        subPanel.add(configPanel.getPannel());
        subPanel.validate();
    }

    private void handBtn(ActionEvent e) {
        HandPanel handPanel = new HandPanel();
        subPanel.setLayout(new BorderLayout());
        subPanel.removeAll();
        subPanel.add(handPanel.getPanel());
        subPanel.validate();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel = new JPanel();
        subPanel = new JPanel();
        configBtn = new JButton();
        title = new JLabel();
        mockBtn = new JButton();
        handBtn = new JButton();

        //======== panel ========
        {
            panel.setPreferredSize(new Dimension(800, 600));
            panel.setMinimumSize(new Dimension(866, 300));
            panel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel. getBorder () ) ); panel. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== subPanel ========
            {
                subPanel.setBorder(new LineBorder(Color.white));
                subPanel.setForeground(Color.pink);

                GroupLayout subPanelLayout = new GroupLayout(subPanel);
                subPanel.setLayout(subPanelLayout);
                subPanelLayout.setHorizontalGroup(
                    subPanelLayout.createParallelGroup()
                        .addGap(0, 648, Short.MAX_VALUE)
                );
                subPanelLayout.setVerticalGroup(
                    subPanelLayout.createParallelGroup()
                        .addGap(0, 528, Short.MAX_VALUE)
                );
            }

            //---- configBtn ----
            configBtn.setText("\u901a\u8baf\u914d\u7f6e");
            configBtn.addActionListener(e -> manageConfig(e));

            //---- title ----
            title.setText("JTMock");
            title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 15f));

            //---- mockBtn ----
            mockBtn.setText("\u6a21\u62df\u62a5\u6587");

            //---- handBtn ----
            handBtn.setText("\u624b\u52a8\u53d1\u9001");
            handBtn.addActionListener(e -> handBtn(e));

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup()
                            .addComponent(title)
                            .addComponent(configBtn, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(mockBtn, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addComponent(handBtn, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup()
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)
                        .addGap(52, 52, 52)
                        .addComponent(configBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mockBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(handBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(225, Short.MAX_VALUE))
                    .addComponent(subPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel;
    private JPanel subPanel;
    private JButton configBtn;
    private JLabel title;
    private JButton mockBtn;
    private JButton handBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
