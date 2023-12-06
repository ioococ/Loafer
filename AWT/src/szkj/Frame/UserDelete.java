package szkj.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import szkj.dao.InitDatabase;
import szkj.dao.userTableDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDelete extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JFrame pFrame;
	private JTextField textField;
	public  String DLname;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserDelete frame = new UserDelete();
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
	public UserDelete(JFrame pFrame) {
		this.pFrame=pFrame;
		if (pFrame.getClass().getName()=="Frame.SubCxForm") {
			   this.DLname=((SubCxForm)pFrame).DLname;//登录的用户名
		}else if (pFrame.getClass().getName()=="Frame.SubUserForm") {
				this.DLname=((SubUserForm)pFrame).DLname;//登录的用户名
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//获取屏幕分辨率
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize();//获取可视区域的大
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
//		//设置窗口打开后在屏中的位置
		setBounds((screenWidth-261)/2, (screenHeight-196)/2, 261, 196);	
//		setBounds(100, 100, 261, 196);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 219, 24);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(10, 44, 234, 30);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if (textField.getText().trim().equals("")) {
				   JOptionPane.showMessageDialog(null,"请输入要删除的用户名！","提示：",JOptionPane.INFORMATION_MESSAGE);
				   return;
			   }
			   if (textField.getText().toUpperCase().equals("SUPER")) {
				   JOptionPane.showMessageDialog(null,"Super是系统用户，不能删除！","提示：",JOptionPane.INFORMATION_MESSAGE);
				   return;
			   }else {
				    InitDatabase idb =new InitDatabase();
					idb.con=idb.getConnection();
			        try {
						idb.CreateDataBase(); //切换数据库到testkc
						userTableDao utd=new userTableDao();
						utd.deleteUser(idb.con,textField.getText().trim());//删除用户
						if (pFrame!=null) {
							//JOptionPane.showMessageDialog(null,pFrame.getClass().getName(),"提示：",JOptionPane.INFORMATION_MESSAGE);
							if (pFrame.getClass().getName().equals("Frame.SubUserForm")) {//如果父窗口是SubUserForm刷新表格
								//((SubUserForm)pFrame).UserTable.removeAll();
							    ((SubUserForm)pFrame).UserTable.setModel(new DefaultTableModel(
										utd.userRows(idb.con),
										utd.userColumn(idb.con)
								)); //刷新表格内容
							}
							textField.setText("");
						    textField.requestFocus();
						    JOptionPane.showMessageDialog(null,"用户删除成功！","提示：",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"ddddddd","提示：",JOptionPane.INFORMATION_MESSAGE);
						}
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"用户删除失败","提示：",JOptionPane.INFORMATION_MESSAGE);
						e2.printStackTrace();
						return;
					}
		 
			   }
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setBounds(69, 102, 113, 47);
		contentPane.add(btnNewButton);
		this.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null,"过","提示：", JOptionPane.ERROR_MESSAGE);
		UserDelete.this.dispose();//关闭并释放当前窗口
		this.pFrame.setEnabled(true);//父窗口置为活动
	    this.pFrame.setVisible(true);;//父窗口显示
	    ((SubCxForm)this.pFrame).textF1.requestFocus();//父窗口编辑框获得焦点
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
