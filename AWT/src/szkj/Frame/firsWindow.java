package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import szkj.dao.InitDatabase;
import szkj.dao.userTableDao;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class firsWindow extends JFrame {

	private JPanel contentPane;
	private JTextField Tuser;
	private JPasswordField TPassword;
	public  String DLname="";
	private String password="123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firsWindow frame = new firsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws HeadlessException 
	 */
	public firsWindow() throws SQLException, HeadlessException {
		setTitle("\u7528\u6237\u767B\u5F55\uFF1A");
		setResizable(false);//设置窗口不能改变大小
		//点击关闭按钮后程序退出
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
        //设置窗口打开后在屏中的位置
		setBounds((screenWidth-600)/2, (screenHeight-327)/2-100, 619, 348);
		//setBounds(100, 100, 600, 327);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		lb1.setForeground(Color.CYAN);
		lb1.setFont(new Font("宋体", Font.BOLD, 26));
		lb1.setBounds(40, 80, 204, 51);
		contentPane.add(lb1);
		
		JButton btn1 = new JButton("\u786E\u5B9A");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitDatabase idb =new InitDatabase();
				idb.con=idb.getConnection();
		        try {
					idb.CreateDataBase(); //切换数据库到testkc
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					return;
				}
          
				userTableDao utd=new userTableDao();
				try {
					if (utd.DlYz(idb.con,Tuser.getText(), TPassword.getText())) {
						 DLname=Tuser.getText();
						 JOptionPane.showMessageDialog(null, "登录成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
						 SubCxForm scf=new SubCxForm(firsWindow.this);
     			         firsWindow.this.setVisible(false); //主程序隐藏
				         scf.setVisible(true);//查询窗口显示		 
					}else {
						 JOptionPane.showMessageDialog(null, "用户名或密码错！", "消息提示", JOptionPane.ERROR_MESSAGE);
						 Tuser.setText(""); //清空编辑框
						 TPassword.setText("");//清空编辑辑框
						 Tuser.requestFocus(); //编辑框获得输入焦点
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  
			}	 
		});
		
	
		btn1.setForeground(Color.DARK_GRAY);
		btn1.setBackground(Color.WHITE);
		btn1.setFont(new Font("宋体", Font.PLAIN, 30));
		btn1.setBounds(230, 214, 147, 51);
		contentPane.add(btn1);
		
		
		JLabel lb1_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		lb1_1.setForeground(Color.CYAN);
		lb1_1.setFont(new Font("宋体", Font.BOLD, 26));
		lb1_1.setBounds(40, 141, 204, 51);
		contentPane.add(lb1_1);
		
		TPassword = new JPasswordField();
		TPassword.setFont(new Font("宋体", Font.PLAIN, 26));
		TPassword.setBounds(242, 147, 315, 40);
		contentPane.add(TPassword);
		TPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btn1.doClick(); //当按下了回车键时，btn1按钮被点击
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton btn2 = new JButton("\u9000\u51FA");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn2.setForeground(Color.DARK_GRAY);
		btn2.setFont(new Font("宋体", Font.PLAIN, 30));
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(391, 214, 147, 51);
		contentPane.add(btn2);
		
		JLabel lb1_2 = new JLabel("\u901A\u7528\u5E93\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		lb1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb1_2.setForeground(Color.CYAN);
		lb1_2.setFont(new Font("宋体", Font.BOLD, 40));
		lb1_2.setBounds(66, 26, 453, 51);
		contentPane.add(lb1_2);

		
		Tuser = new JTextField();
		Tuser.setToolTipText("");
		Tuser.setFont(new Font("宋体", Font.PLAIN, 26));
		Tuser.setBounds(242, 87, 315, 36);
		contentPane.add(Tuser);
		Tuser.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 615, 320);
		contentPane.add(panel);
		
		JLabel LbPicture = new JLabel("New label");
		LbPicture.setLabelFor(lb1);
		LbPicture.setHorizontalAlignment(SwingConstants.LEFT);
		LbPicture.setEnabled(true);
		LbPicture.setIcon(new ImageIcon("C:\\Users\\csdny\\Pictures\\20.png"));
		//改变图片大小 
		//1.创建ImageIcon对象，并获取控件中的图片
        ImageIcon icon= (ImageIcon) LbPicture.getIcon();
        //2.设置图片的大小与容器的大小一至
        icon.setImage(icon.getImage().getScaledInstance(615, 320, Image.SCALE_DEFAULT));
        //3.Lable控年重新加载修改大小后的图片
        LbPicture.setIcon(icon);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(LbPicture, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(LbPicture, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		
	 
		//给编辑框添加按键监听器
		Tuser.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					TPassword.requestFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	 
	}
}
