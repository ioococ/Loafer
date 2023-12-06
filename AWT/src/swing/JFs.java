package swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class JFs extends JFrame{

    private JPanel contentPane;
    private JTextField Tuser;
    private JPasswordField TpW;
    private String user = "1";
    private String password = "1";



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFs frame = new JFs();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JFs() {
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
        userName.setBounds(105, 58, 83, 47);
        contentPane.add(userName);
        Tuser = new JTextField();
        Tuser.setBounds(198, 71, 176, 28);
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

        //JLabel 密码
        JLabel passWord = new JLabel("密码");
        passWord.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\lock.png"));
//        passWord.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\Desktop\\QQ\u622A\u56FE20211106162028.png"));
        passWord.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        passWord.setBounds(105, 113, 83, 47);
        contentPane.add(passWord);
        TpW = new JPasswordField();
        TpW.setBounds(198, 126, 176, 28);
        contentPane.add(TpW);

        //JButton 登录按钮
        JButton register = new JButton("登录");
        register.setBackground(Color.WHITE);
        register.setForeground(Color.BLACK);
        register.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        register.setIcon(null);
        register.setBounds(154, 191, 142, 39);
        contentPane.add(register);
        register.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                if((Tuser.getText().equals(user))&&(TpW.getText().equals(password))) {
                    JOptionPane.showMessageDialog(null, "登陆成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误！","消息提示",JOptionPane.ERROR_MESSAGE);
                    TpW.setText("");//清空编辑框
                    Tuser.requestFocus();//编辑框获得输入焦点
                }}});

        //JButton 注册按钮
        JButton signup = new JButton("注册账号");
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.BLACK);
        signup.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        signup.setBounds(0, 239, 97, 23);
        contentPane.add(signup);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\\u8363\u8000\\eclipse-workspace\\AWT\\src\\swing\\sidebar.png"));
        lblNewLabel_1.setBounds(381, 209, 40, 39);
        contentPane.add(lblNewLabel_1);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
//                SubUserForm suf=new SubUserForm();
                C_UserForm suf= null;
                try {
                    suf = new C_UserForm(JFs.this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                suf.setVisible(true);
            }});
    }
}
