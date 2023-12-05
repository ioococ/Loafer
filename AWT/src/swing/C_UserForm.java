package swing;

import manager.InitializeClass;
import manager.UserTableClass;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

//public class SubUserForm extends JFrame implements WindowListener{
public class C_UserForm extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JFrame PFrame;

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
     */
    public C_UserForm (JFrame PForm) throws SQLException {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(C_UserForm.class.getResource("/swing/user-circle.png")));
        this.PFrame = PForm;
        setTitle("\u7528\u6237\u67E5\u8BE2");
        //参数JFrame.EXIT_ON_CLOSE 为当窗口关闭时全部退出
        //参数JFrame.DISPOSE_ON_CLOSE 只关闭当前窗口，程序不全部退出
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //获取屏幕分辨率
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //设置窗口打开后在屏中的位置
        //setBounds((screenWidth - 997) / 2, (screenHeight - 643) / 2 - 100, 997, 604);
        setBounds(100, 100, 900, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u7528\u6237\u8868");
        lblNewLabel.setBackground(Color.GRAY);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.WHITE);

        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        table.setBorder(null);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        UserTableClass utc = new UserTableClass();
        InitializeClass ic = new InitializeClass();
        table.setModel(new DefaultTableModel(
                utc.userRows(ic.conn),
                utc.userColumn(ic.conn)
        ));
//        table.setModel(new DefaultTableModel(
//        	new Object[][] {
//        		{null, null, null, null, null},
//        		{null, null, null, null, null},
//        		{null, null, null, null, null},
//        	},
//        	}
//        ));
        table.setBackground(Color.WHITE);
        scrollPane.setViewportView(table);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        					.addGap(40))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(783, Short.MAX_VALUE))
        				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        
                JButton B_Add = new JButton("增加用户");
                panel.add(B_Add);
                B_Add.setBackground(Color.WHITE);
                B_Add.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e) {
                    }
                });
                        B_Add.setFont(new Font("微软雅黑", Font.PLAIN, 18));
                
                        JButton B_Modify = new JButton("修改密码");
                        panel.add(B_Modify);
                        B_Modify.setBackground(Color.WHITE);
                        B_Modify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
                        
                                JButton B_Delete = new JButton("删除用户");
                                panel.add(B_Delete);
                                B_Delete.setBackground(Color.WHITE);
                                B_Delete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        contentPane.setLayout(gl_contentPane);
    }
}
