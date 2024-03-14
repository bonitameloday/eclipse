import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel{
	private int barSize = 0;
	private int maxBarSize;
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		
		int width=(int) (((double)(getWidth()))/maxBarSize*barSize);
		
	if(width==0) return;
	g.fillRect(0,0,width,this.getHeight());
		
		
	}
	synchronized void fill() {
		if(barSize==maxBarSize) {
			try {
				wait();
			}
			catch(InterruptedException e) {return;}
		}
		barSize++;
		repaint();
		notify();
	}
	synchronized void consume() {
		if(barSize==0) {
			try {
				wait();
			} catch(InterruptedException e) {return;}
			
		}
		barSize--;
		repaint();
		notify();
	}
}
class ConsumerThread extends Thread{
	private MyLabel bar;
	
	public ConsumerThread(MyLabel bar) {this.bar = bar;}
	
	public void run() {
		while(true) {
			try {
				sleep(500);
				bar.consume();
			}
			catch(InterruptedException e) {return;}
			}
		}
	}

public class TabAndThread extends JFrame {
	private MyLabel bar = new MyLabel(100);
	
	public TabAndThread(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
	
		
	}

}
