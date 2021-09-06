/*
 * Created by JFormDesigner on Fri Aug 27 14:32:31 CST 2021
 */

package view;

import dao.TitleRecordDao;
import modle.TitleRecord;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class PerTimeSetting extends JInternalFrame {
    public PerTimeSetting() {
        initComponents();
    }
    //点击确认提交的按钮
    private void button1ActionPerformed(ActionEvent e) {
        //先获取用户设置的时间
        TitleRecord titleRecord = new TitleRecord();
        Object hour = HourSpinner.getValue();
        int h =Integer.parseInt(hour.toString() );//时
        Object minutes = minutesSpinner.getValue();
        int m =Integer.parseInt(hour.toString() );//分
        Object second = SecondSpinner.getValue();
        int s =Integer.parseInt(hour.toString() );//秒
        //点击按钮的时间
        Date ti = SearchTitleFrm.clickDate.getTime();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1=format.format(ti);//time就是当前时间
        //点击按钮的时间加上用户设置的时间
        SearchTitleFrm.clickDate.add(Calendar.HOUR, h);
        SearchTitleFrm.clickDate.add(Calendar.MINUTE, m);
        SearchTitleFrm.clickDate.add(Calendar.SECOND, s);
        Date time=SearchTitleFrm.clickDate.getTime();
        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2=format1.format(time);//time2就是点击我做对了按钮的时间加上用户设置的时间,即为下次出现的时间
        TitleRecord titleRecord2 = new TitleRecord();
        titleRecord2.setTitle_id(SearchTitleFrm.nowid);
        titleRecord2.setCreate_date(time1);
        titleRecord2.setNext_date(time2);
        TitleRecordDao titleRecordDao=null;
        try {
            titleRecordDao=new TitleRecordDao();
            if (titleRecordDao.addTitleResultRecord(titleRecord2)){
                JOptionPane.showMessageDialog(null,"题目记录成功！");
            }else{
                JOptionPane.showMessageDialog(null,"题目记录失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        frame1 = new JFrame();
        panel1 = new JPanel();
        SecondSpinner = new JSpinner();
        label4 = new JLabel();
        HourSpinner = new JSpinner();
        label2 = new JLabel();
        minutesSpinner = new JSpinner();
        label3 = new JLabel();
        SubmitButton = new JButton();

        //======== frame1 ========
        {
            frame1.setVisible(true);
            var frame1ContentPane = frame1.getContentPane();

            //======== panel1 ========
            {
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
                .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER ,javax
                . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,
                12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans
                .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e.
                getPropertyName () ) )throw new RuntimeException( ) ;} } );

                //---- SecondSpinner ----
                SecondSpinner.setModel(new SpinnerNumberModel(0, 0, 59, 1));

                //---- label4 ----
                label4.setText("\u79d2");
                label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                //---- HourSpinner ----
                HourSpinner.setModel(new SpinnerNumberModel(24, 0, null, 1));

                //---- label2 ----
                label2.setText("\u5c0f\u65f6");
                label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                //---- minutesSpinner ----
                minutesSpinner.setModel(new SpinnerNumberModel(0, 0, 59, 1));

                //---- label3 ----
                label3.setText("\u5206\u949f");
                label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                //---- SubmitButton ----
                SubmitButton.setText("\u786e\u8ba4\u63d0\u4ea4");
                SubmitButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                SubmitButton.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4 .png")));
                SubmitButton.addActionListener(e -> button1ActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(HourSpinner, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minutesSpinner, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label3))
                                .addComponent(SubmitButton))
                            .addGap(18, 18, 18)
                            .addComponent(SecondSpinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(61, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(HourSpinner, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(minutesSpinner, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(SecondSpinner, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(SubmitButton)
                            .addGap(36, 36, 36))
                );
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame frame1;
    private JPanel panel1;
    private JSpinner SecondSpinner;
    private JLabel label4;
    private JSpinner HourSpinner;
    private JLabel label2;
    private JSpinner minutesSpinner;
    private JLabel label3;
    private JButton SubmitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
