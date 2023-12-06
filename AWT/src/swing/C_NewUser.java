package swing;

import manager.InitializeClass;
import manager.UserTableClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.SystemColor;
import java.sql.SQLException;

public class C_NewUser extends JFrame {

    private JPanel contentPane;
    private JTextField tF_textField;
    private JPasswordField pF_passwordField_1;
    private JPasswordField pF_passwordField_2;
    private JFrame PFrame;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					C_NewUser frame = new C_NewUser();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}}});}

    /**
     * Create the frame.
     */
    public C_NewUser(JFrame PForm) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(C_NewUser.class.getResource("/swing/user-add.png")));
        setTitle("创建用户");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel L_Name = new JLabel("用户名");
        L_Name.setForeground(Color.LIGHT_GRAY);
        L_Name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_Name.setBounds(81, 58, 65, 30);
        contentPane.add(L_Name);

        tF_textField = new JTextField();
        tF_textField.setColumns(10);
        tF_textField.setBounds(70, 58, 300, 30);
        contentPane.add(tF_textField);
        tF_textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent documentEvent) {
                L_Name.setVisible(false);
            }
            @Override
            public void removeUpdate (DocumentEvent documentEvent) {}
            @Override
            public void changedUpdate (DocumentEvent documentEvent) {}});

        JLabel L_Password_2 = new JLabel("密码");
        L_Password_2.setForeground(Color.LIGHT_GRAY);
        L_Password_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_Password_2.setBounds(80, 160, 40, 30);
        contentPane.add(L_Password_2);

        pF_passwordField_1 = new JPasswordField();
        pF_passwordField_1.setBounds(70, 159, 300, 30);
        contentPane.add(pF_passwordField_1);
        pF_passwordField_1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent documentEvent) {
                L_Name.setVisible(false);
            }
            @Override
            public void removeUpdate (DocumentEvent documentEvent) {}
            @Override
            public void changedUpdate (DocumentEvent documentEvent) {}});

        JLabel L_Password = new JLabel("密码");
        L_Password.setForeground(Color.LIGHT_GRAY);
        L_Password.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        L_Password.setBounds(80, 110, 40, 30);
        contentPane.add(L_Password);

        pF_passwordField_2 = new JPasswordField();
        pF_passwordField_2.setBounds(70, 110, 300, 30);
        contentPane.add(pF_passwordField_2);
        pF_passwordField_2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent documentEvent) {
                L_Name.setVisible(false);
            }
            @Override
            public void removeUpdate (DocumentEvent documentEvent) {}
            @Override
            public void changedUpdate (DocumentEvent documentEvent) {}});

        JButton B_ok = new JButton("创建");
        B_ok.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_ok.setBackground(Color.WHITE);
        B_ok.setBounds(167, 210, 110, 30);
        contentPane.add(B_ok);
        B_ok.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                InitializeClass ic = new InitializeClass();
                UserTableClass utf = new UserTableClass();
                try {
                    utf.addUser(ic.conn,tF_textField.getText(), pF_passwordField_1.getText());
                    if (pF_passwordField_1.getText().equals(pF_passwordField_2.getText())){
                        JOptionPane.showMessageDialog(null, "操作成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "操作失败","消息提示",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}});
    }

}
