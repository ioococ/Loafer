package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import szkj.dao.InitDatabase;
import szkj.dao.userTableDao;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SubUserForm extends JFrame implements WindowListener{

	private JPanel  contentPane;
	public JTable   UserTable;
	private JFrame  PFrame;
	private JButton btnCancel;
	public String   DLname;
 

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SubUserForm frame = new SubUserForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public SubUserForm(JFrame PForm) throws SQLException {
		this.PFrame=PForm;//父窗口
		this.DLname=((SubCxForm)PForm).DLname;
		setTitle("\u7528\u6237\u7BA1\u7406\uFF1A");
		//参数JFrame.EXIT_ON_CLOSE 为当窗口关闭时全部退出
		//参数JFrame.DISPOSE_ON_CLOSE 只关闭当前窗口，程序不全部退出
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
        //设置窗口打开后在屏中的位置
		setBounds((screenWidth-773)/2, (screenHeight-560)/2-100, 773, 560);
		//setBounds(100, 100, 773, 560);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u8868\uFF1A");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 22));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("\u589E\u52A0\u7528\u6237");//增加用户按钮
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "adfsdf！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
				UserAdd ua=new UserAdd(SubUserForm.this);
				SubUserForm.this.setEnabled(false);
				ua.setVisible(true);
			}
		});
		
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JButton btnModifyPassword = new JButton("\u4FEE\u6539\u5BC6\u7801");//修改密码
		btnModifyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserModifyPassWord umpw=new UserModifyPassWord(SubUserForm.this);
				SubUserForm.this.setEnabled(false);
				umpw.setVisible(true);
			}
		});
		btnModifyPassword.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JButton btnDeleteUser = new JButton("\u5220\u9664\u7528\u6237");//删除用户按钮
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDelete ud=new UserDelete(SubUserForm.this);//创建删除用户窗口
				SubUserForm.this.setEnabled(false); 
				ud.setVisible(true);
			}
		});
		btnDeleteUser.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JButton btnCancel = new JButton("\u9000  \u51FA"); //退出按钮
		this.btnCancel=btnCancel;
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubUserForm.this.dispose();//关闭释放当前窗口
				SubUserForm.this.PFrame.setEnabled(true); //父窗口设为可以活动
				SubUserForm.this.PFrame.setVisible(true);  //父窗口显示到顶层
				((SubCxForm)SubUserForm.this.PFrame).textF1.requestFocus(); //父窗口编辑框获得输入焦点
			}
		});
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
							.addGap(149)))
					.addGap(0))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnModifyPassword, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifyPassword, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		
		InitDatabase idb=new InitDatabase();//创建数据库初始化对象
		idb.con=idb.getConnection(); //创建连接
	    idb.CrateTable();//切换数据库
	    
		userTableDao utd=new userTableDao();
	   
		UserTable = new JTable();
		UserTable.setModel(new DefaultTableModel(
				utd.userRows(idb.con),
				utd.userColumn(idb.con)
		));	
		
		UserTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(UserTable);
		contentPane.setLayout(gl_contentPane);
		
		this.addWindowListener(this);//引入监听接口后使监听生效 不然下面的真对窗口监听不起作用。
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.btnCancel.doClick();
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
