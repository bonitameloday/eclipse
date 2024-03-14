package sync;
class MyData{
	int data = 108;
	public void plusData() {
		
		synchronized(this) {//this는 키 값, 어떤 객체가 들어가든 상관없음
		int mydata = data;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		data = mydata + 1;
		}
	}
}
class PlusThread extends Thread {
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData = myData;
		
	}
	
	public void run() {
		myData.plusData();
		System.out.println(getName()+" 실행: " + myData.data);
	}
	
	
}
public class PlusThreadEx{
	public static void main(String[] args) {
		MyData myData = new MyData();
		
		//first thread
		Thread plusThread1 = new PlusThread(myData);
		plusThread1.setName("plusThread1");
		plusThread1.start();
		
		//second thread
		Thread plusThread2 = new PlusThread(myData); // myData가 임계영역 공유
		plusThread2.setName("plusThread2");
		plusThread2.start();
	}
}