package egg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class DrawComponent extends JComponent {
    private int row =0,column = 0;

    //÷ÿªÊ∑Ω∑®
    public void paintComponent(Graphics g) {
        this.setPreferredSize(new Dimension(400,400));
        Random rand = new Random();
        for(int i = 0;i<this.row;i++){
            for(int j = 0;j<this.column;j++){
                int r1 = rand.nextInt(256);
                int g1 = rand.nextInt(256);
                int b1 = rand.nextInt(256);
                Color c = new Color(r1,g1,b1);
                g.setColor(c);
                g.fillOval(j*100+100, i*50+50, 100, 50);
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}