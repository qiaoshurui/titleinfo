/*
 * Created by JFormDesigner on Fri Aug 06 15:47:17 CST 2021
 */

package view;

import dao.UserDao;
import modle.User;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.plaf.*;

/**
 * @author unknown
 */
public class UserPassword extends JInternalFrame {
    public UserPassword() {
        initComponents();
    }

    private void submitButtonActionPerformed(ActionEvent e) {
        String oldPassword=oldPasswordTextField.getText();
        String newPassword=newPasswordTextField.getText();
        String conformPassword=confirmPasswordTextField.getText();
        if (StringUtil.isEmpty(oldPassword)){
            JOptionPane.showMessageDialog(null,"请填写原密码！");
            return;
        }
        if (StringUtil.isEmpty(newPassword)){
            JOptionPane.showMessageDialog(null,"请填写新密码！");
            return;
        }
        if (StringUtil.isEmpty(conformPassword)){
            JOptionPane.showMessageDialog(null,"请确认新密码！");
            return;
        }
        if (!newPassword.equals(conformPassword)){
            JOptionPane.showMessageDialog(null,"两次密码输入不一致！");
            return;
        }
        try {
            UserDao userDao = new UserDao();
            User userTmp = new User();
            User user=(User)MainFrm.userObject;
            userTmp.setName(user.getName());
            userTmp.setPassword(oldPassword);
            JOptionPane.showMessageDialog(null,userDao.editPassword(userTmp,newPassword));
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        this.setBounds(230,100,460, 308);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        oldPasswordTextField = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        submitButton = new JButton();
        newPasswordTextField = new JTextField();
        confirmPasswordTextField = new JTextField();

        //======== this ========
        setBackground(new Color(238, 238, 238));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("\u4fee\u6539\u5bc6\u7801");
        setVisible(true);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u539f\u5bc6\u7801\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801.png")));

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));

        //---- submitButton ----
        submitButton.setText("\u786e\u8ba4");
        submitButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        submitButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        submitButton.addActionListener(e -> submitButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(submitButton)
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField oldPasswordTextField;
    private JLabel label2;
    private JLabel label3;
    private JButton submitButton;
    private JTextField newPasswordTextField;
    private JTextField confirmPasswordTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
