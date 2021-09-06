/*
 * Created by JFormDesigner on Wed Sep 01 15:08:19 CST 2021
 */

package view;

import dao.TitleDao;
import dao.TitleRecordDao;
import modle.Title;
import modle.TitleRecord;
import util.DbUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class TitleRecordFrm extends JInternalFrame {
    public TitleRecordFrm() {
        initComponents();
    }
    //题目管理表格
    private void setTitleTable(TitleRecord titleRecord){
        DefaultTableModel model = (DefaultTableModel) TitleRecordListTable.getModel();
        model.setRowCount(0);
        try {
            TitleRecordDao titleRecordDao = new TitleRecordDao();

            List<TitleRecord> titleRecordList = titleRecordDao.getTitleRecordList(titleRecord);
//            System.out.println(titleRecordList);
            for (TitleRecord titRecord:titleRecordList){
                Vector v = new Vector();
                v.add(titRecord.getId());
                v.add(titRecord.getContent());
                v.add(titRecord.getCreate_date());
                v.add(titRecord.getNext_date());
                model.addRow(v);
            }

        } catch (Exception e) {
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        TitleRecordListTable = new JTable();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- TitleRecordListTable ----
            TitleRecordListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u9898\u76ee\u7f16\u53f7", "\u9898\u76ee\u5185\u5bb9", "\u521b\u5efa\u65f6\u95f4", "\u4e0b\u6b21\u51fa\u73b0\u65f6\u95f4"
                }
            ));
            scrollPane1.setViewportView(TitleRecordListTable);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitleTable(new TitleRecord());
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable TitleRecordListTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
