package egg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyJFrame extends JFrame{
    public DrawComponent dc = new DrawComponent();

    public static void main(String[] args) {
        MyJFrame jmf= new MyJFrame();
        jmf.initUI();
    }

    private void initUI() {

        this.setSize(600,500);
        this.setDefaultCloseOperation(3);
        this.setTitle("我的彩蛋");
        JPanel jp = new JPanel();
        jp.setSize(50, 0);
        jp.setLayout(new FlowLayout());
        this.add(BorderLayout.SOUTH,jp);
        JLabel j1 = new JLabel("行数");
        JTextField jtf1 = new JTextField();
        jtf1.setPreferredSize(new Dimension(20,30));
        JLabel j2 = new JLabel("列数");
        JTextField jtf2 = new JTextField();
        jtf2.setPreferredSize(new Dimension(20,30));
        JButton jb = new JButton("确定");

        MyActionListener ma = new MyActionListener(dc,jtf1,jtf2);
        jb.addActionListener(ma);
        jp.add(j1);
        jp.add(jtf1);
        jp.add(j2);
        jp.add(jtf2);
        jp.add(jb);
        this.add(dc);

        this.setVisible(true);

    }

}