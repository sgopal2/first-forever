package main.java.com.example.java18.lambda;

public class LambdaWithRunnable {

	/**
	 * @author sgopal2
	 * Runnable interface is a 
	 * {@linkplain java.lang.FunctionalInterface
	 * <b>Functional Interface</b>}
	 * 
	 */
	public static void main(String[] args) {

		//Thread example 
		//OLD approach
		Runnable r = new Runnable (){
			public void run(){
				try{
					for(int i=0; i <= 10; i++){
						System.out.println("Counting "+i);
						Thread.sleep(500);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		///////////////////////////
		//NEW APPROACH - WITH LAMBDA
		Runnable r2 = () -> {
							try{
								for(int i=0; i <= 10; i++){
									System.out.println("Counting with lambda "+i);
									Thread.sleep(500);
								}
							}catch(Exception e){
								e.printStackTrace();
							}
						};
		Thread t2 = new Thread(r2);
		t2.start();
	}

}
