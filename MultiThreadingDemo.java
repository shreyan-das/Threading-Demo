
public class MultiThreadingDemo {

	public static void main(String[] args) {
		int sum = 0;
		
		counterThread taskRunnerA = new counterThread("A", "Thread A");
		taskRunnerA.start();
		
		counterThread taskRunnerB = new counterThread("B", "Thread B");
		taskRunnerB.start();
		
		counterThread taskRunnerC = new counterThread("C", "Thread C");
		taskRunnerC.start();
	}

}
class counterThread implements Runnable{
	int sum = 0;
	String threadNum;
	Thread threader;
	private String names;
	counterThread(String threadNumIn, String name) {
		threadNum = threadNumIn;
		names = name;
	}
	@Override
	public void run() {
		for ( int i = 0; i <= 10; i++) {
			sum = sum + i;
			System.out.println("Thread : "+ threadNum + " - Sum : " + sum);
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("abort");
		}
		}
		System.out.println("Thread : "+ threadNum + " - Sum : " + sum);
	}
	public void start() {
		if(threader == null) {
			threader = new Thread(this, names);
			threader.start();
		}
	}
	}
