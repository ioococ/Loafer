package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.eltima.components.ui.DatePicker;
import manager.CurrentTableClass;
import manager.InitializeClass;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class C_Query extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JFrame PFrame;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QueryClass frame = new QueryClass();
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
    public C_Query (JFrame PFrame) throws SQLException {
        setTitle("查询");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 560);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu M_table = new JMenu("库操作");
        M_table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        menuBar.add(M_table);

        JMenuItem MI_input = new JMenuItem("入库");
        MI_input.setIcon(new ImageIcon(C_Query.class.getResource("/swing/arrow-alt-circle-right.png")));
        MI_input.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_table.add(MI_input);
        MI_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_Input ci = null;
                try {
                    ci = new C_Input();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ci.setVisible(true);
            }});

        JMenuItem MI_output = new JMenuItem("出库");
        MI_output.setIcon(new ImageIcon(C_Query.class.getResource("/swing/arrow-alt-circle-left.png")));
        MI_output.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_table.add(MI_output);
        MI_output.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_Output co = null;
                try {
                    co = new C_Output(C_Query.this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                co.setVisible(true);
            }});

        JMenu M_user = new JMenu("用户操作");
        M_user.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        menuBar.add(M_user);
        M_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_UserForm suf = null;
                try {
                    suf = new C_UserForm(C_Query.this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                suf.setVisible(true);
            }});

        JMenuItem MI_query = new JMenuItem("用户查询");
        MI_query.setIcon(new ImageIcon(C_Query.class.getResource("/swing/user-circle.png")));
        MI_query.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_user.add(MI_query);
        MI_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_UserForm suf = null;
                try {
                    suf = new C_UserForm(C_Query.this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                suf.setVisible(true);
            }});

        JMenuItem MI_create = new JMenuItem("创建用户");
        MI_create.setIcon(new ImageIcon(C_Query.class.getResource("/swing/user-add.png")));
        MI_create.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_user.add(MI_create);
        MI_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_NewUser co =new C_NewUser(C_Query.this);
                co.setVisible(true);
            }});

        JMenuItem MI_modify = new JMenuItem("修改密码");
        MI_modify.setIcon(new ImageIcon(C_Query.class.getResource("/swing/key.png")));
        MI_modify.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_user.add(MI_modify);
        MI_modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_ModifyUser co =new C_ModifyUser(C_Query.this);
                co.setVisible(true);
            }});

        JMenuItem MI_delete = new JMenuItem("删除用户");
        MI_delete.setIcon(new ImageIcon(C_Query.class.getResource("/swing/trash.png")));
        MI_delete.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        M_user.add(MI_delete);
        MI_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent) {
                C_DeleteUser co = null;
                try {
                    co = new C_DeleteUser(C_Query.this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                co.setVisible(true);
            }});

        JMenu M_help = new JMenu("帮助");
        M_help.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        menuBar.add(M_help);

//        JMenuItem MI_about = new JMenuItem("关于");
//        MI_about.setIcon(new ImageIcon(C_Query.class.getResource("/swing/info-circle.png")));
//        MI_about.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
//        M_help.add(MI_about);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel("即时库存查询");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                .addGap(697))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addGap(18)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        panel.setLayout(null);

        JButton B_input = new JButton("入库");
        B_input.setBounds(591, 20, 110, 30);
        B_input.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_input.setBackground(Color.WHITE);
        panel.add(B_input);

        JButton B_output = new JButton("出库");
        B_output.setBounds(705, 20, 110, 30);
        B_output.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_output.setBackground(Color.WHITE);
        panel.add(B_output);

        JButton B_Query = new JButton("查询");
        B_Query.setBounds(384, 20, 110, 30);
        B_Query.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        B_Query.setBackground(Color.WHITE);
        panel.add(B_Query);
        B_Query.addActionListener(new ActionListener(){ // 鼠标 监听 按下
            public void actionPerformed(ActionEvent e) {
                if (true){
                    JOptionPane.showMessageDialog(null, "操作成功","消息提示",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "操作失败","消息提示",JOptionPane.ERROR_MESSAGE);
                }}});

        textField = new JTextField();
        textField.setBounds(156, 22, 204, 30);
        panel.add(textField);
        textField.setColumns(10);

        DatePicker datePicker = new DatePicker();
        datePicker.setBounds(156, 20, 204, 33);
        panel.add(datePicker);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        comboBox.setBounds(39, 23, 107, 30);
        panel.add(comboBox);

        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        CurrentTableClass ctc = new CurrentTableClass();
        InitializeClass ic = new InitializeClass();
        table.setModel(new DefaultTableModel(
                ctc.currentNumRows(ic.conn),
                ctc.currentNumColumn(ic.conn)
        ));
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
