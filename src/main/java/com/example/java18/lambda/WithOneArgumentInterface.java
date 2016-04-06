package main.java.com.example.java18.lambda;

public class WithOneArgumentInterface {
	
	public static void main(String[] args){
		//OLD approach - 1
		State<String> s = new State<>();
		s.applyTax("T1");
		////OLD approach - 2
		Taxable<String> t = new Taxable<String>(){
			public void applyTax(String taxCode){
				System.out.println("State Tax is applied with taxcode - "+taxCode);
			}
		};
		t.applyTax("T2");
		
		//NEW approach - with Lambda
		Taxable<String> t2 = taxCode -> {
			System.out.println("State Tax is applied with taxcode - "+taxCode);
		};
		t2.applyTax("T3");
	}

}

interface Taxable<T>{
	void applyTax (T taxCode);
}

class State<T> implements Taxable<T>{

	@Override
	public void applyTax (T taxCode) {
		System.out.println("State Tax is applied with taxcode - "+taxCode);
	}
}