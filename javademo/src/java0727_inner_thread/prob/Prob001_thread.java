package java0727_inner_thread.prob;
/*[문제1] 자판기 프로그램을 만드시오

클래스명 : VendingMachine
               +getDrink():String
               +putDrink(drink String):void
클래스명 : Producer      <-- Thread상속
클래스명 : Consumer     <-- Thread상속
클래스명 : Prob001_thread.java
               VendingMachine vm=new VendingMachine();
     
               Producer p=new Producer(vm);
               Consumer c=new Consumer(vm);
     
		       Thread t1=new Thread(p, "생산자");
		       Thread t2=new Thread(c, "소비자");
		 
		       t1.start();
		       t2.start();
=============================================     
[출력화면]
생산자 : 음료수 No. 1 자판기에 넣기
소비자 : 음료수 No. 1 꺼내먹음
 
생산자 : 음료수 No. 2 자판기에 넣기
소비자 : 음료수 No. 2 꺼내먹음

생산자 : 음료수 No. 3 자판기에 넣기
소비자 : 음료수 No. 3 꺼내먹음
        :
        
생산자 : 음료수 No. 10 자판기에 넣기
소비자 : 음료수 No. 10 꺼내먹음
 */
 
class VendingMachine {
	private String drink;
	synchronized public String getDrink(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return drink;
	}
	synchronized public void putDrink(String drink){
		this.drink=drink;
		notifyAll();
	}

}//end VendingMachine
	
class Producer extends Thread {
	private VendingMachine vm;
	
	public Producer(VendingMachine vm) {
		this.vm=vm;
	}
	@Override
	public void run() {
		for(int i = 1;i<=10;i++){
			System.out.printf("%s : %s No. %d 자판기에 넣기\n",Thread.currentThread().getName(),"음료수",i);
			vm.putDrink("음료수");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}//end Producer

class Consumer extends Thread {
	private VendingMachine vm;
	
	public Consumer(VendingMachine vm) {
		this.vm=vm;
		
	}
	@Override
	public void run() {
		
		for(int i =1;i<=10;i++){
	/*		try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}*/
			System.out.printf("%s : %s No. %d 꺼내먹음\n",Thread.currentThread().getName(),vm.getDrink(),i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
	
}//end Consumer

public class Prob001_thread {

	public static void main(String[] args) {
		  VendingMachine vm=new VendingMachine();
		     
          Producer p=new Producer(vm);
          Consumer c=new Consumer(vm);

	       Thread t1=new Thread(p, "생산자");
	       Thread t2=new Thread(c, "소비자");
	 
	   
	       t1.start();
	       t2.start();
	}//end main()

}//end class
