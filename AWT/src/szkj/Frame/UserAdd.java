package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import szkj.dao.InitDatabase;
import szkj.dao.userTableDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPasswordField;

public class UserAdd extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField Edit_user;
	private JButton btnCancal;
	private JFrame  pFrame; //用来存放传入的父窗口
	private JPasswordField Edit_P1;
	private JPasswordField Edit_P2;
	public String DLname;
	private JButton btn_ok;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserAdd frame = new UserAdd();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UserAdd(JFrame pFrame) {
		this.pFrame=pFrame;//接收父窗口
		if (pFrame.getClass().getName()=="Frame.SubCxForm") {
		   this.DLname=((SubCxForm)pFrame).DLname;
		}else if (pFrame.getClass().getName()=="Frame.SubUserForm") {
			this.DLname=((SubUserForm)pFrame).DLname;
		}
		setResizable(false);
		setTitle("\u65B0\u589E\u7528\u6237\uFF1A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭并释放当前窗口
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
        //设置窗口打开后在屏中的位置
		setBounds((screenWidth-437)/2, (screenHeight-254)/2-100, 437, 254);
		//setBounds(100, 100, 437, 254);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 13, 144, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 66, 144, 24);
		contentPane.add(lblNewLabel_1);
		
		Edit_user = new JTextField();
		Edit_user.setFont(new Font("宋体", Font.BOLD, 20));
		Edit_user.setColumns(10);
		Edit_user.setBounds(171, 10, 234, 30);
		contentPane.add(Edit_user);
		Edit_user.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					Edit_P1.requestFocus(); //当按下了回车键时，btn1按钮被点击
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(23, 112, 144, 24);
		contentPane.add(lblNewLabel_2);
		
		Edit_P1 = new JPasswordField();
		Edit_P1.setBounds(171, 63, 234, 30);
		contentPane.add(Edit_P1);
		Edit_P1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					Edit_P1.requestFocus(); //当按下了回车键时，btn1按钮被点击
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Edit_P2 = new JPasswordField();
		Edit_P2.setBounds(171, 106, 234, 30);
		contentPane.add(Edit_P2);
		Edit_P2.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btn_ok.doClick(); //当按下了回车键时，btn1按钮被点击
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btn_OK = new JButton("\u786E  \u5B9A"); //确定按钮
		this.btn_ok=btn_OK;
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Edit_user.getText().trim()=="") {
					JOptionPane.showMessageDialog(null,"用户名不能为空，请输入用户名！","提示：",JOptionPane.INFORMATION_MESSAGE);
					Edit_user.requestFocus();//设置用户
					return;
				}
				if (Edit_P1.getText().trim()=="") {
					JOptionPane.showMessageDialog(null,"密码不能为空，请输入用户名！","提示：",JOptionPane.INFORMATION_MESSAGE);
					Edit_user.requestFocus();//设置密码
					return;
				}
				if (Edit_P1.getText().equals(Edit_P2.getText())) {//两次密码一致，那增加用户
					InitDatabase idb =new InitDatabase();
					idb.con=idb.getConnection();
			        try {
						idb.CreateDataBase(); //切换数据库到testkc
						userTableDao utd=new userTableDao();
						if  (utd.searchUser(idb.con,DLname)) {
							JOptionPane.showMessageDialog(null,"用户名已存在！","提示：",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						utd.addUser(idb.con, Edit_user.getText(), Edit_P1.getText(),DLname);//添加用户的方法
						if (pFrame!=null) { //如果有父窗口的话
							//JOptionPane.showMessageDialog(null,pFrame.getClass().getName(),"提示：",JOptionPane.INFORMATION_MESSAGE);
							if (pFrame.getClass().getName().equals("Frame.SubUserForm")) {//刷新表格
								//更新父窗口中名为UserTable的表中的记录集								
							    ((SubUserForm)pFrame).UserTable.setModel(new DefaultTableModel(
										utd.userRows(idb.con),
										utd.userColumn(idb.con)
								)); //刷新表格内容
							}
							JOptionPane.showMessageDialog(null,"用户添加成功！","提示：",JOptionPane.INFORMATION_MESSAGE);
							Edit_user.setText("");
						    Edit_P1.setText("");
						    Edit_P2.setText("");
						    Edit_user.requestFocus();
						};
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"用户添加失败","提示：",JOptionPane.INFORMATION_MESSAGE);
						e2.printStackTrace();
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null,"两次密码不一致","提示：",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		});
	 
		btn_OK.setBounds(175, 154, 106, 48);
		contentPane.add(btn_OK);
		
		JButton btnCancal = new JButton("\u9000  \u51FA"); //退出按钮
		this.btnCancal=btnCancal; 
		btnCancal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAdd.this.dispose();//关闭并释放当前窗口
				UserAdd.this.pFrame.setEnabled(true);//父窗口置为活动
				UserAdd.this.pFrame.setVisible(true);//父窗口显示
				((SubCxForm)UserAdd.this.pFrame).textF1.requestFocus();//主窗口编辑框获得焦点
			}
		});
		btnCancal.setBounds(299, 157, 106, 43);
		contentPane.add(btnCancal);
		
		
		UserAdd.this.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.btnCancal.doClick();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
