/*
 * Created by JFormDesigner on Mon Aug 02 15:48:16 CST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.*;

import dao.UserDao;
import modle.User;
import util.StringUtil;

/**
 * @author unknown
 */
public class LoginFrom {
    public LoginFrom() {
        initComponents();
    }
    private void loginActionPerformed(ActionEvent ae) {
        loginAct(ae);
    }

    protected void loginAct(ActionEvent ae) {
        String userName=userNameTextField.getText();
        String password=passwordTextField.getText();
        if (StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null,"用户名不能为空！");
            return;
        }
        if (StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"密码不能为空！");
            return;
        }
        User user=null;
        try {
            MessageDigest md=MessageDigest.getInstance("SHA");//密码加密
            md.update(password.getBytes());
            String str=new BigInteger(md.digest()).toString(32);
            UserDao userDao = new UserDao();
            User userTmp = new User();
            userTmp.setName(userName);
            userTmp.setPassword(str);
            System.out.println(str);
//            userTmp.setPassword(password);
            user=userDao.login(userTmp);
            if (user !=null){
                JOptionPane.showMessageDialog(null,""+user.getName()+"登陆成功！");
                Login_1.dispose();
                new MainFrm(userTmp);
            }else {
                JOptionPane.showMessageDialog(null,"用户名或密码错误！");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //注册
    private void registerButtonActionPerformed(ActionEvent e) {
        RegisterFrm registerFrm = new RegisterFrm();
        new RegisterFrm().setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        Login_1 = new JFrame();
        Login = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        userNameTextField = new JTextField();
        label3 = new JLabel();
        login = new JButton();
        passwordTextField = new JPasswordField();
        registerButton = new JButton();

        //======== Login_1 ========
        {
            Login_1.setTitle("\u767b\u5f55");
            Login_1.setResizable(false);
            Login_1.setVisible(true);
            Login_1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var Login_1ContentPane = Login_1.getContentPane();

            //======== Login ========
            {
                Login.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
                , 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
                Login. getBorder( )) ); Login. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- label1 ----
                label1.setText("\u9762\u8bd5\u9898\u5e93\u7ba1\u7406\u7cfb\u7edf\u767b\u5f55\u754c\u9762");
                label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));
                label1.setIcon(new ImageIcon(getClass().getResource("/images/\u9762\u8bd5-1.png")));

                //---- label2 ----
                label2.setText("\u7528\u6237\u540d:");
                label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                label2.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u540d.png")));

                //---- label3 ----
                label3.setText("\u5bc6   \u7801:");
                label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801.png")));

                //---- login ----
                login.setText("\u767b\u5f55");
                login.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                login.setIcon(new ImageIcon(getClass().getResource("/images/\u767b\u5f55.png")));
                login.addActionListener(e -> loginActionPerformed(e));

                //---- registerButton ----
                registerButton.setText("\u6211\u8981\u6ce8\u518c");
                registerButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                registerButton.setIcon(new ImageIcon(getClass().getResource("/images/\u6ce8\u518c.png")));
                registerButton.addActionListener(e -> registerButtonActionPerformed(e));

                GroupLayout LoginLayout = new GroupLayout(Login);
                Login.setLayout(LoginLayout);
                LoginLayout.setHorizontalGroup(
                    LoginLayout.createParallelGroup()
                        .addGroup(LoginLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(LoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(LoginLayout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(LoginLayout.createSequentialGroup()
                                    .addGroup(LoginLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                    .addGap(24, 24, 24)
                                    .addGroup(LoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                    .addGap(6, 6, 6)))
                            .addGap(73, 73, 73))
                        .addGroup(LoginLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(login)
                            .addGap(78, 78, 78)
                            .addComponent(registerButton)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                LoginLayout.setVerticalGroup(
                    LoginLayout.createParallelGroup()
                        .addGroup(LoginLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addGroup(LoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(LoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addGroup(LoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(login)
                                .addComponent(registerButton))
                            .addGap(48, 48, 48))
                );
            }

            GroupLayout Login_1ContentPaneLayout = new GroupLayout(Login_1ContentPane);
            Login_1ContentPane.setLayout(Login_1ContentPaneLayout);
            Login_1ContentPaneLayout.setHorizontalGroup(
                Login_1ContentPaneLayout.createParallelGroup()
                    .addComponent(Login, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            Login_1ContentPaneLayout.setVerticalGroup(
                Login_1ContentPaneLayout.createParallelGroup()
                    .addComponent(Login, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            Login_1.pack();
            Login_1.setLocationRelativeTo(Login_1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame Login_1;
    private JPanel Login;
    private JLabel label1;
    private JLabel label2;
    private JTextField userNameTextField;
    private JLabel label3;
    private JButton login;
    private JPasswordField passwordTextField;
    private JButton registerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
