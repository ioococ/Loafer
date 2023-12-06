package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import szkj.dao.InitDatabase;
import szkj.dao.userTableDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserModifyPassWord extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JFrame pFrame;
	private JButton btnCancel;
	private String DLname; //当前登录的用户名
	private JPasswordField Edit_Py;
	private JPasswordField Edit_P1;
	private JPasswordField Edit_P2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserModifyPassWord frame = new UserModifyPassWord();
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
	public UserModifyPassWord(JFrame pFrame) {
		this.pFrame=pFrame;//父窗口
		if (pFrame.getClass().getName()=="Frame.SubCxForm") {
			   this.DLname=((SubCxForm)pFrame).DLname;//登录的用户名
		}else if (pFrame.getClass().getName()=="Frame.SubUserForm") {
				this.DLname=((SubUserForm)pFrame).DLname;//登录的用户名
		}
		setResizable(false);
		setTitle("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭并释放当前窗口
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
        //设置窗口打开后在屏中的位置
		setBounds((screenWidth-446)/2, (screenHeight-316)/2-100, 446, 316);
		
		//setBounds(100, 100, 446, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btn_OK = new JButton("\u786E  \u5B9A");
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ //修改密码确定
				InitDatabase idb =new InitDatabase();
				idb.con=idb.getConnection();
				userTableDao utd=new userTableDao();
				
		        try {
					idb.CreateDataBase(); //切换数据库到testkc
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					return;
				}
				//1.先判断原密码是否正确
		        try {
			        if (utd.DlYz(idb.con,Edit_P1.getText(), Edit_P2.getText())) {
			        	//2.新密码1 与 新密码2做比对
			        	if (Edit_P1.getText().trim()!=(Edit_P2.getText().trim())) {
			        		JOptionPane.showMessageDialog(null, "两次密码不一致，请重输！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
			        	}else {
			        	    utd.Modifypwd(idb.con, Edit_P1.getText().trim(), Edit_P2.getText().trim());
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
		        	
		        }
				
			}
		});
 
		btn_OK.setBounds(167, 209, 106, 48);
		JButton btnCancal = new JButton("\u9000  \u51FA");
		this.btnCancel=btnCancal;
		btnCancal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserModifyPassWord.this.dispose();//关闭并释放当前窗口
				UserModifyPassWord.this.pFrame.setEnabled(true);//父窗口置为活动
				UserModifyPassWord.this.pFrame.setVisible(true);//父窗口显示
		        ((SubCxForm)UserModifyPassWord.this.pFrame).textF1.requestFocus();
			}
		});
		
		btnCancal.setBounds(291, 212, 106, 43);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(23, 119, 144, 24);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel.setBounds(23, 68, 144, 24);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_3 = new JLabel("\u5F53\u524D\u7528\u6237\u540D\uFF1A");
		lblNewLabel_3.setBounds(15, 23, 144, 24);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lb_DLname = new JLabel("\u5F20\u4E09");
		lb_DLname.setBounds(172, 23, 144, 24);
		lb_DLname.setFont(new Font("宋体", Font.BOLD, 20));
		lb_DLname.setText(this.DLname);//显示当前用户的名称
		
		
		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(15, 164, 169, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lb_DLname);
		contentPane.add(btn_OK);
		contentPane.add(btnCancal);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		Edit_Py = new JPasswordField();
		Edit_Py.setBounds(172, 57, 237, 36);
		contentPane.add(Edit_Py);
		
		Edit_P1 = new JPasswordField();
		Edit_P1.setBounds(172, 107, 237, 36);
		contentPane.add(Edit_P1);
		
		Edit_P2 = new JPasswordField();
		Edit_P2.setBounds(172, 153, 237, 36);
		contentPane.add(Edit_P2);
		UserModifyPassWord.this.addWindowListener(this);
	}
          
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.btnCancel.doClick(); //点击退出按钮
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
		// TODO Auto-generated method stubs
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
