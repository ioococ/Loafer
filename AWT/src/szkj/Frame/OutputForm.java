package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.eltima.components.ui.DatePicker;

import szkj.dao.InitDatabase;
import szkj.dao.currentNumDao;
import szkj.dao.inputTableDao;
import szkj.dao.outputTableDao;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class OutputForm extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField Edit_Bh;
	private JTextField Edit_Mc;
	private JTextField Edit_Sl;
	private JTable table;
	private JFrame pFrame;
	private String DLname;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InputForm frame = new InputForm();
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
	public OutputForm(JFrame pFrame) {
		setTitle("\u5165\u5E93\u7BA1\u7406\uFF1A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pFrame = pFrame; //接收父窗口
		this.pFrame=pFrame; //接收父窗口
		this.DLname=((SubCxForm)pFrame).DLname;
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();//获取可视区域的大
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		//设置窗口打开后在屏中的位置
		setBounds((screenWidth-918)/2, (screenHeight-545)/2+100, 918,545);	
		//setBounds(100, 100, 918, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u5E93\u6D41\u6C34\u8868:");
		lblNewLabel_2.setFont(new Font("隶书", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(745, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 894, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 894, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		
		Date date = new Date();
		DatePicker Dp1 = new DatePicker(date,"yyyy-MM-dd",null,null);
		Dp1.getInnerTextField().setFont(new Font("宋体", Font.BOLD, 18));
		Dp1.setBounds(62, 10, 197, 33);
		panel_1.add(Dp1);
	     
		
		DatePicker Dp2 = new DatePicker(date,"yyyy-MM-dd",null,null);
		Dp2.getInnerTextField().setFont(new Font("宋体", Font.BOLD, 18));
		Dp2.setBounds(316, 10, 197, 33);
		panel_1.add(Dp2);
		panel.setLayout(null);
		
        InitDatabase idb=new InitDatabase();//创建数据库初始化对象
		
		outputTableDao otd=new outputTableDao();
		idb.con=idb.getConnection(); //创建连接
		table = new JTable();
		
		try {
			idb.CreateDataBase();//切换数据库
			table.setModel(new DefaultTableModel(
					otd.inputRowsDate(idb.con,Dp1.getText().trim(),Dp2.getText().trim()),
					otd.intputColumn(idb.con)
			));
		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}
		
		scrollPane.setViewportView(table);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("\u9000\u51FA");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputForm.this.dispose();//关闭当前窗口
				OutputForm.this.pFrame.setEnabled(true); //父窗口设为可以活动
				OutputForm.this.pFrame.show();  //父窗口显示到顶层
			}
		});
		btnNewButton_1_2.setBounds(753, 4, 111, 39);
		btnNewButton_1_2.setFont(new Font("宋体", Font.PLAIN, 26));
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("\u67E5\u627E");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InitDatabase idb=new InitDatabase();//创建数据库初始化对象
				//idb.con=idb.getConnection(); //创建连接
			    try {
					idb.CrateTable();//切换数据库
					//显示记录
					//inputTableDao itd=new inputTableDao();
					table.setModel(new DefaultTableModel(
							otd.inputRowsDate(idb.con,Dp1.getText().trim(),Dp2.getText().trim()),
							otd.intputColumn(idb.con)
						));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "记录添加失败！", "提示:", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
					return;
				}//切换数据库
				
			    JOptionPane.showMessageDialog(null,"共找到 "+table.getRowCount()+" 条记录！","提示：",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1_3.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_1_3.setBounds(616, 4, 111, 39);
		panel_1.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u81F3");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_1_2.setBounds(279, 12, 26, 31);
		panel_1.add(lblNewLabel_1_2);
		
		
		
		JLabel lb = new JLabel("\u7F16\u53F7\uFF1A");
		lb.setFont(new Font("宋体", Font.PLAIN, 26));
		lb.setBounds(10, 10, 87, 31);
		panel.add(lb);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(229, 10, 87, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_1_1.setBounds(531, 10, 87, 31);
		panel.add(lblNewLabel_1_1);
		
		Edit_Bh = new JTextField();
		Edit_Bh.setFont(new Font("宋体", Font.PLAIN, 26));
		Edit_Bh.setBounds(76, 10, 147, 29);
		panel.add(Edit_Bh);
		Edit_Bh.setColumns(10);
		Edit_Bh.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						//InitDatabase idb=new InitDatabase();//创建数据库初始化对象
						//idb.con=idb.getConnection(); //创建连接 
						idb.CrateTable();//切换数据库
						//inputTableDao itd=new inputTableDao();
						String WpName=otd.searchInput(idb.con,Edit_Bh.getText().trim());//按编号取一下名称
						if (!WpName.equals("")){//如果此编号已经录入过，那自动取出名称。
							Edit_Mc.setText(WpName);
							Edit_Mc.setEditable(false);
							Edit_Sl.requestFocus();
						}else {
							Edit_Mc.setText("");
							Edit_Mc.setEditable(true);
							Edit_Mc.requestFocus();
						} 
						
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			 
			
		});
		Edit_Bh.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//在这里查一下入库流水表，看看之前有没有输入过，如果有，那取名字
			    try {
			    	if (!Edit_Bh.getText().trim().equals("")) {
				    	//InitDatabase idb=new InitDatabase();//创建数据库初始化对象
						//idb.con=idb.getConnection(); //创建连接 
						idb.CrateTable();//切换数据库
						//inputTableDao itd=new inputTableDao();
						String WpName=otd.searchInput(idb.con,Edit_Bh.getText().trim());//按编号取一下名称
						if (!WpName.equals("")){
							if (Edit_Bh.isEnabled()) {
								Edit_Mc.setText(WpName);
								Edit_Mc.setEditable(false);
								Edit_Sl.requestFocus();
							}
						}else {
							if (!Edit_Bh.getText().trim().equals("")) {
								Edit_Mc.setText("");
								Edit_Mc.setEditable(true);
								Edit_Mc.requestFocus();
							}
						}
			    	}
			    }catch(SQLException e11) {
					e11.printStackTrace();
					return;
				}
			}
		});
		Edit_Mc = new JTextField();
		Edit_Mc.setFont(new Font("宋体", Font.PLAIN, 26));
		Edit_Mc.setColumns(10);
		Edit_Mc.setBounds(296, 10, 225, 29);
		panel.add(Edit_Mc);
		Edit_Mc.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					Edit_Sl.requestFocus(); //当按下了回车键时，btn1按钮被点击
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Edit_Mc.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//在这里查一下入库流水表，看看之前有没有输入过，如果有，那取名字
			    try {
			    	if (Edit_Mc.getText().trim().equals("")) {
				    	//InitDatabase idb=new InitDatabase();//创建数据库初始化对象
						//idb.con=idb.getConnection(); //创建连接 
						idb.CrateTable();//切换数据库
						//inputTableDao itd=new inputTableDao();
						String WpBh=otd.searchInputName(idb.con,Edit_Mc.getText().trim());
						if (!WpBh.equals("")){
							if (Edit_Mc.isEnabled()) {
								Edit_Bh.setText(WpBh);
								Edit_Bh.setEditable(false);
								Edit_Sl.requestFocus();
							}
						}else {
							if (Edit_Mc.getText().trim().equals("")) {
								Edit_Bh.setText("");
								Edit_Bh.setEditable(true);
								Edit_Bh.requestFocus();
							}
						}
			    	}
			    }catch(SQLException e11) {
					e11.printStackTrace();
				}
			}
			
		});
		
		
		
		JButton btn_Ck = new JButton("\u51FA\u5E93\u5F55\u5165");
		btn_Ck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //新增记录
				//1.合规检查
				if (Edit_Bh.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "编号不能为空，请输入编号！", "提示:", JOptionPane.INFORMATION_MESSAGE);
					Edit_Bh.requestFocus();
				    return; 	
				} 
				if (Edit_Mc.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "名称不能为空，请输入名称！", "提示:", JOptionPane.INFORMATION_MESSAGE);
					Edit_Mc.requestFocus();
				    return; 	
				} 
				if (Edit_Sl.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "数量不能为空，请输入数量！", "提示:", JOptionPane.INFORMATION_MESSAGE);
					Edit_Sl.requestFocus();
				    return; 	
				} 
				//2.合规通过，那插入记录
				//InitDatabase idb=new InitDatabase();//创建数据库初始化对象
				//idb.con=idb.getConnection(); //创建连接
			    try {
					idb.CrateTable();//切换数据库
					//outputTableDao itd=new outputTableDao();
					currentNumDao cnd=new currentNumDao();
					String Bz=otd.add(idb.con,Edit_Bh.getText().trim(),Edit_Mc.getText().trim(),Edit_Sl.getText().trim(),"",DLname);
					if (!Bz.equals("-1")) {
						JOptionPane.showMessageDialog(null, "编号与之前的名字不匹配！\n"+"之前此编号的名字为："+Bz, "提示:", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					Edit_Mc.setEditable(true);
					//显示记录
					table.setModel(new DefaultTableModel(
							otd.inputRowsDate(idb.con,Dp1.getText().trim(),Dp2.getText().trim()),
							otd.intputColumn(idb.con)
						));
					//即时库存表更新数据
					((SubCxForm)pFrame).table.setModel(new DefaultTableModel(
							cnd.currentNumRows(idb.con),
							cnd.currentNumColumn(idb.con)
						));
					//table.getRowCount();//取表的总行数
					//定位到最后一行
					table.addRowSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
					table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1, 0, true));
					table.setSelectionBackground(Color.LIGHT_GRAY);//选中行设置背景色
					
					Edit_Mc.setText("");//名称编辑框清空
					Edit_Bh.setText("");//编号编辑框清空
					Edit_Sl.setText("");//数量编辑框清空
					Edit_Bh.setEditable(true);
					Edit_Mc.setEditable(true);
					Edit_Bh.requestFocus();//名称编辑框设置焦
				    
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "记录添加失败！", "提示:", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
					return;
				}
				
			}
		});
		btn_Ck.setBounds(721, 6, 143, 39);
		panel.add(btn_Ck);
		btn_Ck.setFont(new Font("宋体", Font.PLAIN, 26));
		
		Edit_Sl = new JTextField();
		Edit_Sl.setFont(new Font("宋体", Font.PLAIN, 26));
		Edit_Sl.setColumns(10);
		Edit_Sl.setBounds(601, 10, 102, 29);
		panel.add(Edit_Sl);
		
		Edit_Sl.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btn_Ck.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		contentPane.setLayout(gl_contentPane);
		OutputForm.this.addWindowListener(this);
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// 窗口打开后执行这里的代码
		Edit_Bh.requestFocus();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 窗口关闭时执行这里的代码
		OutputForm.this.dispose();//关闭当前窗口
		OutputForm.this.pFrame.setEnabled(true); //父窗口设为可以活动
		OutputForm.this.pFrame.setVisible(true);  //父窗口显示到顶层
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// 在窗口关闭后要做的事件写在这里
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// 点击最小化按钮时执行这里的代码
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// 窗口最小化到任务栏上后，执行这里的代码
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// 窗口激活时执行这里的代码
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// 窗口失去焦点时执行这里的代码
	}
}
