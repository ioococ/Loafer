package swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import manager.InitializeClass;
import manager.UserTableClass;

public class JFrames extends JFrame{

    private JPanel contentPane;
    private JTextField Tuser;
    private JPasswordField TpW;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrames frame = new JFrames();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JFrames() throws Throwable{
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("通用库存管理系统");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        lblNewLabel.setBounds(135, 10, 239, 38);
        contentPane.add(lblNewLabel);

        //JLabel 用户名
        JLabel userName = new JLabel("\u7528\u6237");
        userName.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\user.png"));
        userName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        userName.setBounds(90, 70, 65, 30);
        contentPane.add(userName);
        Tuser = new JTextField();
        Tuser.setBounds(75, 70, 300, 30);
        contentPane.add(Tuser);
        Tuser.setColumns(10);
        Tuser.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped (KeyEvent keyEvent) {}

            @Override
            public void keyPressed (KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                    TpW.requestFocus();
                }
            }
            @Override
            public void keyReleased (KeyEvent keyEvent) {}});
        Tuser.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent documentEvent) {
                userName.setVisible(false);
            }
            @Override
            public void removeUpdate (DocumentEvent documentEvent) {}
            @Override
            public void changedUpdate (DocumentEvent documentEvent) {}});
        //JLabel 密码
        JLabel passWord = new JLabel("密码");
        passWord.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\lock.png"));
        passWord.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        passWord.setBounds(90, 125, 65, 30);
        contentPane.add(passWord);
        TpW = new JPasswordField();
        TpW.setBounds(75, 125, 300, 30);
        contentPane.add(TpW);
        TpW.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent documentEvent) {
                passWord.setVisible(false);
            }
            @Override
            public void removeUpdate (DocumentEvent documentEvent) {}
            @Override
            public void changedUpdate (DocumentEvent documentEvent) {}});

        //JButton 登录按钮
        JButton register = new JButton("登录");
        register.setBackground(Color.WHITE);
        register.setForeground(Color.BLACK);
        register.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        register.setIcon(null);
        register.setBounds(150, 190, 140, 40);
        contentPane.add(register);
        register.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                InitializeClass ic = new InitializeClass();
                ic.getConnection();
                UserTableClass utc = new UserTableClass();
                try {
                    if(utc.validationUser(ic.conn,Tuser.getText(),TpW.getText())) {
                        C_Query qc =new C_Query(JFrames.this);
                        qc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "登陆成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误！","消息提示",JOptionPane.ERROR_MESSAGE);
                        TpW.setText("");//清空编辑框
                        Tuser.requestFocus();//编辑框获得输入焦点
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});



        //JButton 注册按钮
        JButton signup = new JButton("注册账号");
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.BLACK);
        signup.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        signup.setBounds(0, 239, 97, 23);
        contentPane.add(signup);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_NewUser cnu =new C_NewUser(JFrames.this);
                cnu.setVisible(true);
            }});
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\sidebar.png"));
        lblNewLabel_1.setBounds(381, 209, 40, 39);
        contentPane.add(lblNewLabel_1);
    }
}
