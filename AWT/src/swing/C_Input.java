package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.eltima.components.ui.DatePicker;
import manager.InitializeClass;
import manager.InputTableClass;

import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;

public class C_Input extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField tF_ID;
    private JTextField tF_Item;
    private JTextField tF_Num;
    private JTable table;
    private JFrame PFrame;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					C_Input frame = new C_Input();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}}});}

    /**
     * Create the frame.
     */
    public C_Input() throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\arrow-alt-circle-right.png"));
        setTitle("入库");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("入库流水表");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setLayout(null);

        JButton B_Query = new JButton("查询");
        B_Query.setBounds(384, 20, 110, 30);
        B_Query.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_Query.setBackground(Color.WHITE);
        panel.add(B_Query);
        B_Query.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                if (true){} else {
                    JOptionPane.showMessageDialog(null, "操作失败","消息提示",JOptionPane.ERROR_MESSAGE);
                }}});

        textField = new JTextField();
        textField.setBounds(156, 22, 204, 30);
        textField.setColumns(10);
        panel.add(textField);

        Date date = new Date();
        DatePicker datePicker = new DatePicker(date,"yyyy-MM-dd",null,null);
        datePicker.setBounds(156, 20, 204, 33);
        panel.add(datePicker);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(39, 23, 107, 30);
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(comboBox);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

        JLabel L_ID = new JLabel("编号：");
        L_ID.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_ID.setBounds(30, 13, 55, 30);
        panel_1.add(L_ID);

        tF_ID = new JTextField();
        tF_ID.setColumns(10);
        tF_ID.setBounds(90, 13, 100, 30);
        panel_1.add(tF_ID);

        JLabel L_Item = new JLabel("名称：");
        L_Item.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_Item.setBounds(230, 13, 55, 30);
        panel_1.add(L_Item);

        tF_Item = new JTextField();
        tF_Item.setColumns(10);
        tF_Item.setBounds(290, 13, 170, 30);
        panel_1.add(tF_Item);

        JLabel L_Num = new JLabel("数量：");
        L_Num.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_Num.setBounds(524, 13, 55, 30);
        panel_1.add(L_Num);

        tF_Num = new JTextField();
        tF_Num.setColumns(10);
        tF_Num.setBounds(585, 13, 55, 30);
        panel_1.add(tF_Num);

        JButton button = new JButton("录入");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(734, 13, 80, 30);
        panel_1.add(button);
        button.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                InitializeClass ic = new InitializeClass();
                InputTableClass itc = new InputTableClass();
                try {
                    itc.iT(ic.conn,tF_ID.getText(),tF_Item.getText(),tF_Num.getText());
                    JOptionPane.showMessageDialog(null, "操作成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                        .addGap(697))
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE))
                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        InputTableClass itc = new InputTableClass();
        InitializeClass ic = new InitializeClass();
        table.setModel(new DefaultTableModel(
                itc.inputRowsDate(ic.conn,datePicker.getText().trim()),
                itc.intputColumn(ic.conn)
        ));
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        scrollPane.setColumnHeaderView(table);
        contentPane.setLayout(gl_contentPane);
    }
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
