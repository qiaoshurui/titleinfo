/*
 * Created by JFormDesigner on Tue Aug 24 10:22:34 CST 2021
 */

package view;

import java.awt.event.*;
import dao.TitleDao;
import dao.TitleRecordDao;
import dao.TypeDao;
import modle.Title;
import modle.TitleRecord;
import modle.Type;
import util.DbUtil;
import util.StringUtil;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class SearchTitleFrm extends JInternalFrame {
    private int idTxt;
    private int max;
    public  static Calendar clickDate;
    public static int nowid;
    int pageNum = 1;
    int countNum = 9;
    int countSum = 0;

    public SearchTitleFrm() {
        initComponents();
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
            countSum = titleList.size();
        } catch (Exception e) {
        }
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
    //查询按钮
    private void submitButtonActionPerformed(ActionEvent e) {
        Title title = new Title();
        title.setContent(KeyTitleTextField.getText());
        Type ty=(Type) TitleTypeComboBox.getSelectedItem();
        title.setType_id(ty.getId());
        setTitleTable(title);
    }
    //点击我做对啦的按钮
    private void RightButtonActionPerformed(ActionEvent e) {
        // 点击这个按钮，数据库的表中新增一条信息
        String text = TitleTextArea.getText();
        if(StringUtil.isEmpty(text)){
            JOptionPane.showConfirmDialog(null,"请选择你的题目！");
        }
        Calendar nowTime = Calendar.getInstance();
        Date time1 = nowTime.getTime();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(time1);//time就是当前时间
        clickDate=nowTime;
        TitleRecord titleRecord = new TitleRecord();
        titleRecord.setTitle_id(idTxt);
        nowid=idTxt;
        System.out.println(nowid);
        titleRecord.setCreate_date(time);
        TitleRecordDao titleRecordDao=null;
        try {
            titleRecordDao=new TitleRecordDao();
            if (titleRecordDao.addTitleRecord(titleRecord)) {
                //个人规定题目下次出现的时间
                if (JOptionPane.showConfirmDialog(this,"需要手动添加题目下次出现时间么？")==JOptionPane.OK_OPTION){
                    PerTimeSetting perTimeSetting = new PerTimeSetting();
                    perTimeSetting.setVisible(true);
                    perTimeSetting.setBounds(0,0,100,100);
                }
            }else{
                JOptionPane.showConfirmDialog(null,"个人题目记录添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //点击我做错了这个按钮
    private void WrongButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showConfirmDialog(null,"聪明的你一定可以想出这道题的答案！");
    }
    //鼠标点击题目信息出现在显示栏中
    private void TitleListTableMousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) TitleListTable.getModel();
        TitleTextArea.setText((String) model.getValueAt(TitleListTable.getSelectedRow(),1));
        idTxt = (int) model.getValueAt(TitleListTable.getSelectedRow(), 0);
        try {
            TitleDao titleDao = new TitleDao();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //随机出题
    private void button1ActionPerformed(ActionEvent e) {
        if (TitleListTable.getRowCount()>1){
            max = TitleListTable.getRowCount();
        }
        Random random = new Random();
        TitleDao titleDao = new TitleDao();
        int[] s =  new int[5];
        for (int i = 0;i<5;i++){
            s[i] = 1+random.nextInt(max+1);
        }
        List<Title> titles = titleDao.randomNumber(s[0], s[1], s[2],s[3],s[4]);
        setTitleTable(titles.get(0));
    }
    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }
    private void TitleListTableMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        TitleListTable = new JTable();
        submitButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        TitleTypeComboBox = new JComboBox();
        RightButton = new JButton();
        WrongButton = new JButton();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        TitleTextArea = new JTextArea();
        KeyTitleTextField = new JTextField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u9898\u76ee\u67e5\u627e");
        setClosable(true);
        setMaximizable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane1MouseClicked(e);
                }
            });

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
                public void mouseClicked(MouseEvent e) {
                    TitleListTableMouseClicked(e);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    TitleListTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(TitleListTable);
        }

        //---- submitButton ----
        submitButton.setText("\u67e5\u8be2");
        submitButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        submitButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
        submitButton.addActionListener(e -> submitButtonActionPerformed(e));

        //---- label1 ----
        label1.setText("\u9898\u76ee\u5173\u952e\u5b57\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));

        //---- label2 ----
        label2.setText("\u9898\u76ee\u7c7b\u578b\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u9898\u76ee\u96be\u5ea6.png")));

        //---- RightButton ----
        RightButton.setText("\u6211\u505a\u5bf9\u5566");
        RightButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        RightButton.addActionListener(e -> RightButtonActionPerformed(e));

        //---- WrongButton ----
        WrongButton.setText("\u6211\u505a\u9519\u4e86");
        WrongButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        WrongButton.addActionListener(e -> WrongButtonActionPerformed(e));

        //---- label3 ----
        label3.setText("\u9898\u76ee\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u7c7b\u578b\u4fe1\u606f.png")));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(TitleTextArea);
        }

        //---- button1 ----
        button1.setText("\u968f\u673a\u51fa\u9898");
        button1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u968f\u673a.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(submitButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addContainerGap(84, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(KeyTitleTextField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(302, Short.MAX_VALUE))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(RightButton)
                        .addComponent(WrongButton))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(KeyTitleTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(TitleTypeComboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1)
                        .addComponent(submitButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 11, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(RightButton)
                                    .addGap(35, 35, 35)
                                    .addComponent(WrongButton)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(120, 120, 120))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 50, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitleType();
        setTitleTable(new Title());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable TitleListTable;
    private JButton submitButton;
    private JLabel label1;
    private JLabel label2;
    private JComboBox TitleTypeComboBox;
    private JButton RightButton;
    private JButton WrongButton;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea TitleTextArea;
    private JTextField KeyTitleTextField;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
