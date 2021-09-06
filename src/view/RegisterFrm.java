/*
 * Created by JFormDesigner on Sat Aug 28 21:25:29 CST 2021
 */

package view;

import dao.TitleDao;
import dao.UserDao;
import modle.Title;
import modle.User;
import util.StringUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class RegisterFrm extends JFrame {

//    private void registerButtonActionPerformed(ActionEvent e) {
//        RegisterFrm registerFrm = new RegisterFrm();
//        registerFrm.setVisible(true);
//        String userName=RegisterNameTextField.getText();
//        String tel=RegisterTelTextField.getText();
//        String password=RegisterPasswordTextField.getText();
//        if (StringUtil.isEmpty(userName)){
//            JOptionPane.showMessageDialog(null,"注册的用户名不能为空！");
//            return;
//        }
//        if (StringUtil.isEmpty(tel)){
//            JOptionPane.showMessageDialog(null,"注册的电话不能为空！");
//            return;
//        }
//        if (StringUtil.isEmpty(password)){
//            JOptionPane.showMessageDialog(null,"注册的密码不能为空！");
//            return;
//        }
//        User user = new User();
//        user.setName(userName);
//        user.setPassword(password);
//        user.setPhone_number(tel);
//        UserDao userDao = null;
//        try {
//            userDao = new UserDao();
//            if (userDao.register(user)) {
//                JOptionPane.showConfirmDialog(null,"用户添注册成功");
//            }else{
//                JOptionPane.showConfirmDialog(null,"用户添注册失败");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
    public RegisterFrm() {
        initComponents();
    }
    //注册
    private void RegisterButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
//        RegisterFrm registerFrm = new RegisterFrm();
//        registerFrm.setVisible(true);
        String userName=RegisterNameTextField.getText();
        String tel=RegisterTelTextField.getText();
        String password=RegisterPasswordTextField.getText();
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null,"注册的用户名不能为空！");
            return;
        }
        if (StringUtil.isEmpty(tel)){
            JOptionPane.showMessageDialog(null,"注册的电话不能为空！");
            return;
        }
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"注册的密码不能为空！");
            return;
        }
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setPhone_number(tel);
        UserDao userDao = null;
        try {
            userDao = new UserDao();
            if (userDao.register(user)) {
                JOptionPane.showConfirmDialog(null,"用户添注册成功");

            }else{
                JOptionPane.showConfirmDialog(null,"用户添注册失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        RegisterButton = new JButton();
        RegisterNameTextField = new JTextField();
        RegisterPasswordTextField = new JTextField();
        RegisterTelTextField = new JTextField();

        //======== this ========
        setTitle("\u6ce8\u518c");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u59d3\u540d\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u540d.png")));

        //---- label2 ----
        label2.setText("\u624b\u673a\u53f7:");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u67e5\u627e.png")));

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5e2e \u52a9.png")));

        //---- RegisterButton ----
        RegisterButton.setText("\u786e\u5b9a\u6ce8\u518c");
        RegisterButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        RegisterButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        RegisterButton.addActionListener(e -> RegisterButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(RegisterTelTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addComponent(RegisterPasswordTextField)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(RegisterNameTextField)))
                    .addGap(50, 50, 50))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterButton)
                    .addGap(106, 106, 106))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(RegisterNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(RegisterTelTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(RegisterPasswordTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addComponent(RegisterButton)
                    .addGap(45, 45, 45))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton RegisterButton;
    private JTextField RegisterNameTextField;
    private JTextField RegisterPasswordTextField;
    private JTextField RegisterTelTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
