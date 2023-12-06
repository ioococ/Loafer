package egg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyActionListener implements ActionListener {

    public JTextField jtf1,jtf2;
    public DrawComponent dc;
    private MyThread m1;

    public MyActionListener(DrawComponent dc,JTextField jtf1, JTextField jtf2) {
        this.dc = dc;
        this.jtf1 = jtf1;
        this.jtf2 = jtf2;
    }

    public void actionPerformed(ActionEvent e) {
        //得到文本框的文本值
        int row = Integer.parseInt(this.jtf1.getText());
        int column = Integer.parseInt(this.jtf2.getText());

        //启动线程
        if(m1 == null){
            m1 = new MyThread(this.dc);
            m1.start();
        }
        this.dc.setColumn(column);
        this.dc.setRow(row);
    }

}