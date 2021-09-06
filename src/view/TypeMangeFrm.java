/*
 * Created by JFormDesigner on Thu Aug 12 15:09:40 CST 2021
 */

package view;

import java.awt.event.*;
import dao.TypeDao;
import modle.Type;
import util.StringUtil;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 * 类型管理表格
 */
public class TypeMangeFrm extends JInternalFrame {
    public TypeMangeFrm() {
        initComponents();
    }
    private void setTable(Type type){
        DefaultTableModel model = (DefaultTableModel) typeListTable.getModel();
        model.setRowCount(0);
        try {
            TypeDao typeDao = new TypeDao();
            List<Type> typeList=typeDao.getTypeList(type);
            for (Type tp:typeList){
                Vector v = new Vector();
                v.add(tp.getId());
                v.add(tp.getName());
                v.add(tp.getInfo());
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //查询按钮
    private void searchButtonActionPerformed(ActionEvent e) {
        Type type = new Type();
        type.setName(searchTypeNameTextField.getText());
        setTable(type);
    }
    //点击类型使其信息出现在显示栏中
    private void typeListTableMouseClicked(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) typeListTable.getModel();
        userTypeNameTextField.setText((String) model.getValueAt(typeListTable.getSelectedRow(),1));
        userTypeInfoTextArea.setText((String) model.getValueAt(typeListTable.getSelectedRow(),2));
        try {
            TypeDao typeDao = new TypeDao();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //题目类型修改
    private void submitUserButtonActionPerformed(ActionEvent e) {
        try {
            TypeDao typeDao = new TypeDao();
            int selectedRow = typeListTable.getSelectedRow();
            if (selectedRow==-1){
                JOptionPane.showMessageDialog(null,"请选中要修改的数据！");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) typeListTable.getModel();
            String typeName=model.getValueAt(typeListTable.getSelectedRow(),1).toString();
            String typeInfo=model.getValueAt(typeListTable.getSelectedRow(),2).toString();
            String userTypeName=userTypeNameTextField.getText();
            String userTypeInfo=userTypeInfoTextArea.getText();
            if(StringUtil.isEmpty(typeName)){
                JOptionPane.showConfirmDialog(null,"请填写要修改的名称！");
            }
            if (typeName.equals(userTypeName)&&typeInfo.equals(userTypeInfo)){
                JOptionPane.showConfirmDialog(null,"您还没有做出任何的修改！");
            }
            int id=Integer.parseInt(model.getValueAt(typeListTable.getSelectedRow(),0).toString());
            Type type = new Type();
            type.setId(id);
            type.setName(userTypeName);
            type.setInfo(userTypeInfo);
            if (typeDao.update(type)) {
                JOptionPane.showMessageDialog(null,"更新成功！");
            }else{
                JOptionPane.showMessageDialog(null,"更新失败！");
            }
            setTable(new Type());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void submitDeleteButtonActionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(null,"您确定要删除么？") !=JOptionPane.OK_OPTION)
        return;
        int selectedRow = typeListTable.getSelectedRow();
        if (selectedRow==-1){
            JOptionPane.showMessageDialog(null,"请选中要删除的数据！");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) typeListTable.getModel();
        int id=Integer.parseInt(model.getValueAt(typeListTable.getSelectedRow(),0).toString());
        try {
            TypeDao typeDao = new TypeDao();
            if (typeDao.delete(id)) {
                JOptionPane.showMessageDialog(null,"删除成功！");
            }else{
                JOptionPane.showMessageDialog(null,"删除失败！");
            }
            setTable(new Type());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        typeListTable = new JTable();
        label1 = new JLabel();
        searchTypeNameTextField = new JTextField();
        searchButton = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        submitUserButton = new JButton();
        submitDeleteButton = new JButton();
        userTypeNameTextField = new JTextField();
        scrollPane2 = new JScrollPane();
        userTypeInfoTextArea = new JTextArea();

        //======== this ========
        setVisible(true);
        setTitle("\u9898\u76ee\u7c7b\u578b\u4fe1\u606f\u7ba1\u7406");
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- typeListTable ----
            typeListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u9898\u76ee\u7c7b\u578b\u7f16\u53f7", "\u9898\u76ee\u7c7b\u578b\u540d\u79f0", "\u9898\u76ee\u7c7b\u578b\u4fe1\u606f\u4ecb\u7ecd"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, false, true
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            typeListTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    typeListTableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(typeListTable);
        }

        //---- label1 ----
        label1.setText("\u7c7b\u578b\u540d\u79f0\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u540d\u79f0.png")));

        //---- searchButton ----
        searchButton.setText("\u67e5\u8be2");
        searchButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        searchButton.setIcon(new ImageIcon(getClass().getResource("/images/\u968f\u673a\u67e5\u627e.png")));
        searchButton.addActionListener(e -> searchButtonActionPerformed(e));

        //---- label2 ----
        label2.setText("\u9898\u76ee\u7c7b\u578b\u540d\u79f0\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u540d\u79f0.png")));

        //---- label3 ----
        label3.setText("\u9898\u76ee\u7c7b\u578b\u4fe1\u606f\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u4fee\u6539\u548c\u5220\u9664.png")));

        //---- submitUserButton ----
        submitUserButton.setText("\u786e\u8ba4\u4fee\u6539");
        submitUserButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        submitUserButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        submitUserButton.addActionListener(e -> submitUserButtonActionPerformed(e));

        //---- submitDeleteButton ----
        submitDeleteButton.setText("\u5220\u9664");
        submitDeleteButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        submitDeleteButton.setIcon(new ImageIcon(getClass().getResource("/images/\u5220 \u9664.png")));
        submitDeleteButton.addActionListener(e -> submitDeleteButtonActionPerformed(e));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(userTypeInfoTextArea);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(98, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(26, 26, 26)
                            .addComponent(userTypeNameTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                    .addGap(63, 63, 63)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(submitUserButton)
                        .addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                    .addGap(94, 94, 94))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchTypeNameTextField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(searchButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(53, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTypeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(submitUserButton))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(userTypeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(submitDeleteButton)))
                    .addContainerGap(74, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTable(new Type(null));
//        scrollPane2.updateUI();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable typeListTable;
    private JLabel label1;
    private JTextField searchTypeNameTextField;
    private JButton searchButton;
    private JLabel label2;
    private JLabel label3;
    private JButton submitUserButton;
    private JButton submitDeleteButton;
    private JTextField userTypeNameTextField;
    private JScrollPane scrollPane2;
    private JTextArea userTypeInfoTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
