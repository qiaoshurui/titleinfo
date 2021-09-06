/*
 * Created by JFormDesigner on Tue Aug 17 17:05:51 CST 2021
 */

package view;

import dao.TitleDao;
import dao.TypeDao;
import modle.Title;
import modle.Type;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AddTitleFrm extends JInternalFrame {
    public AddTitleFrm() {
        initComponents();
    }

    private void SubmitButtonActionPerformed(ActionEvent e) {
        // 题目添加事件处理
        String TitleInfo=TitleInfoTextArea.getText();
        if (StringUtil.isEmpty(TitleInfo)){
            JOptionPane.showConfirmDialog(null,"请输入题目内容！");
            return;
        }
         Type titleType = (Type) TitleTypeComboBox.getSelectedItem();
         int titleTypeId = titleType.getId();
         String difficulty= (String) TitleDiffComboBox.getSelectedItem();
         Title title = new Title();
         title.setContent(TitleInfo);
         title.setDifficult(difficulty);
         title.setType_id(titleTypeId);
         TitleDao titleDao = null;
        try {
            titleDao = new TitleDao();
            if (titleDao.addTitle(title)) {
                JOptionPane.showConfirmDialog(null,"题目添加成功");
            }else{
                JOptionPane.showConfirmDialog(null,"题目添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //初始化题目类别下拉框
    private void setTitleType(){
        Type typeTxt = null;
        try {
            TypeDao typeDao = new TypeDao();
            List<Type> typeList = typeDao.getTypeList(new Type());
//            TitleDiffComboBox.removeAllItems();
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        TitleInfoTextArea = new JTextArea();
        TitleTypeComboBox = new JComboBox();
        SubmitButton = new JButton();
        TitleDiffComboBox = new JComboBox<>();

        //======== this ========
        setVisible(true);
        setTitle("\u6dfb\u52a0\u9898\u76ee");
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u9898\u76ee\u7c7b\u578b\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u540d\u79f0.png")));

        //---- label2 ----
        label2.setText("\u9898\u76ee\u5185\u5bb9\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u5185\u5bb9.png")));

        //---- label3 ----
        label3.setText("\u9898\u76ee\u96be\u5ea6\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u96be\u5ea6.png")));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(TitleInfoTextArea);
        }

        //---- SubmitButton ----
        SubmitButton.setText("\u786e\u8ba4\u6dfb\u52a0");
        SubmitButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        SubmitButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        SubmitButton.addActionListener(e -> SubmitButtonActionPerformed(e));

        //---- TitleDiffComboBox ----
        TitleDiffComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u7b80\u5355",
            "\u4e2d\u7b49",
            "\u56f0\u96be",
            "\u56f0\u56f0\u96be"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TitleDiffComboBox))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(96, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(188, Short.MAX_VALUE)
                    .addComponent(SubmitButton)
                    .addGap(156, 156, 156))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TitleDiffComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubmitButton)
                    .addGap(68, 68, 68))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitleType();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea TitleInfoTextArea;
    private JComboBox TitleTypeComboBox;
    private JButton SubmitButton;
    private JComboBox<String> TitleDiffComboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
