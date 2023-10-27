//package demo;
//
///**
// * 生产者消费者模式是通过一个容器来解决生产者和消费者的强耦合问题。生产者和消费者彼此之间不直接通讯，而通过阻塞队列来进行通讯，
// * 所以生产者生产完数据之后不用等待消费者处理
// * ，直接扔给阻塞队列，消费者不找生产者要数据，而是直接从阻塞队列里取，阻塞队列就相当于一个缓冲区，平衡了生产者和消费者的处理能力。
// *
// * 优点 : 解耦
// *
// * @author 天亮教育-帅气多汁你泽哥
// * @Date 2023年10月26日
// */
//public class Thread_04_Producer {
//	public static void main(String[] args) {
//		SynStack ss = new SynStack();
//		Thread t1 = new Thread(new Producer(ss));
//		Thread t2 = new Thread(new Consumer(ss));
//		t1.start();
//		t2.start();
//	}
//}
//
//class Producer implements Runnable {
//	private SynStack ss;
//
//	public Producer(SynStack ss) {
//		this.ss = ss;
//	}
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 20; i++) {
//			ss.push((char) ('a' + i));
//		}
//	}
//}
//
//// 消费者线程
//class Consumer implements Runnable {
//	private SynStack ss;
//
//	public Consumer(SynStack ss) {
//		this.ss = ss;
//	}
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 20; i++) {
//			ss.pop();
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//// 业务类
//class SynStack {
//	// 缓冲区
//	char[] data = new char[6];
//	// 保存个数
//	int count = 0;
//
//	// 生产者 : 库存满了就停止生产
//	public synchronized void push(char ch) {
//		// 判断库存是否满了
//		if (count >= data.length) {
//			try {
//				// 如果满了则进入等待并交出锁
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		// 当库存为0时,说明消费者已经进入等待状态,那么就唤醒它
//		if (count == 0) {
//			this.notifyAll();
//		}
//		// 生产数据保存到库存
//		data[count] = ch;
//		count++;
//		System.out.println("生产了" + ch + ",剩余" + count + "件商品");
//	}
//
//	// 消费者 : 没有库存了就停止消费
//	public synchronized void pop() {
//		// 判断是否还有库存
//		if (count == 0) {
//			try {
//				// 如果没有库存则进入等待
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		// 判断生产者是否进入等待
//		if (count == 6) {
//			this.notifyAll();
//		}
//		count--;
//		char ch = data[count];
//		System.out.println("消费了" + ch + ",剩余" + count + "件商品");
//	}
//}