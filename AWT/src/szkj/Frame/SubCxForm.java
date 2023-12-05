package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;


import szkj.dao.InitDatabase;
import szkj.dao.currentNumDao;
import szkj.dao.inputTableDao;

import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import com.eltima.components.ui.DatePicker;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.InputEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class SubCxForm extends JFrame implements WindowListener{

	private JPanel contentPane;
	public JTable table;
	public  JTextField textF1;
	private JTextField Edit;
	private JTextField Edit_1;
	public  String DLname;
	private JFrame pFrame;
 
 

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SubCxFrom frame = new SubCxFrom();
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
	public SubCxForm(JFrame Frame) {
		this.pFrame=Frame; //接收传入的父窗口
		
		this.DLname=((firsWindow)Frame).DLname;
		setTitle("\u5E93\u5B58\u67E5\u8BE2:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭的时候直接退出系统
		
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();//获取可视区域的大
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
 
		
		//设置窗口打开后在屏中的位置
		setBounds((screenWidth-1062)/2, (screenHeight-609)/2, 1062, 609);			
		//setBounds(100, 100, 1062, 609);
		
		
		JButton btn_rk = new JButton("\u5165\u5E93");
		btn_rk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputForm input =new InputForm(SubCxForm.this);
				SubCxForm.this.setEnabled(false);;
				input.setVisible(true);
			}
		});
		btn_rk.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btn_ck = new JButton("\u51FA\u5E93");
		btn_ck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputForm output =new OutputForm(SubCxForm.this);
				SubCxForm.this.setEnabled(false);;
				output.setVisible(true);
			}
		});
		btn_ck.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem M_userCx = new JMenuItem("\u7528\u6237\u67E5\u8BE2");
		mnNewMenu.add(M_userCx);
		
		JMenuItem M_userXz = new JMenuItem("\u65B0\u589E\u7528\u6237");
		mnNewMenu.add(M_userXz);
		
		JMenuItem M_userXg = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mnNewMenu.add(M_userXg);
		
		JMenuItem M_userSc = new JMenuItem("\u5220\u9664\u7528\u6237");
		mnNewMenu.add(M_userSc);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E93\u5B58\u64CD\u4F5C");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem M_Input = new JMenuItem("\u5165\u5E93\u64CD\u4F5C");
		M_Input.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
		mnNewMenu_1.add(M_Input);
		
		JMenuItem M_Output = new JMenuItem("\u51FA\u5E93\u64CD\u4F5C");
		M_Output.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		mnNewMenu_1.add(M_Output);
		
		M_userCx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SubUserForm suf;
				try {
					suf = new SubUserForm(SubCxForm.this);
					suf.setVisible(true);//显示子窗口
					SubCxForm.this.setEnabled(false);//主窗口变为不可用
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//创建子窗口
				
			}
		});
		M_Input.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_rk.doClick();
			}
			 
		});
		M_Output.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_ck.doClick();
			}
			
		});
		M_userXz.addActionListener(new ActionListener() { //新增用户
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserAdd ua=new UserAdd(SubCxForm.this);
				SubCxForm.this.setEnabled(false);
				ua.setVisible(true);
			}
			
		});
		M_userXg.addActionListener(new ActionListener() { //修改用户密码

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserModifyPassWord umpw=new UserModifyPassWord(SubCxForm.this);
				SubCxForm.this.setEnabled(false);
				umpw.setVisible(true);
			}
			
		});
		M_userSc.addActionListener(new ActionListener() { //删除用户

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserDelete ud=new UserDelete(SubCxForm.this);
				SubCxForm.this.setEnabled(false);
				ud.setVisible(true);
			}
			
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		this.table=table;
		table.setFont(new Font("宋体", Font.BOLD, 20));
		table.setRowHeight(30);//设置行高
		JTableHeader head = table.getTableHeader(); // 创建表格标题对象
        //head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头高度
		head.setFont(new Font("宋体", Font.BOLD, 15));// 设置表头字体
	 
		
		InitDatabase idb=new InitDatabase();//创建数据库初始化对象
		try {
			idb.con=idb.getConnection(); //创建连接
			idb.CrateTable();//切换数据库
			currentNumDao cnd=new currentNumDao();
			table.setModel(new DefaultTableModel(
				cnd.currentNumRows(idb.con),
				cnd.currentNumColumn(idb.con)
			));
		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("\u65F6\u5B9E\u5E93\u5B58\u8868");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("隶书", Font.BOLD, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE))
					.addGap(7))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		Edit_1 = new JTextField();
		Edit_1.setColumns(10);
		this.Edit_1=Edit_1;
		
		
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	              System.exit(0); //退出系统
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.setLayout(gl_contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u663E\u793A\u5168\u90E8\u8BB0\u5F55", "\u6309\u540D\u79F0\u67E5\u8BE2", "\u6309\u7F16\u53F7\u67E5\u8BE2"}));
		comboBox.setSelectedIndex(0);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton btn_Cx = new JButton("\u67E5\u8BE2");
		btn_Cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()==0) { //显示全部记录
					try {
						idb.CrateTable();//切换数据库
						currentNumDao cnd=new currentNumDao();
						table.setModel(new DefaultTableModel(
							cnd.currentNumRows(idb.con),
							cnd.currentNumColumn(idb.con)
						));
					}catch(SQLException e1) {
						e1.printStackTrace();
						return;
					}
				}else if(comboBox.getSelectedIndex()==1){//按名称查询
					try {
						idb.CrateTable();//切换数据库
						currentNumDao cnd=new currentNumDao();
						table.setModel(new DefaultTableModel(
							cnd.searchName(idb.con,Edit.getText().trim()),
							cnd.currentNumColumn(idb.con)
						));
					}catch(SQLException e1) {
						e1.printStackTrace();
						return;
					}
				}else if(comboBox.getSelectedIndex()==2) {//按编号查询
					try {
						idb.CrateTable();//切换数据库
						currentNumDao cnd=new currentNumDao();
						table.setModel(new DefaultTableModel(
							cnd.searchBh(idb.con,Edit.getText().trim()),
							cnd.currentNumColumn(idb.con)
						));
					}catch(SQLException e1) {
						e1.printStackTrace();
						return;
					}
				}
			}
		});
		btn_Cx.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(139, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(Edit_1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btn_Cx, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btn_rk, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btn_ck, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(Edit_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(btn_Cx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(btn_rk, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(btn_ck, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		SubCxForm.this.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
