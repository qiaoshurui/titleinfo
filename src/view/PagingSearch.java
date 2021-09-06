/*
 * Created by JFormDesigner on Mon Aug 30 22:00:39 CST 2021
 */

package view;

import dao.TitleDao;
import modle.Title;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class PagingSearch extends JInternalFrame {
    int pageNum = 1;//页数
    int countNum = 9;//每页的个数
    int countSum = 0;//总数除上每页的个数的余数
    public PagingSearch() {
        initComponents();
    }

    //题目管理表格
    private void setTitleTable(Title title){
        DefaultTableModel model = (DefaultTableModel) TitleListChildTable.getModel();
        model.setRowCount(0);
        try {
            TitleDao titleDao = new TitleDao();
            List<Title> titleList = titleDao.getTitleList(title,pageNum,countNum);
            for (Title tit:titleList){
                Vector v = new Vector();
                v.add(tit.getId());
                v.add(tit.getContent());
                v.add(tit.getType_name());
                v.add(tit.getDifficult());
                model.addRow(v);
            }
            countSum = titleList.size();
        } catch (Exception e) {
        }
    }
    private void LeftSearchButtonActionPerformed(ActionEvent e) {
        pageNum--;
        setTitleTable(new Title());
        if(pageNum <= 1){
            LeftSearchButton.setEnabled(false);
        }
        if(countSum ==9){
            RightSearchButton.setEnabled(true);
        }
        System.out.println(pageNum);
    }

    private void RightSearchButtonActionPerformed(ActionEvent e) {
        pageNum++;
        setTitleTable(new Title());
        if (pageNum > 1) {
            LeftSearchButton.setEnabled(true);
        }
        if (countSum < 9) {
            System.out.println("11111111");
            RightSearchButton.setEnabled(false);
        }
    }
    private void setLimit(){
        if(pageNum == 1){
            LeftSearchButton.setEnabled(false);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        TitleListTable = new JScrollPane();
        TitleListChildTable = new JTable();
        LeftSearchButton = new JButton();
        RightSearchButton = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //======== TitleListTable ========
        {

            //---- TitleListChildTable ----
            TitleListChildTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u9898\u76ee\u7f16\u53f7", "\u9898\u76ee\u5185\u5bb9", "\u9898\u76ee\u7c7b\u578b", "\u9898\u76ee\u96be\u5ea6"
                }
            ));
            TitleListTable.setViewportView(TitleListChildTable);
        }

        //---- LeftSearchButton ----
        LeftSearchButton.setText("\u4e0a\u4e00\u9875");
        LeftSearchButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        LeftSearchButton.addActionListener(e -> LeftSearchButtonActionPerformed(e));

        //---- RightSearchButton ----
        RightSearchButton.setText("\u4e0b\u4e00\u9875");
        RightSearchButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        RightSearchButton.addActionListener(e -> RightSearchButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(LeftSearchButton)
                            .addGap(130, 130, 130)
                            .addComponent(RightSearchButton)
                            .addGap(168, 168, 168))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(TitleListTable, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(TitleListTable, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LeftSearchButton)
                        .addComponent(RightSearchButton))
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitleTable(new Title());
        setLimit();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane TitleListTable;
    private JTable TitleListChildTable;
    private JButton LeftSearchButton;
    private JButton RightSearchButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
