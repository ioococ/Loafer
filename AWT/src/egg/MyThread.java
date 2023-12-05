package egg;

class MyThread extends Thread{
    public DrawComponent dc;

    public MyThread(DrawComponent dc){
        this.dc = dc;
    }

    public void run(){
        while (true){
            this.dc.repaint();
        }
    }
}