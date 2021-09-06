/*
 * Created by JFormDesigner on Thu Aug 19 15:36:52 CST 2021
 */

package view;

import java.awt.event.*;
import dao.TitleDao;
import dao.TypeDao;
import modle.Title;
import modle.Type;
import util.StringUtil;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class TitleManageFrm extends JInternalFrame {
    public TitleManageFrm() {
        initComponents();
    }
    //初始化题目类别下拉框
    private void setTitleType(){
        Type typeTxt = null;
        try {
            TypeDao typeDao = new TypeDao();
            List<Type> typeList = typeDao.getTypeList(new Type());
            for (Type type:typeList){
                typeTxt = new Type();
                typeTxt.setId(type.getId());
                typeTxt.setName(type.getName());
                TitleTypeComboBox.addItem(typeTxt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //指定题目列的宽度
    public void setColumnWidth(JTable table,Object colname,int width){
        table.getColumn(colname).setPreferredWidth(width);
    }
    //题目管理表格
    private void setTitleTable(Title title){
        DefaultTableModel model = (DefaultTableModel) TitleListTable.getModel();
        model.setRowCount(0);
        try {
            TitleDao titleDao = new TitleDao();
            List<Title> titleList = titleDao.getTitleList(title);
            for (Title tit:titleList){
                Vector v = new Vector();
                v.add(tit.getId());
                v.add(tit.getContent());
                v.add(tit.getType_name());
                v.add(tit.getDifficult());
                model.addRow(v);
            }
        } catch (Exception e) {
        }
    }
    // 删除操作
    private void DeleteButtonActionPerformed(ActionEvent e) {

        int selectedRow = TitleListTable.getSelectedRow();
        if (selectedRow==-1){
            JOptionPane.showMessageDialog(null,"请选中要删除的数据！");
            return;
        }
        Title title = new Title();
        TitleDao titleDao = null;
        try {
            titleDao = new TitleDao();
            if (titleDao.delete(Integer.parseInt(TitleListTable.getValueAt(selectedRow,0).toString()))){
                JOptionPane.showMessageDialog(null,"删除成功！");
            }else{
                JOptionPane.showMessageDialog(null,"删除失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setTitleTable(title);
    }
    //鼠标点击题目信息出现在显示栏中
    private void TitleListTableMousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) TitleListTable.getModel();
        TitleInfoTextArea.setText((String) model.getValueAt(TitleListTable.getSelectedRow(),1));
        String typeName=model.getValueAt(TitleListTable.getSelectedRow(), 2).toString();
        TitleDiffComboBox.setSelectedItem(model.getValueAt(TitleListTable.getSelectedRow(),3));
        for(int i=0; i<TitleTypeComboBox.getItemCount();i++){
            Type typ= (Type) TitleTypeComboBox.getItemAt(i);
            if(typeName.equals(typ.getName())){
                TitleTypeComboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    //题目修改
    private void SubmitButtonActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) TitleListTable.getModel();
        String userTitleName=TitleInfoTextArea.getText();
        if(StringUtil.isEmpty(userTitleName)){
            JOptionPane.showConfirmDialog(null,"请填写要修改的题目！");
        }
        int id=Integer.parseInt(model.getValueAt(TitleListTable.getSelectedRow(),0).toString());
        Title title = new Title();
        Type titleType = (Type) TitleTypeComboBox.getSelectedItem();
        int titleTypeId = titleType.getId();
        String userDifficulty= (String) TitleDiffComboBox.getSelectedItem();
        title.setId(id);
        title.setContent(userTitleName);
        title.setDifficult(userDifficulty);
        title.setType_id(titleTypeId);
        try {
            TitleDao titleDao = new TitleDao();
            if (titleDao .update(title)) {
                JOptionPane.showMessageDialog(null,"更新成功！");
            }else{
                JOptionPane.showMessageDialog(null,"更新失败！");
            }
            setTitleTable(new Title());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        TitleListTable = new JTable();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        TitleInfoTextArea = new JTextArea();
        TitleTypeComboBox = new JComboBox();
        label2 = new JLabel();
        TitleDiffComboBox = new JComboBox<>();
        SubmitButton = new JButton();
        DeleteButton = new JButton();
        label4 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("\u9898\u76ee\u4fee\u6539\u548c\u5220\u9664\u7ba1\u7406");
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- TitleListTable ----
            TitleListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u9898\u76ee\u7f16\u53f7", "\u9898\u76ee\u5185\u5bb9", "\u9898\u76ee\u7c7b\u578b", "\u9898\u76ee\u96be\u5ea6"
                }
            ));
            TitleListTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    TitleListTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(TitleListTable);
        }

        //---- label1 ----
        label1.setText("\u9898\u76ee\u5185\u5bb9\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u5185\u5bb9.png")));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(TitleInfoTextArea);
        }

        //---- label2 ----
        label2.setText("\u9898\u76ee\u96be\u5ea6\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u96be\u5ea6.png")));

        //---- TitleDiffComboBox ----
        TitleDiffComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u7b80\u5355",
            "\u4e2d\u7b49",
            "\u56f0\u96be",
            "\u56f0\u56f0\u96be"
        }));

        //---- SubmitButton ----
        SubmitButton.setText("\u786e\u8ba4\u4fee\u6539");
        SubmitButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        SubmitButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        SubmitButton.addActionListener(e -> SubmitButtonActionPerformed(e));

        //---- DeleteButton ----
        DeleteButton.setText("\u5220\u9664");
        DeleteButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        DeleteButton.setIcon(new ImageIcon(getClass().getResource("/images/\u5220 \u9664.png")));
        DeleteButton.addActionListener(e -> DeleteButtonActionPerformed(e));

        //---- label4 ----
        label4.setText("\u9898\u76ee\u7c7b\u578b\uff1a");
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                    .addGap(113, 113, 113))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(SubmitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TitleDiffComboBox, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                            .addGap(110, 110, 110))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(TitleDiffComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addComponent(SubmitButton)
                            .addGap(31, 31, 31)
                            .addComponent(DeleteButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitleType();
        setTitleTable(new Title());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable TitleListTable;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JTextArea TitleInfoTextArea;
    private JComboBox TitleTypeComboBox;
    private JLabel label2;
    private JComboBox<String> TitleDiffComboBox;
    private JButton SubmitButton;
    private JButton DeleteButton;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
