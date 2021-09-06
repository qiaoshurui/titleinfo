/*
 * Created by JFormDesigner on Wed Aug 11 11:01:35 CST 2021
 */

package view;

import dao.TypeDao;
import modle.Type;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class TypeAddFrm extends JInternalFrame {
    public TypeAddFrm() {
        initComponents();
    }
    private void submitbuttonActionPerformed(ActionEvent e) {
        String typeName=typeNameTextField.getText();
        String typeInfo=typeInfoTextField.getText();
        if (StringUtil.isEmpty(typeName)){
            JOptionPane.showConfirmDialog(null,"题目类型名称不能为空！");
            return;
        }
        Type type =new Type();
        type.setName(typeName);
        type.setInfo(typeInfo);
        try {
            TypeDao typeDao=new TypeDao();
            if (typeDao.addType(type)){
                JOptionPane.showConfirmDialog(null,"题目类型添加成功！");

            }else{
                JOptionPane.showConfirmDialog(null,"题目类型添加失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        label1 = new JLabel();
        typeNameTextField = new JTextField();
        label2 = new JLabel();
        typeInfoTextField = new JTextField();
        label3 = new JLabel();
        submitbutton = new JButton();
        //======== this ========
        setTitle("\u6dfb\u52a0\u9898\u76ee\u7c7b\u578b");
        setClosable(true);
        setVisible(true);
        setResizable(true);
        setMinimumSize(null);
        setPreferredSize(null);
        setMaximumSize(null);
        setIconifiable(true);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7c7b\u578b\u540d\u79f0\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u540d\u79f0.png")));

        //---- label3 ----
        label3.setText("\u7c7b\u578b\u4fe1\u606f\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));

        //---- submitbutton ----
        submitbutton.setText("\u63d0\u4ea4");
        submitbutton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        submitbutton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        submitbutton.addActionListener(e -> submitbuttonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPaneLayout.setHonorsVisibility(false);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(typeNameTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(submitbutton)
                                .addComponent(typeInfoTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
                    .addGap(56, 65, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(typeInfoTextField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(submitbutton)
                    .addGap(21, 21, 21))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField typeNameTextField;
    private JLabel label2;
    private JTextField typeInfoTextField;
    private JLabel label3;
    private JButton submitbutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
