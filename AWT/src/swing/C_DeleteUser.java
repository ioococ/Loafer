package swing;

import manager.InitializeClass;
import manager.UserTableClass;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class C_DeleteUser extends JFrame {

    private JPanel contentPane;
    private JFrame PFrame;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					C_DeleteUser frame = new C_DeleteUser();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}}});}

    /**
     * Create the frame.
     */
    public C_DeleteUser (JFrame PFrame) throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(C_DeleteUser.class.getResource("/swing/trash.png")));
        setTitle("\u5220\u9664\u7528\u6237");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel L_UserName = new JLabel("请选择要删除的用户：");
        L_UserName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_UserName.setBounds(85, 68, 193, 30);
        contentPane.add(L_UserName);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(281, 68, 79, 30);
        QueryRunner qr = new QueryRunner();
        String sql = "select userName from userTable";
        List<Object[]> lists = qr.query(InitializeClass.conn, sql, new ArrayListHandler());
        //打印输出
        for (Object[] objs : lists) {
            for (Object obj : objs) {
                comboBox.addItem(obj);
            }
            System.out.println();
        }
        contentPane.add(comboBox);

        JButton B_delete = new JButton("删除");
        B_delete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_delete.setBackground(Color.WHITE);
        B_delete.setBounds(174, 150, 110, 30);
        contentPane.add(B_delete);
        B_delete.addActionListener(new ActionListener() { // 鼠标 监听 按下
            public void actionPerformed (ActionEvent e) {
                UserTableClass utc = new UserTableClass();
                try {
                    utc.deleteUser(InitializeClass.conn, comboBox.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null, "操作成功", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    int index = comboBox.getSelectedIndex();
                    comboBox.removeItemAt(index);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
