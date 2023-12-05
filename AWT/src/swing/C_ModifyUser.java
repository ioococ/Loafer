package swing;

import manager.InitializeClass;
import manager.UserTableClass;
import szkj.Frame.SubCxForm;
import szkj.Frame.UserModifyPassWord;

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

public class C_ModifyUser extends JFrame {

	private JPanel contentPane;
    private JFrame PFrame;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					C_ChangePassword frame = new C_ChangePassword();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}}});}

	/**
	 * Create the frame.
	 */
	public C_ModifyUser(JFrame PFrame) {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setIconImage(Toolkit.getDefaultToolkit().getImage(C_ModifyUser.class.getResource("/swing/key.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel L_Name = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		L_Name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		L_Name.setBounds(71, 34, 129, 30);
		contentPane.add(L_Name);

		UserTableClass utc = new UserTableClass();
		InitializeClass ic = new InitializeClass();
		JLabel LL_Name_1 = new JLabel();
		LL_Name_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		LL_Name_1.setBounds(201, 34, 129, 30);
		contentPane.add(LL_Name_1);
		
		JLabel L_Name_2_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		L_Name_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		L_Name_2_1.setBounds(71, 86, 120, 30);
		contentPane.add(L_Name_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 86, 170, 30);
		contentPane.add(passwordField);
		
		JLabel L_Name_2 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		L_Name_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		L_Name_2.setBounds(71, 143, 120, 30);
		contentPane.add(L_Name_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(201, 143, 170, 30);
		contentPane.add(passwordField_1);
		
		JButton B_modify = new JButton("修改");
		B_modify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		B_modify.setBackground(Color.WHITE);
		B_modify.setBounds(168, 210, 110, 30);
		contentPane.add(B_modify);
		B_modify.addActionListener(new ActionListener(){ // 鼠标 监听 按下
			public void actionPerformed(ActionEvent e) {
				try {
					UserTableClass utc = new UserTableClass();
					InitializeClass ic = new InitializeClass();
					if (utc.DlYz(ic.conn,passwordField.getText(), passwordField_1.getText())) {
						//2.新密码1 与 新密码2做比对
						if (passwordField.getText().trim()!=(passwordField_1.getText().trim())) {
							JOptionPane.showMessageDialog(null, "两次密码不一致，请重输！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
						}else {
							utc.Modifypwd(ic.conn, passwordField.getText().trim(), passwordField_1.getText().trim());
							JOptionPane.showMessageDialog(null, "密码修改成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
						}

					}else {
						JOptionPane.showMessageDialog(null, "原密码不正确，请重新输入原密码！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "密码修改失败！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
					return;

				}}});




	}
}
