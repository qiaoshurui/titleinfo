/*
 * Created by JFormDesigner on Thu Aug 05 15:36:52 CST 2021
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class MainFrm extends JFrame {
    public static Object userObject;
    public MainFrm(Object userObject) {
        this.userObject =userObject;
        initComponents();
    }
    private void ActionPerformed(ActionEvent ae) {
        //关于我们
        aboutUs(ae);
    }
    private void aboutUs(ActionEvent ae) {
        //关于我们
        JOptionPane.showMessageDialog(null,"你真是个秀外慧中，聪明可爱的小机灵鬼！");
    }
    private void menuItem1ActionPerformed(ActionEvent ae) {
        // 修改密码
        editPassword();
    }
    //修改密码
    private void editPassword() {
        UserPassword userPassword = new UserPassword();
        userPassword.setVisible(true);
        desktop.add(userPassword);
    }
    //退出系统
    private void exitActionPerformed(ActionEvent e) {
       if (JOptionPane.showConfirmDialog(MainFrm.this,"确定退出么？")==JOptionPane.OK_OPTION){
           System.exit(0);
       }
    }
    //题目类型添加
    private void menuItem7ActionPerformed(ActionEvent e) {
        TypeAddFrm typeAddFrm=new TypeAddFrm();
        System.out.println(1);
        typeAddFrm.setVisible(true);
        typeAddFrm.setBounds(230,100,460, 308);
        desktop.add(typeAddFrm);
    }
    // 题目类型管理
    private void menuItem8ActionPerformed(ActionEvent e) {
        TypeMangeFrm typeMangeFrm = new TypeMangeFrm();
        typeMangeFrm.setVisible(true);
        typeMangeFrm.setBounds(120,10,670, 500);
        desktop.add(typeMangeFrm);
    }
    // 添加题目
    private void menuItem9ActionPerformed(ActionEvent e) {
        AddTitleFrm addTitleFrm = new AddTitleFrm();
        addTitleFrm.setVisible(true);
        addTitleFrm.setBounds(230,100,460, 350);
        desktop.add(addTitleFrm);
    }
    //题目的修改和删除
    private void menuItem5ActionPerformed(ActionEvent e) {
        TitleManageFrm titleManageFrm = new TitleManageFrm();
        titleManageFrm.setVisible(true);
        titleManageFrm.setBounds(140,10,670, 470);
        desktop.add(titleManageFrm);
    }

    //题目的查找
    private void menuItem3ActionPerformed(ActionEvent e) {
        SearchTitleFrm searchTitleFrm = new SearchTitleFrm();
        searchTitleFrm.setVisible(true);
        searchTitleFrm.setBounds(140,10,670, 470);
        desktop.add(searchTitleFrm);
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    /**
     * 分页查询
     * @param e
     */
    private void menuItem4ActionPerformed(ActionEvent e) {
        PagingSearch pagingSearch = new PagingSearch();
        pagingSearch.setVisible(true);
        pagingSearch.setBounds(160,30,600, 350);
        desktop.add(pagingSearch);
    }

    /**
     * 做题表
     * @param e
     */
    private void menuItem10ActionPerformed(ActionEvent e) {
        TitleRecordFrm titleRecordFrm = new TitleRecordFrm();
        titleRecordFrm.setVisible(true);
        titleRecordFrm.setBounds(160,30,600, 440);
        desktop.add(titleRecordFrm);

    }
    void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menu4 = new JMenu();
        menuItem9 = new JMenuItem();
        menu5 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu6 = new JMenu();
        menuItem6 = new JMenuItem();
        panel1 = new JPanel();
        desktop = new JDesktopPane();

        //======== this ========
        setTitle("\u9762\u8bd5\u9898\u5e93\u7ba1\u7406\u7cfb\u7edf\u754c\u9762");
        setVisible(true);
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u8bbe\u7f6e");
                menu1.setIcon(new ImageIcon(getClass().getResource("/images/\u7cfb\u7edf\u8bbe\u7f6e.png")));

                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u9000\u51fa\u7cfb\u7edf");
                menuItem2.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa\u7cfb\u7edf.png")));
                menuItem2.addActionListener(e -> exitActionPerformed(e));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u9898\u76ee\u67e5\u627e");
                menu2.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u67e5\u627e.png")));

                //---- menuItem3 ----
                menuItem3.setText("\u67e5\u627e\u9898\u76ee");
                menuItem3.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u67e5\u627e.png")));
                menuItem3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u5206\u9875\u67e5\u8be2");
                menuItem4.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));
                menuItem4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);

                //---- menuItem10 ----
                menuItem10.setText("\u6211\u7684\u9898\u76ee");
                menuItem10.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem10.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u540d.png")));
                menuItem10.addActionListener(e -> menuItem10ActionPerformed(e));
                menu2.add(menuItem10);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u9898\u76ee\u4fee\u6539\u548c\u5220\u9664");
                menu3.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u4fee\u6539\u548c\u5220\u9664.png")));

                //---- menuItem5 ----
                menuItem5.setText("\u4fee\u6539\u548c\u5220\u9664\u9898\u76ee");
                menuItem5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem5.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u5185\u5bb9.png")));
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u9898\u76ee\u6dfb\u52a0");
                menu4.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u6dfb\u52a0.png")));

                //---- menuItem9 ----
                menuItem9.setText("\u6dfb\u52a0\u9898\u76ee");
                menuItem9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem9.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));
                menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                menu4.add(menuItem9);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("\u9898\u76ee\u7c7b\u578b\u7684\u6dfb\u52a0\u548c\u5220\u9664");
                menu5.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u7c7b\u578b\u7684\u6dfb\u52a0\u548c\u5220\u9664.png")));

                //---- menuItem7 ----
                menuItem7.setText("\u9898\u76ee\u7c7b\u578b\u7684\u6dfb\u52a0");
                menuItem7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem7.setIcon(new ImageIcon(getClass().getResource("/images/\u968f\u673a\u67e5\u627e.png")));
                menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                menu5.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("\u9898\u76ee\u7c7b\u578b\u7ba1\u7406");
                menuItem8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menuItem8.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));
                menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                menu5.add(menuItem8);
            }
            menuBar1.add(menu5);

            //======== menu6 ========
            {
                menu6.setText("\u5e2e\u52a9");
                menu6.setIcon(new ImageIcon(getClass().getResource("/images/\u5e2e \u52a9.png")));

                //---- menuItem6 ----
                menuItem6.setText("\u5173\u4e8e\u6211\u4eec");
                menuItem6.setIcon(new ImageIcon(getClass().getResource("/images/\u5173\u4e8e\u6211\u4eec.png")));
                menuItem6.addActionListener(e -> {
			menuItem6ActionPerformed(e);
			ActionPerformed(e);
		});
                menu6.add(menuItem6);
            }
            menuBar1.add(menu6);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //======== desktop ========
            {
                desktop.setForeground(Color.black);
                desktop.setBackground(new Color(102, 102, 0));
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(desktop, GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(desktop, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem10;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenu menu4;
    private JMenuItem menuItem9;
    private JMenu menu5;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenu menu6;
    private JMenuItem menuItem6;
    private JPanel panel1;
    private JDesktopPane desktop;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
